package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.controller.PlaceOrderController;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.*;
import com.orto.logic.utils.exceptions.EndOfEnumException;
import com.orto.logic.utils.exceptions.StartOfEnumException;
import com.orto.logic.graphic_controller.controller.PlaceOrderGC;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class PlaceOrderGUI1GC implements PlaceOrderGC {
    //CONTROLLER
    private PlaceOrderController controller;

    //ATTRIBUTES
    private Seller seller;
    private PlaceOrderStep currentStep;
    private ProductSelectionGUI1View productSelectionView;
    private ShippingSelectionGUI1View shippingSelectionView;
    private PaymentSelectionGUIGC paymentSelectionView;
    private OrderSummaryGUIGC orderSummaryView;

    //FXML ATTRIBUTES
    private final String fxmlPath = "views/views1/form/buyer/PlaceOrder.fxml";
    @FXML private Button buttonBack;
    @FXML private Button buttonNext;
    @FXML private Text textSellerName;
    @FXML private Text textOrderStep;
    @FXML private Pane paneContent;

    //CONSTRUCTOR
    public PlaceOrderGUI1GC(Seller seller) {
        this.controller = new PlaceOrderController();
        this.seller = seller;
        this.currentStep = PlaceOrderStep.PRODUCT_SELECTION;
    }

    //JAVAFX ACTIONS-EVENTS
    @FXML private void onClickButtonBack() {
        goToNextStep();
    }
    @FXML private void onClickButtonNext() {
        goToPreviousStep();
    }



    //METHODS
    public void goToNextStep() {
        try {
            //getdata
            //submitdata
            currentStep = currentStep.next();
            showStep(currentStep);
        } catch (EndOfEnumException e) {
            //goToHome
        }
    }
    public void goToPreviousStep() {
        try {
            currentStep = currentStep.previous();
            showStep(currentStep);
        } catch (StartOfEnumException e) {
            //gotoHome
        }
    }

    private void showStep(PlaceOrderStep step) {
        switch (step) {
            case PRODUCT_SELECTION -> showProductSelection();
            case DELIVERY_SELECTION -> showShippingSelection();
            case PAYMENT_SELECTION -> showPaymentSelection();
            case ORDER_SUMMARY -> showOrderSummary();
        }
    }
    private void showProductSelection() {
        this.productSelectionView = new ProductSelectionGUI1View();
    }
    private void showShippingSelection() {
        this.shippingSelectionView = new ShippingSelectionGUI1View();
    }
    private void showPaymentSelection() {
        this.paymentSelectionView = new PaymentSelectionGUIGC();
    }
    private void showOrderSummary() {
        this.orderSummaryView = new OrderSummaryGUIGC();
    }

    //SETUP
    protected void setupTexts() {
        buttonBack.setText(I18n.t("BACK"));
        buttonNext.setText(I18n.t("NEXT"));
        textSellerName.setText(seller.getName());
        textOrderStep.setText(currentStep.getStep());
    }

    protected void showError() {

    }
}
