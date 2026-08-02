package com.orto.logic.graphic_controller.controller;

public interface PublicBackgroundView {
    public default void home() {
        ViewFactory.getInstance().createHome();
    }
    public default void loginOrSignup() {
        ViewFactory.getInstance().createLogin();
    }
}
