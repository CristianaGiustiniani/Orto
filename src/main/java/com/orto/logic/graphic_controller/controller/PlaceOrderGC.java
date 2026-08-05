package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.PlaceOrderController;
import com.orto.logic.utils.PlaceOrderStep;
import com.orto.logic.utils.exceptions.EndOfEnumException;
import com.orto.logic.utils.exceptions.StartOfEnumException;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.utils.I18n;

public interface PlaceOrderGC {
    default void goToNextStep() {
        try {
            // 1. Gather data / validate current step via bean
            collectAndValidateCurrentStepData();

            // 2. Advance step and update view
            PlaceOrderStep nextStep = getCurrentStep().next();
            setCurrentStep(nextStep);
            goToStep(nextStep);
        } catch (EndOfEnumException e) {
            // Final step: trigger controller to save order and return home
            try {
                getController().saveOrder();
                GCFactory.getInstance().createHome();
            } catch (ConnectionException ex) {
                showError(I18n.t("ERROR_CONNECTION"), ex);
                GCFactory.getInstance().createHome();
            }
        } catch (Exception e) {
            showError(e.getMessage(), e);
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
            case PRODUCT_SELECTION -> goToProductSelection();
            case DELIVERY_SELECTION -> goToDeliverySelection();
            case PAYMENT_SELECTION -> goToPaymentSelection();
            case ORDER_SUMMARY -> goToOrderSummary();
        }
    }

    PlaceOrderController getController();
    PlaceOrderStep getCurrentStep();
    void setCurrentStep(PlaceOrderStep step);
    void goToProductSelection();
    void goToDeliverySelection();
    void goToPaymentSelection();
    void goToOrderSummary();
    void showError(String message, Exception e);
    void collectAndValidateCurrentStepData();

}