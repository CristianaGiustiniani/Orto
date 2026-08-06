package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.PlaceOrderGC;
import com.orto.logic.model.entity.Payment;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.PaymentType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.EnumSet;

public class PaymentSelectionGUI1GC extends GUIGC {
    //ATTRIBUTES
    private final PlaceOrderGC placeOrderGC;
    private final Payment payment;

    //FXML ELEMENTS
    @FXML private HBox hBoxContent;
    @FXML private Button buttonPayOnline;
    @FXML private Button buttonPayByCash;

    //CONSTRUCTOR
    public PaymentSelectionGUI1GC(PlaceOrderGC placeOrderGC, EnumSet<PaymentType> activePaymentTypes) {
        super("/views/views1/form/buyer/placeOrderElements/PaymentSelection.fxml");
        this.placeOrderGC = placeOrderGC;
        this.payment = new Payment();
        root = load();
        setupButtons(activePaymentTypes);
        setupTexts();
    }

    //INPUT METHODS
    @FXML private void clickButtonPayOnline() {
        payOnline();
        placeOrderGC.goToNextStep();
    }

    @FXML private void clickButtonPayViaCash() {
        payByCash();
        placeOrderGC.goToNextStep();
    }

    public void payByCash(){
        payment.setPaymentTypeCash();
        payment.setPaymentStatusSuccessful();
    }

    public void payOnline(){
        payment.setPaymentTypeOnline();
        payment.setPaymentStatusSuccessful();
    }

    public Payment getPaymentInfo() {
        return payment;
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        buttonPayOnline.setText(I18n.t("GUI_PLACEORDER_PAYMENTSELECTION_VIEW_PAYONLINE"));
        buttonPayByCash.setText(I18n.t("GUI_PLACEORDER_PAYMENTSELECTION_VIEW_PAYBYCASH"));

    }

    private void setupButtons(EnumSet<PaymentType> activePaymentTypes) {
        if (activePaymentTypes.contains(PaymentType.ONLINE)) {
            buttonPayOnline.setVisible(true);
        }
        if (activePaymentTypes.contains(PaymentType.CASH)) {
            buttonPayByCash.setVisible(true);
        }
    }

    public void showError(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }


}


