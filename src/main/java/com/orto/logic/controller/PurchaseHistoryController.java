package com.orto.logic.controller;

import com.orto.logic.graphic_controller.controller.ViewFactory;

public class PurchaseHistoryController extends Controller{
    public void start() {
        ViewFactory.getInstance().createPurchaseHistory();
    }
}
