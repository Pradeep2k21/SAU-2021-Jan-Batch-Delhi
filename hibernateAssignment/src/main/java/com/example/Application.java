package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void Save()
    {
        Alien Ali = new Alien("Pradeep","Black");

        Alien Ali1 = new Alien("Pankaj","Blue");


        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(Ali);
        session.save(Ali1);
        System.out.println(Ali);
        tx.commit();
    }


    public static void Retrieve()
    {
        Alien Ali;

        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Ali =(Alien)session.get(Alien.class,1);
        System.out.println(Ali);
        tx.commit();
    }

    public static void implementFLC()
    {
        Alien Ali= new Alien();

        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Ali = (Alien) session.get(Alien.class,1);
        System.out.println(Ali);
        Ali = (Alien)session.get(Alien.class,1);
        System.out.println((Ali));
        tx.commit();
    }
    public static void implementSLC()
    {
        Alien ALi;

        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        ALi = session.get(Alien.class,1);
        System.out.println(ALi);
        tx.commit();

        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        ALi = session.get(Alien.class,1);
        System.out.println(ALi);
        tx1.commit();
    }

    public static void implementQuery()
    {
        Alien Ali = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();

        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where aid = 1");
        q1.setCacheable(true);
        Ali = (Alien) q1.uniqueResult();
        System.out.println(Ali);
        tx1.commit();

        Session session2 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid = 2");
        q2.setCacheable(true);
        Ali = (Alien) q2.uniqueResult();
        System.out.println(Ali);
        tx2.commit();
    }

    public static void main(String [] args)
    {
        //Save();
        //Retrieve();
        //implementFLC();
        //implementSLC();
        implementQuery();
    }

}