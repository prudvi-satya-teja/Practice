package com.example.nativequery.specifications;

import com.example.nativequery.entity.UserAddress;
import com.example.nativequery.entity.UserDetails;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;


public class UserSpecification  {

    public static Specification<UserDetails> equalsPhone(String phoneNumber) {
        return (Root<UserDetails> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
                return cb.equal(root.get("phoneNumber"), phoneNumber);
        };
    }

    public static Specification<UserDetails> equalsEmail(String email) {
        return (Root<UserDetails> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            return cb.equal(root.get("email"), email);
        };
    }

    public static Specification<UserDetails> equalsUserName(String userName) {
        return (Root<UserDetails> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            return cb.equal(root.get("name"), userName);
        };
    }

    public static Specification<UserDetails> joinAddress() {
        return (Root<UserDetails> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Join<UserDetails, UserAddress> address = root.join("userAddress", JoinType.INNER);
            return null;
        };
    }
}


