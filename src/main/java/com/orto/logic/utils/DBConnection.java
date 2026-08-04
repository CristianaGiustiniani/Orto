package com.orto.logic.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private DBConnection() {}

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/orto";
        String user = "orto";
        String password = "orto";
        return DriverManager.getConnection(url, user, password);
    }
}
