package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.controller.PlaceOrderController;
import com.orto.logic.graphic_controller.controller.GCFactory;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.*;
import com.orto.logic.graphic_controller.controller.PlaceOrderGC;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class PlaceOrderGUI1GC extends GUIGC implements PlaceOrderGC {
    //CONTROLLER
    private PlaceOrderController controller;

    //ATTRIBUTES
    private Seller seller;
    private PlaceOrderStep currentStep;
    private ProductSelectionGUI1GC productSelectionView;
    private DeliverySelectionGUI1GC deliverySelectionView;
    private PaymentSelectionGUI1GC paymentSelectionView;
    private OrderSummaryGUI1GC orderSummaryView;

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

        if (background instanceof BorderPane borderPane) {
            borderPane.setCenter(placeOrder);
            root = background;
        } else {
            root = placeOrder;
        }

        setupTexts();
        goToStep(currentStep);

        Configuration.getInstance().getStage().setScene(new Scene(root));
        show();
    }

    //INPUT METHODS
    @FXML private void onClickButtonBack() {
        goToPreviousStep();
    }

    @FXML private void onClickButtonNext() {
        goToNextStep();
    }

    //OUTPUT METHODS
    @Override
    public PlaceOrderController getController() {
        return controller;
    }

    @Override
    public PlaceOrderStep getCurrentStep() {
        return currentStep;
    }

    @Override
    public void setCurrentStep(PlaceOrderStep step) {
        this.currentStep = step;
        setupTexts();
    }

    @Override
    public void goToProductSelection() {
        this.productSelectionView = new ProductSelectionGUI1GC();
        paneContent.getChildren().clear();
        if (productSelectionView.getRoot() != null) {
            paneContent.getChildren().add(productSelectionView.getRoot());
        }
    }

    @Override
    public void goToDeliverySelection() {
        this.deliverySelectionView = new DeliverySelectionGUI1GC();
        paneContent.getChildren().clear();
        if (deliverySelectionView.getRoot() != null) {
            paneContent.getChildren().add(deliverySelectionView.getRoot());
        }
    }

    @Override
    public void goToPaymentSelection() {
        this.paymentSelectionView = new PaymentSelectionGUI1GC();
        paneContent.getChildren().clear();
        if (paymentSelectionView.getRoot() != null) {
            paneContent.getChildren().add(paymentSelectionView.getRoot());
        }
    }

    @Override
    public void goToOrderSummary() {
        if (buttonBack != null) {
            buttonBack.setVisible(true);
        }
        this.orderSummaryView = new OrderSummaryGUI1GC();
        paneContent.getChildren().clear();
        if (orderSummaryView.getRoot() != null) {
            paneContent.getChildren().add(orderSummaryView.getRoot());
        }
    }

    @Override
    public void collectAndValidateCurrentStepData() {
        // Collect and validate current step data
    }

    @Override
    public void showError(String message, Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    protected void setupTexts() {
        if (buttonBack != null) {
            buttonBack.setText(I18n.t("BACK"));
        }
        if (buttonNext != null) {
            buttonNext.setText(I18n.t("NEXT"));
        }
        if (textSellerName != null && seller != null) {
            textSellerName.setText(seller.getName());
        }
        if (textOrderStep != null && currentStep != null) {
            textOrderStep.setText(currentStep.getStep());
        }
    }
}
