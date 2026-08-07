package com.orto.logic.graphic_controller.controller.gui_2.background;

import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.PublicBackgroundGC;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;


public class PublicBackgroundGUI2GC extends GUIGC implements PublicBackgroundGC {
    //FXML ATTRIBUTES
    @FXML ImageView logo;
    @FXML Button buttonLoginSignup;

    //CONSTRUCTOR
    public PublicBackgroundGUI2GC() {
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
