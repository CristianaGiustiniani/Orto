package com.orto.logic.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class DBConnection {
    private DBConnection() {}

    private static String url;
    private static String user;
    private static String password;

    static {
        loadCredentials();
    }

    private static void loadCredentials() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(DBConnection.class.getResourceAsStream("/database-config.xml"));
            
            url = doc.getElementsByTagName("url").item(0).getTextContent();
            user = doc.getElementsByTagName("user").item(0).getTextContent();
            password = doc.getElementsByTagName("password").item(0).getTextContent();
        } catch (Exception e) {
            throw new RuntimeException("Failed to load database credentials from XML", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
