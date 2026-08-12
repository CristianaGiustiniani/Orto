package com.orto.logic.graphic_controller.controller;

public interface PublicBackgroundGC {
    default void home() {
        GCFactoryProvider.getInstance().createHome();
    }

    default void loginOrSignup() {
        GCFactoryProvider.getInstance().createLogin();
    }

    default void login() {
        GCFactoryProvider.getInstance().createLogin();
    }
}
