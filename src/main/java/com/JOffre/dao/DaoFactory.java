package com.JOffre.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DaoFactory {
    //properties file constants keys (envDB is key value file)
    private static final String PROPERTIES_FILE      = "/com/ensias/dao/envDB.properties";
    private static final String PROPERTY_URL         = "URL";
    private static final String PROPERTY_DRIVER      = "DRIVER";
    private static final String PROPERTY_USERNAME    = "DBUSER";
    private static final String PROPERTY_PASSWORD    = "DBPASSWORD";

    private String DBUrl = "jdbc:mysql://localhost:3306/ensias";
    private String DBUser = "root";
    private String DBPassword = "root";

    DaoFactory(String url, String username, String password) {
        this.DBPassword = password;
        this.DBUser = username;
        this.DBUrl = url;
    }

    public static DaoFactory getFactory() throws DaoConfigurationException {//notice: factory is a singleton
        Properties properties = new Properties();
        String url;
        String driver;
        String username;
        String password;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            throw new DaoConfigurationException("properties file " + PROPERTIES_FILE + " not found.");
        }

        try {
            properties.load(propertiesFile);
            url = properties.getProperty(PROPERTY_URL);
            driver = properties.getProperty(PROPERTY_DRIVER);
            username = properties.getProperty(PROPERTY_USERNAME);
            password = properties.getProperty(PROPERTY_PASSWORD);
        } catch (IOException e) {
            throw new DaoConfigurationException("properties file can't be loaded " + PROPERTIES_FILE, e);
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DaoConfigurationException("Driver not found", e);
        }

        DaoFactory instance = new DaoFactory(url, username, password);
        return instance;
    }

    //after factory initialisation values and loading driver we need to get a connection
    Connection getConnection() throws SQLException {
        return DriverManager.getConnection( DBUrl, DBUser, DBPassword );
    }

    //get your Object table model here (get the implementation)
    public IOffreDao getOfferDao() {
        return new OffreDaoImpl(this);
    }
//    public IUserDao getUserDao() {
//        return new UserDaoImpl(this);
//    }


}
