package com.orto.logic.graphic_controller.controller.gui_1;


import com.orto.logic.model.entity.Seller;
import com.orto.logic.graphic_controller.controller.*;
import com.orto.logic.graphic_controller.controller.gui_1.background.AuthenticatedBackgroundGUIGC;
import com.orto.logic.graphic_controller.controller.gui_1.background.PublicBackgroundGUI1GC;
import com.orto.logic.graphic_controller.controller.gui_1.find_farmers.FindFarmersGUIGC;
import com.orto.logic.graphic_controller.controller.gui_1.home.HomeGUI1GC;
import com.orto.logic.graphic_controller.controller.gui_1.login.LoginGUI1GC;
import com.orto.logic.graphic_controller.controller.gui_1.place_order.PlaceOrderGUI1GC;
import com.orto.logic.graphic_controller.controller.gui_1.purchase_history.PurchaseHistoryGUI1GC;

public class GUI1GCFactory extends GCFactory {
    @Override
    public PublicBackgroundGC createPublicBackground() { return new PublicBackgroundGUI1GC(); }

    @Override
    public AuthenticatedBackgroundGC createAuthenticatedBackground() { return new AuthenticatedBackgroundGUIGC(); }

    @Override
    public HomeGC createHome() {

        return new HomeGUI1GC();
    }

    @Override
    public LoginGC createLogin() {
        return new LoginGUI1GC();
    }

    @Override
    public FindFarmersGC createFindFarmers() {
        return new FindFarmersGUIGC();
    }

    @Override
    public PlaceOrderGC createPlaceOrder(Seller seller) {
        return new PlaceOrderGUI1GC(seller);
    }

    @Override
    public PurchaseHistoryGC createPurchaseHistory() {
        return new PurchaseHistoryGUI1GC();
    }
}
