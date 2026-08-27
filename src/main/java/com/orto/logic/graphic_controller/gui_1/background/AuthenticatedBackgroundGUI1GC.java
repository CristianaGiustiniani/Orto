package com.orto.logic.graphic_controller.gui_1.background;

import com.orto.logic.controller.LoginController;
import com.orto.logic.graphic_controller.GCFactoryProvider;
import com.orto.logic.utils.I18n;
import com.orto.logic.graphic_controller.graphic_elements.AuthenticatedBackgroundGC;
import com.orto.logic.graphic_controller.GUIGC;
import com.orto.logic.utils.exceptions.IllegalNullUserException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class AuthenticatedBackgroundGUI1GC extends GUIGC implements AuthenticatedBackgroundGC {
    //CONTROLLER
    LoginController controller;

    //FXML ATTRIBUTES
    @FXML Button buttonLogout;
    @FXML Text textUsername;

    //CONSTRUCTOR
    public AuthenticatedBackgroundGUI1GC() {
        super("/views/views1/form/buyer/Background.fxml");
        this.controller = new LoginController();
        root = this.load();
        setupTexts();
    }

    //INPUT METHODS
    @FXML private void onButtonLogoutClick() {
        logout();
    }

    @FXML private void onLogoClick() {
        home();
    }

    //OUTPUT METHODS
    protected void setupTexts() {
        try {
            String username = controller.getLoggedUserUsername();
            textUsername.setText(I18n.t("GUI_BACKGROUND_VIEW_HELLO") + ", " + username);
            buttonLogout.setText(I18n.t("GUI_BACKGROUND_VIEW_LOGOUT"));
        } catch (IllegalNullUserException e) {
            showError(I18n.t("ERROR_BACKGROUND_ILLEGALNULLUSER"));
            GCFactoryProvider.getInstance().createHome();
        }
    }

    @Override
    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
