package com.orto.logic.view_controller.ui.gui_1.place_order;

import com.orto.logic.utils.*;
import com.orto.logic.utils.exceptions.EndOfEnumException;
import com.orto.logic.utils.exceptions.StartOfEnumException;
import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.ui.GUIView;
import com.orto.logic.view_controller.ui.PlaceOrderView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class PlaceOrderGUI1View extends GUIView implements PlaceOrderView {
    //ATTRIBUTES
    private SellerBean seller;
    private PlaceOrderStep currentStep;
    private ProductSelectionGUI1View productSelectionView;
    private ShippingSelectionGUI1View shippingSelectionView;
    private PaymentSelectionGUI1View paymentSelectionView;
    private OrderSummaryGUI1View orderSummaryView;

    //JAVAFX GRAPHIC ELEMENTS
    @FXML private Button buttonBack;
    @FXML private Button buttonNext;
    @FXML private Text textSellerName;
    @FXML private Text textOrderStep;
    @FXML private Pane paneContent;

    //BEANS

    //CONSTRUCTOR
    public PlaceOrderGUI1View(SellerBean seller) {
        super("views/views1/form/buyer/PlaceOrder.fxml");
        this.seller = seller;
        currentStep = PlaceOrderStep.PRODUCT_SELECTION;
        setupTexts();
    }

    //JAVAFX ACTIONS-EVENTS
    @FXML private void onClickButtonBack() {
        goToNextStep();
    }
    @FXML private void onClickButtonNext() {
        goToPreviousStep();
    }

    //SETUP
    @Override
    protected void setupTexts() {
        buttonBack.setText(I18n.t("BACK"));
        buttonNext.setText(I18n.t("NEXT"));
        textSellerName.setText(seller.getName());
        textOrderStep.setText(currentStep.getStep());
    }

    @Override
    protected void showError() {

    }

    //METHODS
    public void goToNextStep() {
        try {
            currentStep = currentStep.next();
            //show next step
        } catch (EndOfEnumException e) {
            //
        }
    }
    public void goToPreviousStep() {
        try {
            currentStep = currentStep.previous();
            //show previous step
        } catch (StartOfEnumException e) {
            throw new RuntimeException(e);
        }
    }
}
