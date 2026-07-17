package com.orto.logic.view_controller.ui;

import com.orto.logic.view_controller.bean.SellerBean;

public interface ViewFactory {
    View createHome();
    View createLogin();
    View createPlaceOrder(SellerBean seller);
    View createPurchaseHistory();
}
