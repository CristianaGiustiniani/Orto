package com.orto.logic.graphic_controller.controller.gui_2.place_order;

import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class OrderSummaryGUI2GC extends GUIGC {
    //FXML ATTRIBUTES
    @FXML private Text textOrderConfirmation;

    //CONSTRUCTOR
    public OrderSummaryGUI2GC() {
        super("/views/views2/form/buyer/placeOrderElements/OrderSummary.fxml");
        root = load();
        setupTexts();
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        textOrderConfirmation.setText(I18n.t("GUI_PLACEORDER_ORDERSUMMARY_VIEW_ORDERCONFIRMATION"));
    }
}
