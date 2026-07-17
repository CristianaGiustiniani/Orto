package com.orto.logic.view_controller.ui.gui_1.background;

import com.orto.logic.controller.BackgroundController;
import com.orto.logic.view_controller.ui.GUIView;
import com.orto.logic.view_controller.ui.backgrounds.PublicBackgroundView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PublicBackgroundGUI1View extends GUIView implements PublicBackgroundView {
    @FXML Button buttonLoginSignUp;

    public PublicBackgroundGUI1View() {
        super("views/views1/Background.fxml");
        controller = new BackgroundController();
    }

    @FXML void onButtonLoginSignUpClick() {
        //go to login view
    }
}
