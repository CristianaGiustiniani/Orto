package com.orto.logic.graphic_controller.controller.gui_1;


import com.orto.logic.model.entity.Seller;
import com.orto.logic.graphic_controller.controller.*;
import com.orto.logic.graphic_controller.controller.gui_1.background.AuthenticatedBackgroundGUI1View;
import com.orto.logic.graphic_controller.controller.gui_1.background.PublicBackgroundGUI1View;
import com.orto.logic.graphic_controller.controller.gui_1.find_farmers.FindFarmersGUI1View;
import com.orto.logic.graphic_controller.controller.gui_1.home.HomeGUI1View;
import com.orto.logic.graphic_controller.controller.gui_1.login.LoginGUI1View;
import com.orto.logic.graphic_controller.controller.gui_1.place_order.PlaceOrderGUI1View;
import com.orto.logic.graphic_controller.controller.gui_1.purchase_history.PurchaseHistoryGUI1View;

public class GUI1ViewFactory extends ViewFactory {
    @Override
    public PublicBackgroundView createPublicBackground() { return new PublicBackgroundGUI1View(); }

    @Override
    public AuthenticatedBackgroundView createAuthenticatedBackground() { return new AuthenticatedBackgroundGUI1View(); }

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
    public PlaceOrderView createPlaceOrder(Seller seller) {
        return new PlaceOrderGUI1View(seller);
    }

    @Override
    public PurchaseHistoryView createPurchaseHistory() {
        return new PurchaseHistoryGUI1View();
    }
}
