package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.LoginController;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.exceptions.WrongPasswordException;
import com.orto.logic.utils.I18n;

public interface LoginGC {
    default void login(String email, String password) {
        try {
            (new LoginController()).login(email, password);
        } catch (Exception e) {
            //todo: i18n error messages
            showError(I18n.t("ERROR_CONNECTION"));
        } catch (ConnectionException e) {
            showError(I18n.t("ERROR_CONNECTION"));
        } catch (WrongPasswordException e) {
            showError(e.getMessage());
        }
    }

    default void signup() {
        //not implementing signup
    }

    void showError(String message);
}
