/*
 * Java Web Programming
 * Modul 6: Klijentsko programiranje
 * Assignment:  Kreiranje web prodavnice    
 */
package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Aleksandar Stosic / ita16.aleksandarstosic
 * 
 */

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration config = new Configuration().configure();

                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
                sessionFactory = config.buildSessionFactory(serviceRegistry);
            }

        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return sessionFactory;
    }
}
