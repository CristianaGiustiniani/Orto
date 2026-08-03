package com.orto.logic.graphic_controller.controller;

public interface HomeGC {
    default void viewPurchases() {
       GCFactory.getInstance().createPurchaseHistory();
    }

    default void findFarmers() {
        GCFactory.getInstance().createFindFarmers();
    }
}
