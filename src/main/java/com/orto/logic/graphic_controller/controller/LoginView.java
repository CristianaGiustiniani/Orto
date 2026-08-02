package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.LoginController;

public interface LoginView {
    default void login(String email, String password) {
        try {
            (new LoginController()).login(email, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void showError(String message);

    default void signup() {
        //not implementing signup
    }
}
