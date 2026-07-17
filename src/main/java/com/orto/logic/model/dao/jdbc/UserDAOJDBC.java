package com.orto.logic.model.dao.jdbc;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.entity.User;
import com.orto.logic.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOJDBC implements UserDAO {
    @Override
    public User verifyUser(String username, String password) throws Exception {
        //query
        String query = "SELECT (Username, Password) FROM user WHERE Username = ? AND Password = ?";
        //setup connection
        try (Connection conn = DBConnection.getConnection();
            //setup prepared statement
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            //execute query
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            throw new Exception("Error verifying user: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void saveUser(User user) throws Exception {
        //query
        String query = "INSERT INTO user (Username, Email, Password) VALUES (?, ?, ?)";
        //setup connection
        try (Connection conn = DBConnection.getConnection();
             //setup prepared statement
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(2, user.getPassword());

            //execute query
            ps.executeQuery();
        } catch (SQLException e) {
            throw new Exception("Error saving user: " + e.getMessage());
        }
    }
}
