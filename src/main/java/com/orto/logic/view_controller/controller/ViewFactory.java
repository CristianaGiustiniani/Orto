package com.orto.logic.view_controller.controller;

import com.orto.logic.utils.Configuration;
import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.controller.gui_1.GUI1ViewFactory;

public abstract class ViewFactory {
    private static ViewFactory me = null;
    protected ViewFactory() {}

    public static synchronized ViewFactory getInstance() {
        if (me == null) {
            switch (Configuration.getInstance().getUIType()) {
                case GUI_1 -> me = new GUI1ViewFactory(); break;
                case GUI_2 -> me = new GUI2ViewFactory(); break;
            }
        }
        return me;
    }

    public abstract HomeView createHome();
    public abstract LoginView createLogin();
    public abstract FindFarmersView createFindFarmers();
    public abstract PlaceOrderView createPlaceOrder(SellerBean seller);
    public abstract PurchaseHistoryView createPurchaseHistory();
}
