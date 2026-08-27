package com.orto.logic.graphic_controller;

import com.orto.logic.utils.SessionManager;

public interface HomeGC {
    default void viewPurchases() {
        if (SessionManager.getInstance().isLogged()) {
            GCFactoryProvider.getInstance().createPurchaseHistory();
        } else {
            GCFactoryProvider.getInstance().createLogin();
        }
    }

    default void findFarmers() {
        GCFactoryProvider.getInstance().createFindFarmers();
    }
}
