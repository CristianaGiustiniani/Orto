package com.orto.logic.graphic_controller.controller.gui_2.home;

import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.HomeGC;
import com.orto.logic.graphic_controller.controller.gui_2.find_farmers.FindFarmersGUI2GC;
import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class HomeGUI2GC extends GUIGC implements HomeGC {
    //FXML ATTRIBUTES
    @FXML private Button buttonViewPurchases;
    @FXML private Button buttonFindFarmers;
    @FXML private Text textSubtitleHome;
    @FXML private Text textTitleHome;
    @FXML private Text textHomeText;

    //CONSTRUCTOR
    public HomeGUI2GC() {
        super("/views/views2/form/Home.fxml");

        Parent background = loadBackground();
        Parent home = this.load();

        ((BorderPane) background).setCenter(home);
        root = background;
        setupTexts();

        Configuration.getInstance().getStage().setScene(new Scene(root));
        show();
    }

    //INPUT METHODS
    @FXML private void onClickButtonViewPurchases() {
        viewPurchases();
    }
    @FXML private void onClickButtonFindFarmers() {
        findFarmers();
    }


    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        buttonViewPurchases.setText(I18n.t("GUI_HOME_VIEW_VIEWPURCHASES"));
        buttonFindFarmers.setText(I18n.t("GUI_HOME_VIEW_FINDFARMERS"));
        textSubtitleHome.setText(I18n.t("GUI_HOME_VIEW_SUBTITLE"));
        textTitleHome.setText(I18n.t("GUI_HOME_VIEW_TITLE"));
        textHomeText.setText(I18n.t("GUI_HOME_VIEW_TEXT"));
    }
}
