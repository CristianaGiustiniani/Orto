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
    @FXML Button buttonLogin;

    //CONSTRUCTOR
    public PublicBackgroundGUI2GC() {
        super("/views/views2/form/Background.fxml");
        root = this.load();
        setupTexts();
    }

    //INPUT METHODS
    @FXML private void onButtonLoginClick() {
        login();
    }

    @FXML private void onLogoClick() {
        home();
    }


    //OUTPUT METHODS
    protected void setupTexts() {
        buttonLogin.setText(I18n.t("GUI_BACKGROUND_VIEW_LOGIN"));
    }

}
