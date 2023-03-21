package gb.homeworks;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

//    static {
//        final StandardServiceRegistry registryBuilder = new StandardServiceRegistryBuilder().configure().build();
//
//        try {
//            sessionFactory = new MetadataSources(registryBuilder).buildMetadata().buildSessionFactory();
//        } catch (Exception ex) {
//            StandardServiceRegistryBuilder.destroy(registryBuilder);
//        }
//    }

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Student.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                                                                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception ex) {
                System.out.println("не удалось создать Session Factory");
            }
        }

        return sessionFactory;
    }
}
