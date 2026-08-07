package com.orto.logic.model.dao.filesystem;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.exceptions.*;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserDAOFS implements UserDAO {
    private static final String PATHNAME = "users.txt";

    @Override
    public User getUser(String email, String password) throws ConnectionException, WrongPasswordException, WrongEmailException {
        initializeFile();
        try {
            List<String> lines = Files.readAllLines(Paths.get(PATHNAME));
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",", 5);

                if (parts.length == 5) {
                    String username = parts[0];
                    String name = parts[1];
                    String surname = parts[2];
                    String storedEmail = parts[3];
                    String hashedPassword = parts[4];

                    if (storedEmail.equals(email)) {
                        User user = new User(username, name, surname, hashedPassword);
                        user.checkPassword(password);
                        return user;
                    }
                }
            }
            throw new WrongEmailException();
        } catch (IOException e) {
            throw new ConnectionException();
        }
    }

    public static User getUser() throws NoRememberedUserException, ConnectionException {
        File file = new File(PATHNAME);
        try {
            if (file.exists()) {
                List<String> lines = Files.readAllLines(Paths.get(PATHNAME));

                for (String line : lines) {
                    if (line.trim().isEmpty()) continue;

                    String[] parts = line.split(",", 5);

                    if (parts.length == 5) {
                        String username = parts[0];
                        String name = parts[1];
                        String surname = parts[2];
                        String hashedPassword = parts[4];
                        return new User(username, name, surname, hashedPassword);
                    }
                }
            }
            throw new NoRememberedUserException();
        } catch (IOException e) {
            throw new ConnectionException();
        }
    }

    @Override
    public void createUser(User user, String email, String password) throws ConnectionException, UsernameAlreadyExistsException, EmailAlreadyExistsException {
        initializeFile();
        try {
            File file = new File(PATHNAME);
            if (file.exists()) {
                List<String> lines = Files.readAllLines(Paths.get(PATHNAME));
                for (String line : lines) {
                    if (line.trim().isEmpty()) continue;
                    checkUniqueUsernameAndEmail(line, user.getUsername(), email);
                }
            }

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            try (FileWriter fw = new FileWriter(PATHNAME, true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println(user.getUsername() + "," + user.getName() + "," + user.getSurname() + "," + email + "," + hashedPassword);
            }
        } catch (IOException e) {
            throw new ConnectionException();
        }
    }

    public static synchronized void forgetUser() throws ForgetUserException {
        try {
            Files.deleteIfExists(Paths.get(PATHNAME));
        } catch (IOException e) {
            throw new ForgetUserException(e);
        }
    }

    private synchronized void initializeFile() throws ConnectionException {
        File file = new File(PATHNAME);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new FailedFileCreationException();
                }
            } catch (IOException | FailedFileCreationException e) {
                throw new ConnectionException();
            }
        }
    }
    private synchronized void checkUniqueUsernameAndEmail(String line, String username, String email) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        String[] parts = line.split(",", 5);
        if (parts.length == 5) {
            if (parts[0].equals(username)) {
                throw new UsernameAlreadyExistsException();
            }
            if (parts[3].equals(email)) {
                throw new EmailAlreadyExistsException();
            }
        }
    }
}
