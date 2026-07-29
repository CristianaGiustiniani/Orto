package com.orto.logic.controller;

import com.orto.logic.view_controller.ui.ViewFactory;

public class PurchaseHistoryController extends Controller{
    @Override
    public void start() {
        ViewFactory.getInstance().createPurchaseHistory().show();
    }
}
