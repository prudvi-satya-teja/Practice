package com.dracarys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernatePro {

    public static void main(String[] args) {
        Student s1 = new Student(1, "Prudvi", 45);

        Configuration con= new Configuration().configure();
        SessionFactory sf =  con.buildSessionFactory();
        Session session = (Session) sf.openSession();

        session.beginTransaction();
        session.persist(s1);
        session.getTransaction().commit();

    }
}
