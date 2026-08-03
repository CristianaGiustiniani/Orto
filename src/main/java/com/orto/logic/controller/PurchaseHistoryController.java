package com.orto.logic.controller;

import com.orto.logic.graphic_controller.controller.GCFactory;

public class PurchaseHistoryController {
    public void start() {
        GCFactory.getInstance().createPurchaseHistory();
    }
}
