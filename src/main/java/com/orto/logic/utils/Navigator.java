package com.orto.logic.utils;

import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.ui.View;
import com.orto.logic.view_controller.ui.ViewFactory;

import static com.orto.logic.utils.ViewType.PLACE_ORDER;

public abstract class Navigator {
    ViewFactory factory;

    public void goTo(ViewType viewType) {
        View view;

        switch (viewType) {
            case HOME, FIND_FARMERS:
                view = factory.createHome();
                break;
            case LOGIN:
                view = factory.createLogin();
                break;
            case PURCHASE_HISTORY:
                view = factory.createPurchaseHistory();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

        view.show();
    }

    public void goTo(ViewType viewType, SellerBean seller) {
        View view;

        if (viewType == PLACE_ORDER) {
            view = factory.createPlaceOrder(seller);
        } else {
            throw new IllegalStateException("Unexpected value: " + viewType);
        }

        view.show();
    }
}
