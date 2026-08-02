package com.orto.logic.model.dao.db;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.User;
import com.orto.logic.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAODB implements UserDAO {
    @Override
    public User getUser(String username, String password) throws Exception {
        //query
        String query = "SELECT (email, password) FROM buyer WHERE email = ? AND password = ?";
        //setup connection
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);

            //execute query
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("surname"));
            }
        } catch (SQLException e) {
            throw new ConnectionException();
        }
        return null;
    }
}
