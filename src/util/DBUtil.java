package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DBUtil {


    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    public static void init(){
        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.close();
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
