package com.orto.logic.model.dao;

import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.dao.exceptions.EmailAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.UsernameAlreadyExistsException;
import com.orto.logic.model.dao.exceptions.WrongEmailException;
import com.orto.logic.model.entity.User;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;

public interface UserDAO {
    User getUser(String username, String password) throws ConnectionException, WrongPasswordException, WrongEmailException;

    void saveUser(User user, String email, String password) throws ConnectionException, UsernameAlreadyExistsException, EmailAlreadyExistsException;
}
