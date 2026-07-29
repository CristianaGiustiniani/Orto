package com.orto.logic.view_controller.ui;

import com.orto.logic.utils.Configuration;
import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.ui.gui_1.GUI1ViewFactory;

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

    public abstract View createHome();
    public abstract View createLogin();
    public abstract View createFindFarmers();
    public abstract View createPlaceOrder(SellerBean seller);
    public abstract View createPurchaseHistory();
}
