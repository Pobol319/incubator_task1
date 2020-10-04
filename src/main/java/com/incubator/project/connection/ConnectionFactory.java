package com.incubator.project.connection;

import com.incubator.project.exceptions.ConnectionFactoryException;
import com.incubator.project.exceptions.PropertyReaderException;
import com.incubator.project.property.PropertyReader;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String DATABASE_PROPERTIES_PATH = "database.properties";
    private static final String URL_PROPERTY = "dbURrl";
    private static final String USER_PROPERTY = "user";
    private static final String PASSWORD_PROPERTY = "password";

    private static String url;
    private static String user;
    private static String password;

    ConnectionFactory() {
        try {
            PropertyReader propertyReader = new PropertyReader(DATABASE_PROPERTIES_PATH);
            url = propertyReader.read(URL_PROPERTY);
            user = propertyReader.read(USER_PROPERTY);
            password = propertyReader.read(PASSWORD_PROPERTY);
        } catch (PropertyReaderException e) {
            throw new ConnectionFactoryException("Error with creation of connection", e);
        }
    }

    public Connection create() {
        Connection connection;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new ConnectionFactoryException("Error with creation of connection", e);
        }
        return connection;
    }
}
