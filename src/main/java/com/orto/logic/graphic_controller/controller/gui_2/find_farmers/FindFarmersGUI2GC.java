package com.orto.logic.graphic_controller.controller.gui_2.find_farmers;


import com.orto.logic.graphic_controller.controller.FindFarmersGC;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.model.entity.Seller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class FindFarmersGUI2GC extends GUIGC implements FindFarmersGC {
    //FXML ATTRIBUTES
    @FXML private VBox vboxFarmers;

    //CONSTRUCTOR
    public FindFarmersGUI2GC() {
        super("/views/views1/form/FindFarmers.fxml");
        root = this.load();
        createChildren();
        setupTexts();
    }

    //INPUT METHODS

    //OUTPUT METHODS
    private void createChildren() {
        //retrieve sellers
        List<Seller> sellers = retrieveFarmers();

        //for each seller, create row
        List <FarmerListItemGUI2GC> rows = new ArrayList<>();

        for (Seller seller : sellers) {
            rows.add(new FarmerListItemGUI2GC(seller));
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


