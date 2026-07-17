package com.orto.logic.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    /*
    * Utility holder for Connection singleton
    * */
    private static Connection connection;

    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Replace with your actual DB credentials
            String url = "jdbc:mysql://localhost:3306/collectible";
            String user = "collectible";
            String password = "collectible";
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}
