package ru.msu.cmc.java_web.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.msu.cmc.java_web.models.*;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration().configure()
                    .addAnnotatedClass(admin.class)
                    .addAnnotatedClass(book_copies.class)
                    .addAnnotatedClass(books.class)
                    .addAnnotatedClass(reader_story.class)
                    .addAnnotatedClass(readers.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
