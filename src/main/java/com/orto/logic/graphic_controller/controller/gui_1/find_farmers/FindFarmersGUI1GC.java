package com.orto.logic.graphic_controller.controller.gui_1.find_farmers;


import com.orto.logic.graphic_controller.bean.SellerBean;
import com.orto.logic.graphic_controller.controller.FindFarmersGC;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.mapper.SellerMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class FindFarmersGUI1GC extends GUIGC implements FindFarmersGC {
    //FXML ATTRIBUTES
    @FXML private VBox vboxFarmers;

    //CONSTRUCTOR
    public FindFarmersGUI1GC() {
        super("/views/views1/form/FindFarmers.fxml");
        root = this.load();
        createChildren();
    }

    //INPUT METHODS

    //OUTPUT METHODS
    private void createChildren() {
        //retrieve sellers
        List<SellerBean> sellers = (new SellerMapper()).toBeans(retrieveFarmers());

        //for each seller, create row
        List <FarmerListItemGUI1GC> rows = new ArrayList<>();

        for (SellerBean seller : sellers) {
            rows.add(new FarmerListItemGUI1GC(seller));
            rows.getLast().setPlaceOrder(this::placeOrder);
            vboxFarmers.getChildren().add(rows.getLast().getRoot());
        }
    }

    @Override
    protected void setupTexts() {
    }

    @Override
    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


