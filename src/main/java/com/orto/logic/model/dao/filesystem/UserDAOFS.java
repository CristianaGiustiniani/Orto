package com.orto.logic.model.dao.filesystem;

import com.orto.logic.model.dao.UserDAO;
import com.orto.logic.model.dao.exceptions.*;
import com.orto.logic.model.entity.Buyer;
import com.orto.logic.model.entity.Role;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class UserDAOFS implements UserDAO {
    private static final Path DEFAULT_PATH = Paths.get("users.txt");
    private final Path path;


    public UserDAOFS() {
        this(DEFAULT_PATH);
    }
    //for testing purposes
    public UserDAOFS(Path path) {
        this.path = path;
    }

    @Override
    public synchronized User getUser(String email, String password) throws ConnectionException, WrongPasswordException, WrongEmailException {
        initializeFile();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] parts = parseLine(line);
                if (parts.length != 0 && parts[4].equals(email)) {
                    User user = toUser(parts);
                    user.checkPassword(password);
                    return user;
                }
            }
            throw new WrongEmailException();
        } catch (IOException e) {
            throw new ConnectionException();
        }
    }

    @Override
    public synchronized User getUser() throws NoRememberedUserException, ConnectionException {
        File file = path.toFile();
        try {
            if (file.exists()) {
                List<String> lines = Files.readAllLines(path);

                for (int i = lines.size() - 1; i >= 0; i--) {
                    String[] parts = parseLine(lines.get(i));
                    if (parts.length != 0) {
                        return toUser(parts);
                    }
                }
            }
            throw new NoRememberedUserException();
        } catch (IOException e) {
            throw new ConnectionException();
        }
    }

    @Override
    public synchronized void createUser(User user, String email, String password, Role role) throws ConnectionException, UsernameAlreadyExistsException, EmailAlreadyExistsException {
        initializeFile();
        try {
            File file = path.toFile();
            if (file.exists()) {
                List<String> lines = Files.readAllLines(path);
                for (String line : lines) {
                    if (line.trim().isEmpty()) continue;
                    checkUniqueUsernameAndEmail(line, user.getUsername(), email);
                }
            }

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            try (FileWriter fw = new FileWriter(path.toFile(), true);
                 PrintWriter pw = new PrintWriter(fw)) {
                pw.println(user.getId() + "," + user.getUsername() + "," + user.getName() + "," + user.getSurname() + "," + email + "," + hashedPassword);
            }
        } catch (IOException e) {
            throw new ConnectionException();
        }
    }

    @Override
    public synchronized void forgetUser(User user) throws ForgetUserException {
        if (user == null) {
            return;
        }
        try {
            if (!Files.exists(path)) {
                return;
            }

            //check if user in file (and not adding it to remaining lines)
            List<String> remainingLines = new ArrayList<>();
            for (String line : Files.readAllLines(path)) {
                String[] parts = parseLine(line);
                if (parts.length == 0 || !matchesUser(parts, user)) {
                    remainingLines.add(line);
                }
            }

            //overwrite user file with remaining lines
            Files.write(
                    path,
                    remainingLines,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            throw new ForgetUserException(e);
        }
    }

    private synchronized void initializeFile() throws ConnectionException {
        File file = path.toFile();
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new FailedFileCreationException();
                }
            } catch (IOException e) {
                throw new ConnectionException(e);
            }
        }
    }

    private synchronized void checkUniqueUsernameAndEmail(String line, String username, String email) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        String[] parts = parseLine(line);
        if (parts.length != 0) {
            if (parts[1].equals(username)) {
                throw new UsernameAlreadyExistsException();
            }
            if (parts[4].equals(email)) {
                throw new EmailAlreadyExistsException();
            }
        }
    }

    //UTILITY METHODS
    //parses line into parts
    private String[] parseLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new String[0];
        }
        String[] parts = line.split(",", 6);
        return parts.length == 6 ? parts : new String[0];
    }

    //converts parts to User
    private User toUser(String[] parts) {
        return new User(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                parts[3],
                parts[5],
                new Buyer()
        );
    }

    //checks if parts correspond to user
    private boolean matchesUser(String[] parts, User user) {
        return parts[1].equals(user.getUsername())
                && parts[2].equals(user.getName())
                && parts[3].equals(user.getSurname());
    }
}
