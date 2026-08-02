package com.orto.logic.graphic_controller.controller;

public interface HomeView {
    default void viewPurchases() {
        ViewFactory.getInstance().createPurchaseHistory();
    }
}
