package com.orto.logic.utils;

import com.orto.logic.utils.exceptions.EndOfEnumException;
import com.orto.logic.utils.exceptions.StartOfEnumException;

public enum PlaceOrderStep {
    PRODUCT_SELECTION,
    DELIVERY_SELECTION,
    PAYMENT_SELECTION,
    ORDER_SUMMARY;

    public String getStep() {
        return switch (this) {
            case PRODUCT_SELECTION -> I18n.t("STEP_PRODUCT_SELECTION");
            case PAYMENT_SELECTION -> I18n.t("STEP_PAYMENT_SELECTION");
            case DELIVERY_SELECTION -> I18n.t("STEP_DELIVERY_SELECTION");
            case ORDER_SUMMARY -> I18n.t("STEP_ORDER_SUMMARY");
        };
    }

    public PlaceOrderStep next() throws EndOfEnumException {
        return switch (this) {
            case PRODUCT_SELECTION -> DELIVERY_SELECTION;
            case DELIVERY_SELECTION -> PAYMENT_SELECTION;
            case PAYMENT_SELECTION -> ORDER_SUMMARY;
            default -> throw new EndOfEnumException();
        };
    }

    public PlaceOrderStep previous() throws StartOfEnumException {
        return switch (this) {
            case DELIVERY_SELECTION -> PRODUCT_SELECTION;
            case PAYMENT_SELECTION -> DELIVERY_SELECTION;
            case ORDER_SUMMARY -> PAYMENT_SELECTION;
            default -> throw new StartOfEnumException();
        };
    }
}
