package com.orto.logic.graphic_controller.controller.gui_1.find_farmers;

import com.orto.logic.graphic_controller.controller.FindFarmersGC;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.model.entity.Seller;
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
        setupTexts();
    }

    //INPUT METHODS

    //OUTPUT METHODS
    private void createChildren() {
        //retrieve sellers
        List<Seller> sellers = retrieveFarmers();

        //for each seller, create row
        List <FarmerListItemGUI1GC> rows = new ArrayList<>();

        for (Seller seller : sellers) {
            rows.add(new FarmerListItemGUI1GC(seller));
            rows.getLast().setPlaceOrder(this::placeOrder);
            vboxFarmers.getChildren().add(rows.getLast().getRoot());
        }
    }

    @Override
    protected void setupTexts() {
        //no text to set up
    }

    @Override
    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


