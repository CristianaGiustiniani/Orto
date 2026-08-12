package com.orto.logic.graphic_controller.controller;

import com.orto.logic.utils.Session;

public interface HomeGC {
    default void viewPurchases() {
        if (Session.getInstance().isLogged()) {
            GCFactoryProvider.getInstance().createPurchaseHistory();
        } else {
            GCFactoryProvider.getInstance().createLogin();
        }
    }

    default void findFarmers() {
        GCFactoryProvider.getInstance().createFindFarmers();
    }
}
