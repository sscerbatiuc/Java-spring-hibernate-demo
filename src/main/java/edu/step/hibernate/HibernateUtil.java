package edu.step.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            AnnotationConfiguration hibernateConfig = new AnnotationConfiguration().configure(new File("src\\main\\resources\\hibernate.cfg.xml"));
            return hibernateConfig.buildSessionFactory();

        } catch (Exception ex) {
            System.out.println("Eroare: aplicatia nu poate fi configurata");
            throw new RuntimeException("Fatal error!");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }

}
