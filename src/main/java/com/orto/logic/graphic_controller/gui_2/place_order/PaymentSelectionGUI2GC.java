package com.orto.logic.graphic_controller.gui_2.place_order;

import com.orto.logic.controller.exceptions.FailedPaymentException;
import com.orto.logic.controller.bean.PaymentBean;
import com.orto.logic.graphic_controller.GUIGC;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.PaymentType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.EnumSet;

public class PaymentSelectionGUI2GC extends GUIGC {
    //ATTRIBUTES
    private final PaymentBean payment;
    private final String totalPrice;
    private final Runnable onPaymentSelected;

    //FXML ELEMENTS
    @FXML private Text textTotal;
    @FXML private Text textTotalPrice;
    @FXML private Button buttonPayOnline;
    @FXML private Button buttonPayViaCash;
    @FXML private Label labelError;

    //CONSTRUCTOR
    public PaymentSelectionGUI2GC(EnumSet<PaymentType> activePaymentTypes, String totalPrice, Runnable onPaymentSelected) {
        super("/views/views2/form/buyer/placeOrderElements/PaymentSelection.fxml");
        this.payment = new PaymentBean();
        this.totalPrice = totalPrice;
        this.onPaymentSelected = onPaymentSelected;
        root = load();
        setupButtons(activePaymentTypes);
        labelError.setVisible(false);
        setupTexts();
    }

    //INPUT METHODS
    @FXML private void clickButtonPayOnline() {
        labelError.setVisible(false);
        payOnline();
    }

    @FXML private void clickButtonPayViaCash() {
        labelError.setVisible(false);
        payByCash();
    }

    public void payByCash(){
        payment.setPaymentType(PaymentType.CASH);
        if (onPaymentSelected != null) {
            onPaymentSelected.run();
        }
    }

    public void payOnline(){
        payment.setPaymentType(PaymentType.ONLINE);
        if (onPaymentSelected != null) {
            onPaymentSelected.run();
        }
    }

    public PaymentBean getPaymentInfo() {
        return payment;
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        textTotal.setText(I18n.t("GUI_PLACEORDER_PAYMENTSELECTION_VIEW_TOTAL"));
        textTotalPrice.setText("€" + totalPrice);
        buttonPayOnline.setText(I18n.t("GUI_PLACEORDER_PAYMENTSELECTION_VIEW_PAYONLINE"));
        buttonPayViaCash.setText(I18n.t("GUI_PLACEORDER_PAYMENTSELECTION_VIEW_PAYBYCASH"));
    }

    private void setupButtons(EnumSet<PaymentType> activePaymentTypes) {
        if (activePaymentTypes.contains(PaymentType.ONLINE)) {
            buttonPayOnline.setVisible(true);
        }
        if (activePaymentTypes.contains(PaymentType.CASH)) {
            buttonPayViaCash.setVisible(true);
        }
    }

    public void showError(Exception e) {
        labelError.setVisible(true);
        String errorMessage = (e instanceof FailedPaymentException) ? I18n.t("ERROR_PLACEORDER_PAYMENTSELECTION_FAILEDPAYMENT") : e.getMessage();
        labelError.setText(errorMessage);
    }


}


