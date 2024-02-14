package org.example.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCProvider {

    private static Connection connection;

    private final static ResourceBundle resource = ResourceBundle.getBundle("database");

    private static final String url_key = "url";
    private static final String user_key = "user";
    private static final String password_key = "password";


    private static final String url = getValue(url_key);
    private static final String user = getValue(user_key);
    private static final String password = getValue(password_key);

    private static String getValue(String key){
        return resource.getString(key);
    }

    public static Connection getConnection(){
        try{
            if (connection == null) {
                connection = DriverManager.getConnection(url, user, password);
            }
            return connection;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
