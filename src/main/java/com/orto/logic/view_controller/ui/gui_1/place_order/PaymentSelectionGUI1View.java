package com.orto.logic.view_controller.ui.gui_1.place_order;

import com.orto.logic.controller.PaymentSelectionController;
import com.orto.logic.view_controller.ui.GUIView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class PaymentSelectionGUI1View extends GUIView {
    //CONTROLLER
    PaymentSelectionController controller = new PaymentSelectionController();

    //JAVAFX GRAPHIC ELEMENTS
    @FXML private HBox hBoxContent;
    @FXML private Button buttonPayOnline;
    @FXML private Button buttonPayByCash;

    //CONSTRUCTOR
    protected PaymentSelectionGUI1View() {
        super("views/views1/form/buyer/placeOrderElements/PaymentSelection.fxml");
        setupTexts();
    }

    //JAVAFX ACTIONS-EVENTS
    //todo: onClickButtonPayOnline
    @FXML private void onClickButtonPayOnline() {
    }

    //todo: onClickButtonPayViaCash
    @FXML private void onClickButtonPayViaCash() {
    }

    //SETUP
    @Override
    protected void setupTexts() {

    }

    @Override
    protected void showError() {

    }

    @Override
    public boolean isBackgrounded() {
        return false;
    }

    //METHODS
    public void payByCash(){

    }

    public void payOnline(){

    }

}


