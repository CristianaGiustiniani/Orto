package com.orto.logic.graphic_controller.controller.gui_1.home;

import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.I18n;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.HomeGC;
import com.orto.logic.graphic_controller.controller.gui_1.find_farmers.FindFarmersGUIGC;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class HomeGUI1GC extends GUIGC implements HomeGC {
    //FXML ELEMENTS
    @FXML private AnchorPane anchorPaneFindFarmers;
    @FXML private Button buttonViewPurchases;
    @FXML private ScrollPane scrollPaneFarmersTable;
    @FXML private Text textSubtitleHome;
    @FXML private Text textTitleHome;

    //CONSTRUCTOR
    public HomeGUI1GC() {
        super("/views/views1/form/Home.fxml");

        Parent background = loadBackground();
        Parent home = this.load();
        Parent findFarmers = (new FindFarmersGUIGC()).getRoot();

        ((BorderPane) background).setCenter(home);
        anchorPaneFindFarmers.getChildren().add(findFarmers);

        root = background;
        setupTexts();

        Configuration.getInstance().getStage().setScene(new Scene(root));
        show();
    }

    //INPUT METHODS
    @FXML private void onClickButtonViewPurchases() {
        viewPurchases();
    }


    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        buttonViewPurchases.setText(I18n.t("GUI_HOME_VIEW_VIEWPURCHASES"));
        textSubtitleHome.setText(I18n.t("GUI_HOME_VIEW_SUBTITLE"));
        textTitleHome.setText(I18n.t("GUI_HOME_VIEW_TITLE"));
    }
}
