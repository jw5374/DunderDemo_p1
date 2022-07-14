package com.dunderdemo.util;

import java.io.IOException;

import com.dunderdb.DunderSession;
import com.dunderdb.DunderSessionFactory;
import com.dunderdb.config.Configuration;
import com.dunderdemo.democlasses.Demo;
import com.dunderdemo.democlasses.Demo2;

public class DunderUtil {

    private static DunderSessionFactory sf;

    static {
        Configuration config;
        try {
            /****** programmatic method ******/
            // config = new Configuration();
            // config.createConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            // config.setConnectionDriver("org.postgresql.Driver");
            // config.setConnectionSchema("dunderdemodb");

            config = new Configuration("config.properties");
            config.addAnnotatedClass(Demo.class); // adding annotated classes
            config.addAnnotatedClass(Demo2.class);
            config.setupDatabase(); // creating the tables from the classes
            sf = config.getSessionFactory(); // creating a sessionfactory from which the user can get a new session
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method used by the user to get a session from this utility
    public static DunderSession getSession() {
        return sf.openSession();
    }
}
