package com.orto.logic.graphic_controller.controller.gui_2.background;

import com.orto.logic.graphic_controller.controller.AuthenticatedBackgroundGC;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class AuthenticatedBackgroundGUI2GC extends GUIGC implements AuthenticatedBackgroundGC {
    //FXML ATTRIBUTES
    @FXML Button buttonLogout;
    @FXML Text textUsername;

    //CONSTRUCTOR
    public AuthenticatedBackgroundGUI2GC() {
        super("/views/views2/form/buyer/Background.fxml");
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
        textUsername.setText(I18n.t("GUI_BACKGROUND_VIEW_HELLO") + ", " + getLoggedUser().getUsername());
        buttonLogout.setText(I18n.t("GUI_BACKGROUND_VIEW_LOGOUT"));
    }

    @Override
    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
