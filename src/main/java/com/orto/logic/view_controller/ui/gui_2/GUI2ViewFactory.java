package com.orto.logic.view_controller.ui.gui_2;


import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.ui.View;
import com.orto.logic.view_controller.ui.ViewFactory;
import com.orto.logic.view_controller.ui.gui_1.login.LoginGUI1View;
import com.orto.logic.view_controller.ui.gui_1.place_order.PlaceOrderGUI1View;
import com.orto.logic.view_controller.ui.gui_1.purchase_history.PurchaseHistoryGUI1View;

public class GUI2ViewFactory implements ViewFactory {
    @Override
    public View createHome() {
        return new HomeGUI2View();
    }
    //todo: refactor the created items
    @Override
    public View createLogin() {
        return new LoginGUI1View();
    }

    @Override
    public View createPlaceOrder(SellerBean seller) {
        return new PlaceOrderGUI1View(seller);
    }

    @Override
    public View createPurchaseHistory() {
        return new PurchaseHistoryGUI1View();
    }
}
