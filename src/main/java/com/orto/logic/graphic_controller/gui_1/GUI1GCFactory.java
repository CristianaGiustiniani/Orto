package com.orto.logic.graphic_controller.gui_1;


import com.orto.logic.controller.bean.SellerBean;
import com.orto.logic.graphic_controller.*;
import com.orto.logic.graphic_controller.gui_1.background.AuthenticatedBackgroundGUI1GC;
import com.orto.logic.graphic_controller.gui_1.background.PublicBackgroundGUI1GC;
import com.orto.logic.graphic_controller.gui_1.find_farmers.FindFarmersGUI1GC;
import com.orto.logic.graphic_controller.gui_1.home.HomeGUI1GC;
import com.orto.logic.graphic_controller.gui_1.login.LoginGUI1GC;
import com.orto.logic.graphic_controller.gui_1.place_order.PlaceOrderGUI1GC;
import com.orto.logic.graphic_controller.gui_1.purchase_history.PurchaseHistoryGUI1GC;

public class GUI1GCFactory extends GCFactory {
    @Override
    public PublicBackgroundGC createPublicBackground() { return new PublicBackgroundGUI1GC(); }

    @Override
    public AuthenticatedBackgroundGC createAuthenticatedBackground() { return new AuthenticatedBackgroundGUI1GC(); }

    @Override
    public HomeGC createHome() { return new HomeGUI1GC(); }

    @Override
    public LoginGC createLogin() {
        return new LoginGUI1GC();
    }

    @Override
    public FindFarmersGC createFindFarmers() {
        return new FindFarmersGUI1GC();
    }

    @Override
    public PlaceOrderGC createPlaceOrder(SellerBean seller) {
        return new PlaceOrderGUI1GC(seller);
    }

    @Override
    public PurchaseHistoryGC createPurchaseHistory() {
        return new PurchaseHistoryGUI1GC();
    }
}
