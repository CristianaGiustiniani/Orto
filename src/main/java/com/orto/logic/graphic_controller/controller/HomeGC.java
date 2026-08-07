package com.orto.logic.graphic_controller.controller;

import com.orto.logic.utils.Session;

public interface HomeGC {
    default void viewPurchases() {
        if (Session.getInstance().isLogged()) {
            GCFactory.getInstance().createPurchaseHistory();
        } else {
            GCFactory.getInstance().createLogin();
        }
    }

    default void findFarmers() {
        GCFactory.getInstance().createFindFarmers();
    }
}
