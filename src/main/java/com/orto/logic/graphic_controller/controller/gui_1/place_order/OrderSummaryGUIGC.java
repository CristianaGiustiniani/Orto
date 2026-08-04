package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.graphic_controller.controller.GUIGC;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class OrderSummaryGUIGC extends GUIGC {
    //FXML ATTRIBUTES
    @FXML private Text textOrderConfirmation;

    //CONSTRUCTOR
    protected OrderSummaryGUIGC() {
        super("/views/views1/form/buyer/placeOrderElements/OrderSummary.fxml");
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        //todo: create text
        textOrderConfirmation.setText("blablabla");
    }
}
