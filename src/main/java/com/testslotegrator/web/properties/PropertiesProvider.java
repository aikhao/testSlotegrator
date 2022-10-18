package com.testslotegrator.web.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesProvider {

    private static PropertiesProvider instance;
    private Properties properties;
    private Properties users;

    public PropertiesProvider() {
        try {
            properties = new Properties();
            users = new Properties();

            setProperties(System.getProperties());

            final File local_prop_file = new File("local.properties");

            if (local_prop_file.exists()) {
                Properties prop_local = new Properties();
                prop_local.load(new FileInputStream(local_prop_file));
                setProperties(prop_local);
            } else {
                throw new FileNotFoundException("File " + local_prop_file + " not found");
            }

            final File users_prop_file = new File("users.properties");
            Properties users_from_file = new Properties();

            if (users_prop_file.exists()) {
                users_from_file.load(new FileInputStream(users_prop_file));
                setUsers(users_from_file);
            } else {
                throw new FileNotFoundException("File " + users_prop_file + " not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PropertiesProvider getInstance() {
        if (instance == null) {
            instance = new PropertiesProvider();
        }
        return instance;
    }

    private static Properties getProperties() {
        return getInstance().properties;
    }

    private void setProperties(Properties properties_new) {
        properties_new.forEach(
            (Object key, Object value) -> {
                if (!properties.containsKey(key)) {
                    properties.setProperty(key.toString(), value.toString());
                }
            }
        );
    }

    public static String getProperty(String propertyName){
        if (getProperties().containsKey(propertyName)) {
            return getProperties().getProperty(propertyName);
        } else {
            throw new IllegalArgumentException(String.format("Cannot find property %s", propertyName));
        }
    }

    public static void setProperty(String key, String value){
        getProperties().setProperty(key, value);
    }

    private static Properties getUsers() {
        return getInstance().users;
    }

    private void setUsers(Properties users_new) {
        users_new.forEach(
            (Object key, Object value) -> {
                if (!users.containsKey(key)) {
                    users.setProperty(key.toString(), value.toString());
                }
            }
        );
    }

    public static String getUserLogin(String userName) {
        if (getUsers().containsKey(userName + ".login")) {
            return getUsers().getProperty(userName + ".login");
        } else {
            throw new IllegalArgumentException(String.format("Cannot find user login %s", userName));
        }
    }

    public static String getUserPassword(String userName) {
        if (getUsers().containsKey(userName + ".password")) {
            return getUsers().getProperty(userName + ".password");
        } else {
            throw new IllegalArgumentException(String.format("Cannot find user password %s", userName));
        }
    }

    public static void setUser(String key, String value) {
        getUsers().setProperty(key, value);
    }
}
