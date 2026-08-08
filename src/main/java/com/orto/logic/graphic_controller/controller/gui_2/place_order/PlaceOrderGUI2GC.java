package com.orto.logic.graphic_controller.controller.gui_2.place_order;

import com.orto.logic.controller.PlaceOrderController;
import com.orto.logic.graphic_controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.graphic_controller.bean.exceptions.NotPositiveQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.PlaceOrderGC;
import com.orto.logic.graphic_controller.controller.exceptions.DeliveryException;
import com.orto.logic.graphic_controller.controller.exceptions.InvalidDeliveryInfoException;
import com.orto.logic.graphic_controller.controller.exceptions.PaymentException;
import com.orto.logic.graphic_controller.controller.exceptions.ProductException;
import com.orto.logic.model.entity.*;
import com.orto.logic.model.entity.exceptions.NoProductSelectedException;
import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.PaymentType;
import com.orto.logic.utils.PlaceOrderStep;
import com.orto.logic.utils.exceptions.EndOfEnumException;
import com.orto.logic.utils.exceptions.StartOfEnumException;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.List;

public class PlaceOrderGUI2GC extends GUIGC implements PlaceOrderGC {
    //CONTROLLER
    private final PlaceOrderController controller;

    //ATTRIBUTES
    private final Seller seller;
    private PlaceOrderStep currentStep;
    private ProductSelectionGUI2GC productSelectionGUI2GC;
    private DeliverySelectionGUI2GC deliverySelectionGUI1GC;
    private PaymentSelectionGUI2GC paymentSelectionGUI2GC;

    //FXML ATTRIBUTES
    @FXML private Button buttonBack;
    @FXML private Button buttonNext;
    @FXML private Text textSellerName;
    @FXML private Text textOrderStep;
    @FXML private Pane paneContent;

    //CONSTRUCTOR
    public PlaceOrderGUI2GC(Seller seller) {
        super("/views/views2/form/buyer/PlaceOrder.fxml");
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
                List<OrderLine> lines = this.productSelectionGUI2GC.getLines();
                controller.addProductsToOrder(lines);
                break;
            case DELIVERY_SELECTION:
                Delivery delivery = this.deliverySelectionGUI1GC.getDeliveryInfo();
                controller.defineDelivery(delivery);
                break;
            case PAYMENT_SELECTION:
                Payment payment = this.paymentSelectionGUI2GC.getPaymentInfo();
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
        this.productSelectionGUI2GC = new ProductSelectionGUI2GC(products);
        paneContent.getChildren().clear();
        paneContent.getChildren().add(productSelectionGUI2GC.getRoot());
    }

    @Override
    public void goToDeliverySelection(Seller seller) {
        buttonNext.setVisible(true);
        buttonBack.setVisible(true);
        this.deliverySelectionGUI1GC = new DeliverySelectionGUI2GC(seller);
        paneContent.getChildren().clear();
        paneContent.getChildren().add(deliverySelectionGUI1GC.getRoot());
    }

    @Override
    public void goToPaymentSelection(EnumSet<PaymentType> activePaymentTypes, BigDecimal totalPrice) {
        buttonNext.setVisible(false);
        buttonBack.setVisible(true);
        this.paymentSelectionGUI2GC = new PaymentSelectionGUI2GC(this, activePaymentTypes, totalPrice);
        paneContent.getChildren().clear();
        paneContent.getChildren().add(paymentSelectionGUI2GC.getRoot());
    }

    @Override
    public void goToOrderSummary() {
        buttonNext.setVisible(true);
        buttonBack.setVisible(false);
        OrderSummaryGUI2GC orderSummaryGUI2GC = new OrderSummaryGUI2GC();
        paneContent.getChildren().clear();
        paneContent.getChildren().add(orderSummaryGUI2GC.getRoot());
    }

    @Override
    public void showError(Exception e) {
        if (e instanceof ProductException) {
            productSelectionGUI2GC.showError(e);
        } else if (e instanceof DeliveryException) {
            deliverySelectionGUI1GC.showError(e);
        } else if (e instanceof PaymentException) {
            paymentSelectionGUI2GC.showError(e);
        }
    }

    @Override
    protected void setupTexts() {
        String backText = null;
        try {
            backText = I18n.t(currentStep.previous().getStep());
        } catch (StartOfEnumException e) {
            backText = I18n.t("BACK");
        }
        String nextText = null;
        try {
            nextText = I18n.t(currentStep.next().getStep());
        } catch (EndOfEnumException e) {
            nextText = I18n.t("NEXT");
        }
        buttonBack.setText(backText);
        buttonNext.setText(nextText);
        textSellerName.setText(seller.getName());
        textOrderStep.setText(currentStep.getStep());
    }
}
