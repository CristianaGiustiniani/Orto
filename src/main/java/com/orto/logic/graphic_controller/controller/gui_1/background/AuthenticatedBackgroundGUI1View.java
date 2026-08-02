package com.orto.logic.graphic_controller.controller.gui_1.background;

import com.orto.logic.utils.I18n;
import com.orto.logic.utils.Session;
import com.orto.logic.graphic_controller.controller.AuthenticatedBackgroundView;
import com.orto.logic.graphic_controller.controller.GUIView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class AuthenticatedBackgroundGUI1View extends GUIView implements AuthenticatedBackgroundView {
    //FXML ATTRIBUTES
    @FXML Button buttonLogout;
    @FXML Text textUsername;

    //CONSTRUCTOR
    public AuthenticatedBackgroundGUI1View() {
        super("views/views1/loggeduser/Background.fxml");
        root = this.load();
        setupTexts();
    }

    //INPUT METHODS
    @FXML void onButtonLogoutClick() {
        logout();
    }

    @FXML protected void onLogoClick() {
        home();
    }

    //OUTPUT METHODS
    protected void setupTexts() {
        textUsername.setText(I18n.t("GUI_BACKGROUND_VIEW_HELLO") + ", " + Session.getInstance().getLoggedUser().getUsername());
        buttonLogout.setText(I18n.t("GUI_BACKGROUND_VIEW_LOGOUT"));
    }
}
