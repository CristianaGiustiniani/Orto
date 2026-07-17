package com.orto.logic.view_controller.ui;

public interface LoginView {
    default boolean isBackgrounded(){
        return true;
    }
    void logIn();
    void signUp();
}
