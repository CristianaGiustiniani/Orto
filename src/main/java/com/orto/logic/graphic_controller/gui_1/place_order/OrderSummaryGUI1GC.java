package com.orto.logic.graphic_controller.gui_1.place_order;

import com.orto.logic.graphic_controller.GUIGC;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class OrderSummaryGUI1GC extends GUIGC {
    //FXML ATTRIBUTES
    @FXML private Text textOrderConfirmation;
    @FXML private Label labelProductSelection;
    @FXML private Label labelDelivery;
    @FXML private Label labelPayment;
    @FXML private Label labelSummary;

    //CONSTRUCTOR
    public OrderSummaryGUI1GC() {
        super("/views/views1/form/buyer/placeOrderElements/OrderSummary.fxml");
        root = load();
        setupTexts();
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        textOrderConfirmation.setText(I18n.t("GUI_PLACEORDER_ORDERSUMMARY_VIEW_ORDERCONFIRMATION"));
        labelProductSelection.setText(I18n.t("STEP_PRODUCT_SELECTION"));
        labelDelivery.setText(I18n.t("STEP_DELIVERY_SELECTION"));
        labelPayment.setText(I18n.t("STEP_PAYMENT_SELECTION"));
        labelSummary.setText(I18n.t("STEP_ORDER_SUMMARY"));
    }
}
