package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        Student s1 = new Student(9, "prudvi", 10);w
//        Student s2 = new Student(78, "dhanu", 20);
//
//        Address a1 = new Address();
//        a1.setAddressId(99);
//        a1.setCity("kakinada");
//        a1.setState("ap");
//        a1.setVillage("gummaregula");
//
//        Address a2 = new Address();
//        a2.setAddressId(356);
//        a2.setCity("kakinada");
//        a2.setState("ap");
//        a2.setVillage("gummaregula");
//
//        s1.getAddresses().add(a1);
//        s1.getAddresses().add(a2);


        SessionFactory sf =  new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .addAnnotatedClass(org.example.Address.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        // one to one mapping
        Transaction tx = session.beginTransaction();


//        session.persist(s1);
//        session.persist(s2);
//        session.persist(a1);
//        session.persist(a2);
//        System.out.println(a2 + " a2 ids");
//
        Student student = session.find(org.example.Student.class, 9);
        System.out.println(student);

        tx.commit();

        session.close();

        Session session1 = sf.openSession();

        Student student1 = session1.find(org.example.Student.class, 9);
        System.out.println(student1);


        session1.close();






//        Session session1 = sf.openSession();
//        int id = 1000;
//        Query query = session1.createQuery("select name,score  From Student where id < ?1");
//        query.setParameter(1, id);
//        List<Object[]> s5 = query.getResultList();
//        System.out.println(s5);
//        for(Object[] o:s5){
//            System.out.println(o[0]+" "+o[1]);
//        }




//        session1.close();
        sf.close();


    }
}




// insertion
//        Transaction tx = session.beginTransaction();
//        session.persist(s1);
//        tx.commit();

//        List<Student> students = session.createQuery("from Student").list();
// fetching
//        s2 = session.find(org.example.Student.class,28);

// fetching and  upadate
//        Transaction tx = session.beginTransaction();
//        s2 = session.merge(s1);
//        tx.commit();

// deleting
//        Transaction tx = session.beginTransaction();
//        session.remove(s1);
//        tx.commit();


