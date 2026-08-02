package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.BackgroundController;

public interface AuthenticatedBackgroundView {
    public default void home() {
        ViewFactory.getInstance().createHome();
    }
    public default void logout() {
        BackgroundController.logOut();
        ViewFactory.getInstance().createHome();
    }
}
