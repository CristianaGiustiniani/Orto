package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.FindFarmersController;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.Seller;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.Session;

import java.util.List;

public interface FindFarmersGC {
    default List<Seller> retrieveFarmers() {
        try {
            return (new FindFarmersController()).getFarmers();
        } catch (ConnectionException e) {
            showError(I18n.t("ERROR_CONNECTION"));
            GCFactory.getInstance().createHome();
        }
        return null;
    }

    default void placeOrder(Seller seller) {
        if (Session.getInstance().isLogged()) {
            GCFactory.getInstance().createPlaceOrder(seller);
        } else {
            GCFactory.getInstance().createLogin();
        }
    }

    void showError(String message);
}
