package com.orto.logic.graphic_controller.controller;

import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.Configuration;
import com.orto.logic.graphic_controller.controller.gui_1.GUI1ViewFactory;

public abstract class ViewFactory {
    private static ViewFactory me = null;
    protected ViewFactory() {}

    public static synchronized ViewFactory getInstance() {
        if (me == null) {
            switch (Configuration.getInstance().getUIType()) {
                case GUI_1 -> me = new GUI1ViewFactory();
                //todo: implement GUI_2
                //case GUI_2 -> me = new GUI2ViewFactory();
            }
        }
        return me;
    }

    public abstract PublicBackgroundView createPublicBackground();
    public abstract AuthenticatedBackgroundView createAuthenticatedBackground();
    public abstract HomeView createHome();
    public abstract LoginView createLogin();
    public abstract FindFarmersView createFindFarmers();
    public abstract PlaceOrderView createPlaceOrder(Seller seller);
    public abstract PurchaseHistoryView createPurchaseHistory();
}
