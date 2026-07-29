package com.orto.logic.view_controller.ui.gui_1.home;

import com.orto.logic.controller.FindFarmersController;
import com.orto.logic.controller.PurchaseHistoryController;
import com.orto.logic.utils.I18n;
import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.ui.GUIView;
import com.orto.logic.view_controller.ui.HomeView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.List;

public class HomeGUI1View extends GUIView implements HomeView {
    //CONTROLLERS
    FindFarmersController findFarmersController;


    //ATTRIBUTES
    @FXML private Parent background;
    @FXML private Parent home;
    @FXML private Parent findFarmers;
    @FXML private List<Parent> farmerListItem;

    //JAVAFX GRAPHIC ELEMENTS
    @FXML private AnchorPane anchorPaneFindFarmers;
    @FXML private Button buttonViewPurchases;
    @FXML private ScrollPane scrollPaneFarmersTable;
    @FXML private Text textSubtitleHome;
    @FXML private Text textTitleHome;

    //CONSTRUCTOR
    public HomeGUI1View() {
        super("views/views1/form/Home.fxml");
        setupTexts();
    }

    //JAVAFX ACTIONS-EVENTS
    @FXML private void onClickButtonViewPurchases() {
        controller = new PurchaseHistoryController();
    }


    //IMPLEMENTED METHODS
    @Override
    protected void setupTexts() {
        buttonViewPurchases.setText(I18n.t("GUI_HOME_VIEW_VIEWPURCHASES"));
        textSubtitleHome.setText(I18n.t("GUI_HOME_VIEW_SUBTITLE"));
        textTitleHome.setText(I18n.t("GUI_HOME_VIEW_TITLE"));
    }

    @Override
    protected Parent create() {

        List <SellerBean> sellers;
        sellers = FindFarmersController.getFarmers();
    }

    @Override
    protected boolean hasHeader() {
        return true;
    }
    @Override
    protected void showError() {

    }
}
