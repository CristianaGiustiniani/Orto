package com.orto.logic.graphic_controller.controller;

import com.orto.logic.model.entity.Seller;

public abstract class GCFactory {
    protected GCFactory() {}

    public abstract PublicBackgroundGC createPublicBackground();
    public abstract AuthenticatedBackgroundGC createAuthenticatedBackground();
    public abstract HomeGC createHome();
    public abstract LoginGC createLogin();
    public abstract FindFarmersGC createFindFarmers();
    public abstract PlaceOrderGC createPlaceOrder(Seller seller);
    public abstract PurchaseHistoryGC createPurchaseHistory();
}
