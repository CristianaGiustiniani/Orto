package com.orto.logic.graphic_controller;

import com.orto.logic.controller.bean.SellerBean;

public abstract class GCFactory {
    protected GCFactory() {}

    public abstract PublicBackgroundGC createPublicBackground();
    public abstract AuthenticatedBackgroundGC createAuthenticatedBackground();
    public abstract HomeGC createHome();
    public abstract LoginGC createLogin();
    public abstract FindFarmersGC createFindFarmers();
    public abstract PlaceOrderGC createPlaceOrder(SellerBean seller);
    public abstract PurchaseHistoryGC createPurchaseHistory();
}
