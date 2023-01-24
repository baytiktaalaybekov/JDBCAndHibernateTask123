package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    public static SessionFactory getSessionFactory(){
        Properties properties =new Properties();
        properties.put(Environment.DRIVER,"org.hibernate.dive");
        properties.put(Environment.URL,"jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER,"postgres");
        properties.put(Environment.PASS,"12345");

        properties.put(Environment.HBM2DDL_AUTO,"create");
        properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgresSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        return configuration.buildSessionFactory();
    }


    }

