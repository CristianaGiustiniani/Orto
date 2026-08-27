package com.orto.logic.model.dao;

import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.EmailAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.ForgetUserException;
import com.orto.logic.model.dao.exceptions.NoRememberedUserException;
import com.orto.logic.model.dao.exceptions.UsernameAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;

public interface UserDAO {
    User getUser(String email, String password) throws ConnectionException, WrongPasswordException, WrongEmailException;

    void createUser(User user, String email, String password) throws ConnectionException, UsernameAlreadyExistsException, EmailAlreadyExistsException;

    default User getUser() throws NoRememberedUserException, ConnectionException {
        throw new NoRememberedUserException();
    }

    default void forgetUser(User user) throws ForgetUserException {
        // no op by default
    }
}
