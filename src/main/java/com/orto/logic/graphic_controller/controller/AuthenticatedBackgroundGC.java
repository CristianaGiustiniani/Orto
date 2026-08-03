package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.LoginController;

public interface AuthenticatedBackgroundGC {
    default void home() {
        GCFactory.getInstance().createHome();
    }

    default void logout() {
        LoginController.logout();
        GCFactory.getInstance().createHome();
    }
}
