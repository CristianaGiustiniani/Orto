package com.orto.logic.view_controller.ui.gui_1.background;

import com.orto.logic.controller.HomeController;
import com.orto.logic.view_controller.ui.backgrounds.BackgroundView;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public abstract class BackgroundGUI1View implements BackgroundView {
    @FXML ImageView logo;

    private HomeController homeController;
    @FXML protected void onLogoClick() {
        homeController = new HomeController();
        //something to go to home?
    }
}
