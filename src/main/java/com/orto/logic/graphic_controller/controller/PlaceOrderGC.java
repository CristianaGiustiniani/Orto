package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.PlaceOrderController;
import com.orto.logic.graphic_controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.graphic_controller.bean.exceptions.NotPositiveQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.graphic_controller.controller.exceptions.DeliveryException;
import com.orto.logic.graphic_controller.controller.exceptions.InvalidDeliveryInfoException;
import com.orto.logic.graphic_controller.controller.exceptions.ProductException;
import com.orto.logic.model.entity.Product;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.model.entity.exceptions.NoProductSelectedException;
import com.orto.logic.utils.PaymentType;
import com.orto.logic.utils.PlaceOrderStep;
import com.orto.logic.utils.exceptions.EndOfEnumException;
import com.orto.logic.utils.exceptions.StartOfEnumException;
import com.orto.logic.model.dao.exceptions.ConnectionException;

import java.util.EnumSet;
import java.util.List;

public interface PlaceOrderGC {
    default void goToNextStep() {
        try {
            collectData();
            PlaceOrderStep nextStep = getCurrentStep().next();
            setCurrentStep(nextStep);
            goToStep(nextStep);
        } catch (EndOfEnumException e) {
            GCFactory.getInstance().createHome();
        } catch (ProductException | DeliveryException e) {
            showError(e);
        }
    }

    default void goToPreviousStep() {
        try {
            PlaceOrderStep previousStep = getCurrentStep().previous();
            setCurrentStep(previousStep);
            goToStep(previousStep);
        } catch (StartOfEnumException e) {
            GCFactory.getInstance().createHome();
        }
    }

    default void goToStep(PlaceOrderStep step) {
        switch (step) {
            case PRODUCT_SELECTION:
                getController().startOrder(getSeller());
                List<Product> products = null;
                try {
                    products = getController().retrieveProducts();
                } catch (ConnectionException e) {
                    showError(e);
                }
                goToProductSelection(products);
                break;
            case DELIVERY_SELECTION:
                goToDeliverySelection(getSeller());
                break;
            case PAYMENT_SELECTION:
                EnumSet<PaymentType> activePaymentTypes;
                if (getController().isOrderShipped()) {
                    activePaymentTypes = EnumSet.of(PaymentType.ONLINE);
                } else {
                    activePaymentTypes = EnumSet.allOf(PaymentType.class);
                }
                goToPaymentSelection(activePaymentTypes);
                break;
            case ORDER_SUMMARY:
                try {
                    getController().saveOrder();
                } catch (ConnectionException e) {
                    showError(e);
                }
                getController().notifySeller();
                goToOrderSummary();
        }
    }

    Seller getSeller();
    PlaceOrderController getController();
    PlaceOrderStep getCurrentStep();
    void setCurrentStep(PlaceOrderStep step);
    void goToProductSelection(List<Product> products);
    void goToDeliverySelection(Seller seller);
    void goToPaymentSelection(EnumSet<PaymentType> activePaymentTypes);
    void goToOrderSummary();
    void showError(Exception e);
    void collectData() throws NotPositiveQuantityException, AnnotationTooLongException, WrongFormatQuantityException, InvalidDeliveryInfoException, NoProductSelectedException;

}