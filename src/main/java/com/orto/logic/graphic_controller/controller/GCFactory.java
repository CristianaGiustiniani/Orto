package com.orto.logic.graphic_controller.controller;

import com.orto.logic.graphic_controller.controller.gui_1.GUI1GCFactory;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.Configuration;

public abstract class GCFactory {
    private static GCFactory me = null;
    protected GCFactory() {}

    public static synchronized GCFactory getInstance() {
        if (me == null) {
            switch (Configuration.getInstance().getUIType()) {
                case GUI_1 -> me = new GUI1GCFactory();
                //todo: implement GUI_2
                //case GUI_2 -> me = new GUI2ViewFactory();
            }
        }
        return me;
    }

    public abstract PublicBackgroundGC createPublicBackground();
    public abstract AuthenticatedBackgroundGC createAuthenticatedBackground();
    public abstract HomeGC createHome();
    public abstract LoginGC createLogin();
    public abstract FindFarmersGC createFindFarmers();
    public abstract PlaceOrderGC createPlaceOrder(Seller seller);
    public abstract PurchaseHistoryGC createPurchaseHistory();
}
