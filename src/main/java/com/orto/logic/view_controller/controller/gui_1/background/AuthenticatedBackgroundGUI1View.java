package com.orto.logic.view_controller.controller.gui_1.background;

import com.orto.logic.controller.BackgroundController;
import com.orto.logic.view_controller.controller.BackgroundView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class AuthenticatedBackgroundGUI1View {
    @FXML Button buttonLogout;
    @FXML Text textUsername;
    BackgroundController backgroundController;

    public AuthenticatedBackgroundGUI1View() {
        super("views/views1/loggeduser/Background.fxml");
        controller = new BackgroundController();
    }

    @FXML void onButtonLogoutClick() {
        backgroundController = new BackgroundController();
        backgroundController.logOut();
    }
}
