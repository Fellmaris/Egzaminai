package provider;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class SessionFactoryProvider {
    private static SessionFactoryProvider instance;
    private SessionFactory sessionFactory;

    private SessionFactoryProvider(){
        try {
        Configuration configuration = new Configuration();
        Properties properties = createProperties();
        configuration.addAnnotatedClass(Result.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Exam.class);
        configuration.addAnnotatedClass(Statistics.class);
        configuration.addAnnotatedClass(TestEgzamAnswers.class);
        configuration.addAnnotatedClass(TestEgzamTrueAnswers.class);
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(properties).build();
        sessionFactory = configuration.buildSessionFactory(registry);

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static SessionFactoryProvider getInstance() {
        if(instance == null) {
            instance = new SessionFactoryProvider();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Properties createProperties() {
        Properties properties = new Properties();

        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/egzams");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "admin");
        properties.put(Environment.SHOW_SQL, "true");
//        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");

        return properties;
    }
}
