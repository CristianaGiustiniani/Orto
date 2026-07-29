package com.orto.logic.view_controller.controller.gui_1;


import com.orto.logic.view_controller.bean.SellerBean;
import com.orto.logic.view_controller.controller.*;
import com.orto.logic.view_controller.controller.gui_1.find_farmers.FindFarmersGUI1View;
import com.orto.logic.view_controller.controller.gui_1.home.HomeGUI1View;
import com.orto.logic.view_controller.controller.gui_1.login.LoginGUI1View;
import com.orto.logic.view_controller.controller.gui_1.place_order.PlaceOrderGUI1View;
import com.orto.logic.view_controller.controller.gui_1.purchase_history.PurchaseHistoryGUI1View;

public class GUI1ViewFactory extends ViewFactory {
    @Override
    public HomeView createHome() {
        return new HomeGUI1View();
    }

    @Override
    public LoginView createLogin() {
        return new LoginGUI1View();
    }

    @Override
    public FindFarmersView createFindFarmers() {
        return new FindFarmersGUI1View();
    }


    @Override
    public PlaceOrderView createPlaceOrder(SellerBean seller) {
        return new PlaceOrderGUI1View(seller);
    }

    @Override
    public PurchaseHistoryView createPurchaseHistory() {
        return new PurchaseHistoryGUI1View();
    }
}
