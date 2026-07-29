package com.orto.logic.view_controller.ui.gui_1.background;

import com.orto.logic.controller.BackgroundController;
import com.orto.logic.view_controller.ui.BackgroundView;
import com.orto.logic.view_controller.ui.GUIView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PublicBackgroundGUI1View {
    @FXML Button buttonLoginSignUp;

    public PublicBackgroundGUI1View() {
        super("views/views1/Background.fxml");
        controller = new BackgroundController();
    }

    @FXML void onButtonLoginSignUpClick() {
        //go to login view
    }
}
