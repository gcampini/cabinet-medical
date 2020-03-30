package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.MetadataSources;

public class DBUtil {


    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    public static void init(){
        serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();
    }
}
