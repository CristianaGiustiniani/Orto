package com.orto.logic.graphic_controller.controller.gui_1.find_farmers;


import com.orto.logic.graphic_controller.bean.SellerBean;
import com.orto.logic.graphic_controller.controller.FindFarmersGC;
import com.orto.logic.graphic_controller.controller.GCFactory;
import com.orto.logic.graphic_controller.controller.GUIGC;
import com.orto.logic.graphic_controller.controller.mapper.SellerMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindFarmersGUIGC extends GUIGC implements FindFarmersGC {
    //FXML ATTRIBUTES
    @FXML private VBox vBoxFarmerTable;

    //CONSTRUCTOR
    public FindFarmersGUIGC() {
        super("views/views1/form/FindFarmers.fxml");
        root = this.load();
        createChildren();
    }

    //INPUT METHODS

    //OUTPUT METHODS
    private void createChildren() {
        //retrieve sellers
        List<SellerBean> sellers = (new SellerMapper()).toBeans(retrieveFarmers());

        //for each seller, create row
        List <FarmerListItemGUI1View> rows = new ArrayList<>();

        for (SellerBean seller : sellers) {
            rows.add(new FarmerListItemGUI1View(seller));
            rows.getLast().setPlaceOrder(this::placeOrder);
            vBoxFarmerTable.getChildren().add(rows.getLast().getRoot());
        }
    }

    @Override
    protected void setupTexts() {
    }

    @Override
    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            GCFactory.getInstance().createHome();
        }
    }
}


