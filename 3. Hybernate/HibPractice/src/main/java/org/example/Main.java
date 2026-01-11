package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Faculty faculty = new Faculty();
        faculty.setId(2);
        faculty.setName("prduvi");
        faculty.setAge(959);
        faculty.setSalary(10000);

        SessionFactory sf =  new Configuration().addAnnotatedClass(Faculty.class).configure("hibernate.cfg.xml").buildSessionFactory();
        Session session =  sf.openSession();

        Transaction tx = session.beginTransaction();
//        session.remove(faculty);

//        session.merge(faculty);

        List<Faculty> faculties = session.createQuery("from Faculty").list();


        System.out.println(faculties);

    }
}