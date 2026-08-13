package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.controller.exceptions.FailedPaymentException;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.mapper.PriceMapper;
import com.orto.logic.model.entity.Payment;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.PaymentType;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.util.EnumSet;

public class PaymentSelectionGUI1GC extends GUIGC {
    //ATTRIBUTES
    private final Payment payment;
    private final BigDecimal totalPrice;
    private final Runnable onPaymentSelected;

    //FXML ELEMENTS
    @FXML private Text textTotal;
    @FXML private Text textTotalPrice;
    @FXML private Button buttonPayOnline;
    @FXML private Button buttonPayViaCash;
    @FXML private Label labelProductSelection;
    @FXML private Label labelDelivery;
    @FXML private Label labelPayment;
    @FXML private Label labelSummary;

    //CONSTRUCTOR
    public PaymentSelectionGUI1GC(EnumSet<PaymentType> activePaymentTypes, BigDecimal totalPrice, Runnable onPaymentSelected) {
        super("/views/views1/form/buyer/placeOrderElements/PaymentSelection.fxml");
        this.payment = new Payment();
        this.totalPrice = totalPrice;
        this.onPaymentSelected = onPaymentSelected;
        root = load();
        setupButtons(activePaymentTypes);
        setupTexts();
    }

    //INPUT METHODS
    @FXML private void clickButtonPayOnline() {
        payOnline();
    }

    @FXML private void clickButtonPayViaCash() {
        payByCash();
    }

    public void payByCash(){
        payment.setPaymentTypeCash();
        if (onPaymentSelected != null) {
            onPaymentSelected.run();
        }
    }

    public void payOnline(){
        payment.setPaymentTypeOnline();
        if (onPaymentSelected != null) {
            onPaymentSelected.run();
        }
    }

    public Payment getPaymentInfo() {
        return payment;
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        labelProductSelection.setText(I18n.t("STEP_PRODUCT_SELECTION"));
        labelDelivery.setText(I18n.t("STEP_DELIVERY_SELECTION"));
        labelPayment.setText(I18n.t("STEP_PAYMENT_SELECTION"));
        labelSummary.setText(I18n.t("STEP_ORDER_SUMMARY"));
        textTotal.setText(I18n.t("GUI_PLACEORDER_PAYMENTSELECTION_VIEW_TOTAL"));
        textTotalPrice.setText("€" + (new PriceMapper()).toBean(totalPrice));
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
        Alert alert = new Alert(Alert.AlertType.ERROR);

        if (e instanceof FailedPaymentException) {
            alert.setContentText(I18n.t("ERROR_PLACEORDER_PAYMENTSELECTION_FAILEDPAYMENT"));
        } else {
            alert.setContentText(I18n.t(e.getMessage()));
        }

        alert.showAndWait();
    }
}


