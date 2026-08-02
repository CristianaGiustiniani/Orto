package com.orto.logic.graphic_controller.controller;

import com.orto.logic.controller.FindFarmersController;
import com.orto.logic.model.dao.exceptions.ConnectionException;
import com.orto.logic.model.entity.Seller;

import java.util.List;

public interface FindFarmersView {
    default List<Seller> retrieveFarmers() {
        try {
            return (new FindFarmersController()).getFarmers();
        } catch (ConnectionException e) {
            //todo: i18 the error message
            showError("Our database is currently not working. Try later.");
        }
        return null;
    }

    default void placeOrder(Seller seller) {
        ViewFactory.getInstance().createPlaceOrder(seller);
    }

    void showError(String message);
}
