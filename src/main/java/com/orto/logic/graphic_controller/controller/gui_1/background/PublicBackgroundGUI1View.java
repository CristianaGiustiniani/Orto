package com.orto.logic.graphic_controller.controller.gui_1.background;

import com.orto.logic.utils.I18n;
import com.orto.logic.graphic_controller.controller.GUIView;
import com.orto.logic.graphic_controller.controller.PublicBackgroundView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PublicBackgroundGUI1View extends GUIView implements PublicBackgroundView {
    //FXML ATTRIBUTES
    @FXML Button buttonLoginSignUp;

    //CONSTRUCTOR
    public PublicBackgroundGUI1View() {
        super("views/views1/Background.fxml");
        root = this.load();
        setupTexts();
    }

    //INPUT METHODS
    @FXML void onButtonLoginSignUpClick() {
        loginOrSignup();
    }

    @FXML protected void onLogoClick() {
        home();
    }


    //OUTPUT METHODS
    protected void setupTexts() {
        buttonLoginSignUp.setText(I18n.t("GUI_BACKGROUND_VIEW_LOGINORSIGNUP"));
    }

}
