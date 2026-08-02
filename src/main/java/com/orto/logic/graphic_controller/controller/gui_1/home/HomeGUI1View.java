package com.orto.logic.graphic_controller.controller.gui_1.home;

import com.orto.logic.utils.I18n;
import com.orto.logic.graphic_controller.controller.GUIView;
import com.orto.logic.graphic_controller.controller.HomeView;
import com.orto.logic.graphic_controller.controller.gui_1.find_farmers.FindFarmersGUI1View;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class HomeGUI1View extends GUIView implements HomeView {
    //FXML ELEMENTS
    private final Parent background;
    private final Parent home;
    private final Parent findFarmers;
    @FXML private AnchorPane anchorPaneFindFarmers;
    @FXML private Button buttonViewPurchases;
    @FXML private ScrollPane scrollPaneFarmersTable;
    @FXML private Text textSubtitleHome;
    @FXML private Text textTitleHome;

    //CONSTRUCTOR
    public HomeGUI1View() {
        super("views/views1/form/Home.fxml");

        background = loadBackground();
        home = this.load();
        findFarmers = (new FindFarmersGUI1View()).getRoot();

        ((BorderPane)background).setCenter(home);
        anchorPaneFindFarmers.getChildren().add(findFarmers);

        root = background;
        setupTexts();
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
