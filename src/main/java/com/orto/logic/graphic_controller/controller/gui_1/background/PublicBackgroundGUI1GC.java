package com.orto.logic.graphic_controller.controller.gui_1.background;

import com.orto.logic.utils.I18n;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.PublicBackgroundGC;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PublicBackgroundGUI1GC extends GUIGC implements PublicBackgroundGC {
    //FXML ATTRIBUTES
    @FXML Button buttonLoginSignUp;

    //CONSTRUCTOR
    public PublicBackgroundGUI1GC() {
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
