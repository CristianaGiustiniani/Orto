package com.orto.logic.view_controller.controller;

import com.orto.logic.utils.PlaceOrderStep;

public interface PlaceOrderView {
    public default void goToNextStep() {

    }
    public default void goToPreviousStep() {}
    private void showStep(PlaceOrderStep step) {
        switch (step) {
            case PRODUCT_SELECTION -> goToProductSelection();
            case DELIVERY_SELECTION -> goToDeliverySelection();
            case PAYMENT_SELECTION -> goToPaymentSelection();
            case ORDER_SUMMARY -> goToOrderSummary();
        }
    }
    private void goToProductSelection() {}
    private void goToDeliverySelection() {}
    private void goToPaymentSelection() {}
    private void goToOrderSummary() {}
}
