package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.LoginController;
import com.orto.logic.model.dao.exceptions.ForgetUserException;
import com.orto.logic.model.entity.User;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.Session;
import com.orto.logic.utils.exceptions.IllegalNullUserException;

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

    default User getLoggedUser() {
        User user = null;
        try {
            user = Session.getInstance().getLoggedUser();
        } catch (IllegalNullUserException e) {
            showError(I18n.t("ERROR_BACKGROUND_ILLEGALNULLUSER"));
            GCFactory.getInstance().createHome();
        }
        return user;
    }

    void showError(String message);
}
