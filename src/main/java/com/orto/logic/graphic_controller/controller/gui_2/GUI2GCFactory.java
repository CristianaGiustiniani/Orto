package com.orto.logic.graphic_controller.controller.gui_2;


import com.orto.logic.graphic_controller.controller.*;
import com.orto.logic.graphic_controller.controller.gui_2.background.AuthenticatedBackgroundGUI2GC;
import com.orto.logic.graphic_controller.controller.gui_2.background.PublicBackgroundGUI2GC;
import com.orto.logic.graphic_controller.controller.gui_2.find_farmers.FindFarmersGUI2GC;
import com.orto.logic.graphic_controller.controller.gui_2.home.HomeGUI2GC;
import com.orto.logic.graphic_controller.controller.gui_2.login.LoginGUI2GC;
import com.orto.logic.graphic_controller.controller.gui_2.place_order.PlaceOrderGUI2GC;
import com.orto.logic.graphic_controller.controller.gui_2.purchase_history.PurchaseHistoryGUI2GC;
import com.orto.logic.model.entity.Seller;

public class GUI2GCFactory extends GCFactory {
    @Override
    public PublicBackgroundGC createPublicBackground() { return new PublicBackgroundGUI2GC(); }

    @Override
    public AuthenticatedBackgroundGC createAuthenticatedBackground() { return new AuthenticatedBackgroundGUI2GC(); }

    @Override
    public HomeGC createHome() { return new HomeGUI2GC(); }

    @Override
    public LoginGC createLogin() {
        return new LoginGUI2GC();
    }

    @Override
    public FindFarmersGC createFindFarmers() {
        return new FindFarmersGUI2GC();
    }

    @Override
    public PlaceOrderGC createPlaceOrder(Seller seller) {
        return new PlaceOrderGUI2GC(seller);
    }

    @Override
    public PurchaseHistoryGC createPurchaseHistory() {
        return new PurchaseHistoryGUI2GC();
    }
}
