package com.orto.logic.graphic_controller.controller;

public interface PublicBackgroundGC {
    default void home() {
        GCFactory.getInstance().createHome();
    }

    default void loginOrSignup() {
        GCFactory.getInstance().createLogin();
    }
}
