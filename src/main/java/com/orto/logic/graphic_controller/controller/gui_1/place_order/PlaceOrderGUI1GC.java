package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.controller.PlaceOrderController;
import com.orto.logic.graphic_controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.graphic_controller.bean.exceptions.NotPositiveQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.exceptions.DeliveryException;
import com.orto.logic.graphic_controller.controller.exceptions.InvalidDeliveryInfoException;
import com.orto.logic.graphic_controller.controller.exceptions.PaymentException;
import com.orto.logic.graphic_controller.controller.exceptions.ProductException;
import com.orto.logic.model.entity.*;
import com.orto.logic.model.entity.exceptions.NoProductSelectedException;
import com.orto.logic.utils.*;
import com.orto.logic.graphic_controller.controller.PlaceOrderGC;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.EnumSet;
import java.util.List;
import java.util.logging.Logger;

public class PlaceOrderGUI1GC extends GUIGC implements PlaceOrderGC {
    //CONTROLLER
    private final PlaceOrderController controller;

    //ATTRIBUTES
    private final Seller seller;
    private PlaceOrderStep currentStep;
    private ProductSelectionGUI1GC productSelectionGUI1GC;
    private DeliverySelectionGUI1GC deliverySelectionGUI1GC;
    private PaymentSelectionGUI1GC paymentSelectionGUI1GC;

    //FXML ATTRIBUTES
    @FXML private Button buttonBack;
    @FXML private Button buttonNext;
    @FXML private Text textSellerName;
    @FXML private Text textOrderStep;
    @FXML private Pane paneContent;

    //CONSTRUCTOR
    public PlaceOrderGUI1GC(Seller seller) {
        super("/views/views1/form/buyer/PlaceOrder.fxml");
        this.controller = new PlaceOrderController();
        this.seller = seller;
        this.currentStep = PlaceOrderStep.PRODUCT_SELECTION;
        this.controller.startOrder(seller);

        Parent background = loadBackground();
        Parent placeOrder = this.load();
        ((BorderPane)background).setCenter(placeOrder);
        root = background;

        setupTexts();
        goToStep(currentStep);

        Configuration.getInstance().getStage().setScene(new Scene(root));
    }


    //METHODS
    @Override
    public Seller getSeller() {
        return this.seller;
    }

    @Override
    public PlaceOrderController getController() {
        return controller;
    }

    @Override
    public PlaceOrderStep getCurrentStep() {
        return currentStep;
    }

    //INPUT METHODS
    @FXML private void onClickButtonBack() {
        goToPreviousStep();
    }

    @FXML private void onClickButtonNext() {
        goToNextStep();
    }

    @Override
    public void collectData() throws NotPositiveQuantityException, AnnotationTooLongException, WrongFormatQuantityException, InvalidDeliveryInfoException, NoProductSelectedException {
        switch (currentStep) {
            case PRODUCT_SELECTION:
                List<OrderLine> lines = this.productSelectionGUI1GC.getLines();
                controller.addProductsToOrder(lines);
                break;
            case DELIVERY_SELECTION:
                Delivery delivery = this.deliverySelectionGUI1GC.getDeliveryInfo();
                controller.defineDelivery(delivery);
                break;
            case PAYMENT_SELECTION:
                Payment payment = this.paymentSelectionGUI1GC.getPaymentInfo();
                controller.processPayment(payment);
                break;
            case ORDER_SUMMARY:
        }
    }

    //OUTPUT METHODS
    @Override
    public void setCurrentStep(PlaceOrderStep step) {
        this.currentStep = step;
        setupTexts();
    }

    @Override
    public void goToProductSelection(List<Product> products) {
        buttonNext.setVisible(true);
        buttonBack.setVisible(true);
        this.productSelectionGUI1GC = new ProductSelectionGUI1GC(products);
        paneContent.getChildren().clear();
        paneContent.getChildren().add(productSelectionGUI1GC.getRoot());
    }

    @Override
    public void goToDeliverySelection(Seller seller) {
        buttonNext.setVisible(true);
        buttonBack.setVisible(true);
        this.deliverySelectionGUI1GC = new DeliverySelectionGUI1GC(seller);
        paneContent.getChildren().clear();
        paneContent.getChildren().add(deliverySelectionGUI1GC.getRoot());
    }

    @Override
    public void goToPaymentSelection(EnumSet<PaymentType> activePaymentTypes) {
        buttonNext.setVisible(false);
        buttonBack.setVisible(true);
        this.paymentSelectionGUI1GC = new PaymentSelectionGUI1GC(this, activePaymentTypes);
        paneContent.getChildren().clear();
        paneContent.getChildren().add(paymentSelectionGUI1GC.getRoot());
    }

    @Override
    public void goToOrderSummary() {
        buttonNext.setVisible(true);
        buttonBack.setVisible(false);
        OrderSummaryGUI1GC orderSummaryGUI1GC = new OrderSummaryGUI1GC();
        paneContent.getChildren().clear();
        paneContent.getChildren().add(orderSummaryGUI1GC.getRoot());
    }

    @Override
    public void showError(Exception e) {
        if (e instanceof ProductException) {
            productSelectionGUI1GC.showError(e);
        } else if (e instanceof DeliveryException) {
            deliverySelectionGUI1GC.showError(e);
        } else if (e instanceof PaymentException) {
            paymentSelectionGUI1GC.showError(e);
        }
    }

    @Override
    protected void setupTexts() {
        buttonBack.setText(I18n.t("BACK"));
        buttonNext.setText(I18n.t("NEXT"));
        textSellerName.setText(seller.getName());
        textOrderStep.setText(currentStep.getStep());
    }
}
