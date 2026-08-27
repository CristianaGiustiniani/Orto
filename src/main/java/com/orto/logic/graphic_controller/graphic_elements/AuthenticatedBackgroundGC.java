package com.orto.logic.graphic_controller.graphic_elements;

import com.orto.logic.controller.LoginController;
import com.orto.logic.graphic_controller.GCFactoryProvider;
import com.orto.logic.model.dao.exceptions.ForgetUserException;
import com.orto.logic.utils.I18n;

public interface AuthenticatedBackgroundGC {
    default void home() {
        GCFactoryProvider.getInstance().createHome();
    }

    default void logout() {
        try {
            (new LoginController()).logout();
        } catch (ForgetUserException e) {
            showError(I18n.t("ERROR_LOGOUT"));
        } finally {
            GCFactoryProvider.getInstance().createHome();
        }
    }

    void showError(String message);
}
