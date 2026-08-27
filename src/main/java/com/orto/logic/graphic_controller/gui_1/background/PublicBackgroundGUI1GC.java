package com.orto.logic.graphic_controller.gui_1.background;

import com.orto.logic.utils.I18n;
import com.orto.logic.graphic_controller.GUIGC;
import com.orto.logic.graphic_controller.graphic_elements.PublicBackgroundGC;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class PublicBackgroundGUI1GC extends GUIGC implements PublicBackgroundGC {
    //FXML ATTRIBUTES
    @FXML Button buttonLoginSignup;

    //CONSTRUCTOR
    public PublicBackgroundGUI1GC() {
        super("/views/views1/form/Background.fxml");
        root = this.load();
        setupTexts();
    }

    //INPUT METHODS
    @FXML private void onButtonLoginSignupClick() {
        loginOrSignup();
    }

    @FXML private void onLogoClick() {
        home();
    }


    //OUTPUT METHODS
    protected void setupTexts() {
        buttonLoginSignup.setText(I18n.t("GUI_BACKGROUND_VIEW_LOGINORSIGNUP"));
    }

}
