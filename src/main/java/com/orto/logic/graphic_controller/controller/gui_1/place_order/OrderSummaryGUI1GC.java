package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.graphic_controller.controller.GUIGC;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class OrderSummaryGUI1GC extends GUIGC {
    //FXML ATTRIBUTES
    @FXML private Text textOrderConfirmation;

    //CONSTRUCTOR
    public OrderSummaryGUI1GC() {
        super("/views/views1/form/buyer/placeOrderElements/OrderSummary.fxml");
        root = load();
        setupTexts();
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        //todo: create text
        textOrderConfirmation.setText("blablabla");
    }
}
