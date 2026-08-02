package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.controller.PaymentSelectionController;
import com.orto.logic.graphic_controller.controller.GUIView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class PaymentSelectionGUI1View extends GUIView {
    //CONTROLLER
    PaymentSelectionController controller = new PaymentSelectionController();

    //FXML ELEMENTS
    @FXML private HBox hBoxContent;
    @FXML private Button buttonPayOnline;
    @FXML private Button buttonPayByCash;

    //CONSTRUCTOR
    protected PaymentSelectionGUI1View() {
        super("views/views1/form/buyer/placeOrderElements/PaymentSelection.fxml");
        setupTexts();
    }

    //INPUT METHODS
    //todo: onClickButtonPayOnline
    @FXML private void onClickButtonPayOnline() {
        payOnline();
    }

    //todo: onClickButtonPayViaCash
    @FXML private void onClickButtonPayViaCash() {
        payByCash();
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {

    }

    public void payByCash(){
    }

    public void payOnline(){

    }

}


