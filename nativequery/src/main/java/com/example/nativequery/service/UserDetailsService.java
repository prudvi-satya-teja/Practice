package com.example.nativequery.service;


import com.example.nativequery.dto.UserDetailsDTO;
import com.example.nativequery.entity.UserAddress;
import com.example.nativequery.entity.UserDetails;
import com.example.nativequery.repository.UserDetailsRepository;
import com.example.nativequery.specifications.UserSpecification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public UserDetailsService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public UserDetails save(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }


    public List<UserDetailsDTO> findById(String name) {
        List<Object> parameters = new ArrayList<>();
        StringBuilder query = new StringBuilder("select user_name, user_email from user_details");
        query.append(" where 1 = 1");

        if(name != null) {
            query.append("and user_name = ?");
            parameters.add(name);
        }

        query.append(" order by user_name");
        query.append(" limit 5 offset 1");
        Query nativeQuery = entityManager.createNativeQuery(query.toString());

        for(int i=0;i<parameters.size();i++) {
            nativeQuery.setParameter(i+1, parameters.get(i));
        }

        List<Object[]> result =  nativeQuery.getResultList();
        return result.stream()
                .map(obj -> new UserDetailsDTO((String)obj[0], (String)obj[1]))
                .collect(Collectors.toList());
    }


    public List<UserDetails> findByName(String name) {
        System.out.println("Hello this is the defulat query");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDetails> cq = cb.createQuery(UserDetails.class);

        Root<UserDetails> root = cq.from(UserDetails.class);
        Join<UserDetails, UserAddress> join = root.join("userAddress", JoinType.INNER);
        cq.select(root);

        Predicate predicate = cb.equal(root.get("name"), name);
        Predicate predicate2 = cb.equal(root.get("email"), name);
        cq.where(cb.and(predicate, predicate2));
        cq.orderBy(cb.desc(root.get("name")));

        TypedQuery<UserDetails> query = entityManager.createQuery(cq);
        query.setFirstResult(0);
        query.setMaxResults(5);
        return query.getResultList();
    }

    public List<UserDetails> findByNameSpecification(String name) {
        Specification<UserDetails> result = Specification.where(UserSpecification.joinAddress())
                .and(UserSpecification.equalsEmail(name))
                .and(UserSpecification.equalsUserName(name));

        return userDetailsRepository.findAll(result);
    }


}
