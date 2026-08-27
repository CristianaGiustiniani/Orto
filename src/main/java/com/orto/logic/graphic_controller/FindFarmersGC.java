package com.orto.logic.graphic_controller;

import com.orto.logic.controller.FindFarmersController;
import com.orto.logic.controller.bean.SellerBean;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.SessionManager;

import java.util.Collections;
import java.util.List;

public interface FindFarmersGC {
    default List<SellerBean> retrieveFarmers() {
        try {
            return (new FindFarmersController()).getFarmers();
        } catch (ConnectionException e) {
            showError(I18n.t("ERROR_CONNECTION"));
            GCFactoryProvider.getInstance().createHome();
        }
        return Collections.emptyList();
    }

    default void placeOrder(SellerBean seller) {
        if (SessionManager.getInstance().isLogged()) {
            GCFactoryProvider.getInstance().createPlaceOrder(seller);
        } else {
            GCFactoryProvider.getInstance().createLogin();
        }
    }

    void showError(String message);
}
