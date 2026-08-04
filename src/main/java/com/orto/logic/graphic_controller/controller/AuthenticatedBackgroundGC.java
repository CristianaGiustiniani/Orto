package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.LoginController;
import com.orto.logic.model.dao.exceptions.ForgetUserException;
import com.orto.logic.utils.I18n;

public interface AuthenticatedBackgroundGC {
    default void home() {
        GCFactory.getInstance().createHome();
    }

    default void logout() {
        try {
            LoginController.logout();
        } catch (ForgetUserException e) {
            showError(I18n.t("ERROR_LOGOUT"));
        } finally {
            GCFactory.getInstance().createHome();
        }
    }

    void showError(String message);
}
