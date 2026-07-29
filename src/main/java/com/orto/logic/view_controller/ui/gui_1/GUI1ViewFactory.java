package com.orto.logic.view_controller.ui.gui_1;


import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.ui.View;
import com.orto.logic.view_controller.ui.ViewFactory;
import com.orto.logic.view_controller.ui.gui_1.find_farmers.FindFarmersGUI1View;
import com.orto.logic.view_controller.ui.gui_1.home.HomeGUI1View;
import com.orto.logic.view_controller.ui.gui_1.login.LoginGUI1View;
import com.orto.logic.view_controller.ui.gui_1.place_order.PlaceOrderGUI1View;
import com.orto.logic.view_controller.ui.gui_1.purchase_history.PurchaseHistoryGUI1View;

public class GUI1ViewFactory extends ViewFactory {
    @Override
    public View createHome() {
        return new HomeGUI1View();
    }

    @Override
    public View createLogin() {
        return new LoginGUI1View();
    }

    @Override
    public View createFindFarmers() {
        return new FindFarmersGUI1View();
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
