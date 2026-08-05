package com.orto.logic.model.dao.db;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.EmailAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.UsernameAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAODB implements UserDAO {
    @Override
    public User getUser(String email, String password) throws ConnectionException, WrongPasswordException, WrongEmailException {
        String query = "SELECT id, username, name, surname, password FROM buyer WHERE email = ?";

        User user;

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("password"));
                user.checkPassword(password);
                return user;
            } else {
                throw new WrongEmailException();
            }
        } catch (SQLException e) {
            throw new ConnectionException();
        }
    }

    @Override
    public void createUser(User user, String email, String password) throws ConnectionException, UsernameAlreadyExistsException, EmailAlreadyExistsException {
        String query = "INSERT INTO buyer (username, name, surname, email, password) VALUES (?, ?, ?, ?, ?)";

        try (   Connection conn = DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, email);
            ps.setString(5, password);

            ps.executeUpdate();
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                String message = e.getMessage();

                if (message.contains("username")) {
                    throw new UsernameAlreadyExistsException();
                } else if (message.contains("email")) {
                    throw new EmailAlreadyExistsException();
                }
            }
            throw new ConnectionException();
        }
    }
}
