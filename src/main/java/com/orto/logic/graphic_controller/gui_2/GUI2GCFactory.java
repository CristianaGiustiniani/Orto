package com.orto.logic.graphic_controller.gui_2;


import com.orto.logic.controller.bean.SellerBean;
import com.orto.logic.graphic_controller.*;
import com.orto.logic.graphic_controller.graphic_elements.AuthenticatedBackgroundGC;
import com.orto.logic.graphic_controller.graphic_elements.PublicBackgroundGC;
import com.orto.logic.graphic_controller.gui_2.background.AuthenticatedBackgroundGUI2GC;
import com.orto.logic.graphic_controller.gui_2.background.PublicBackgroundGUI2GC;
import com.orto.logic.graphic_controller.gui_2.find_farmers.FindFarmersGUI2GC;
import com.orto.logic.graphic_controller.gui_2.home.HomeGUI2GC;
import com.orto.logic.graphic_controller.gui_2.login.LoginGUI2GC;
import com.orto.logic.graphic_controller.gui_2.place_order.PlaceOrderGUI2GC;
import com.orto.logic.graphic_controller.gui_2.purchase_history.PurchaseHistoryGUI2GC;

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
    public PlaceOrderGC createPlaceOrder(SellerBean seller) {
        return new PlaceOrderGUI2GC(seller);
    }

    @Override
    public PurchaseHistoryGC createPurchaseHistory() {
        return new PurchaseHistoryGUI2GC();
    }
}
