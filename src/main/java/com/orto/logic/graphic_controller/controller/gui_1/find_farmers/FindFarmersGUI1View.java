package com.orto.logic.graphic_controller.controller.gui_1.find_farmers;


import com.orto.logic.graphic_controller.bean.SellerBean;
import com.orto.logic.graphic_controller.controller.FindFarmersView;
import com.orto.logic.graphic_controller.controller.GUIView;
import com.orto.logic.graphic_controller.controller.ViewFactory;
import com.orto.logic.graphic_controller.controller.mapper.SellerMapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindFarmersGUI1View extends GUIView implements FindFarmersView {
    //FXML ATTRIBUTES
    @FXML VBox vBoxFarmerTable;

    //CONSTRUCTOR
    public FindFarmersGUI1View() {
        super("views/views1/form/FindFarmers.fxml");
        root = this.load();
        createChildren();
    }

    //INPUT METHODS

    //OUTPUT METHODS
    private void createChildren() {
        //retrieve sellers
        List<SellerBean> sellers = (new SellerMapper()).toBeans(retrieveFarmers());

        //for each seller, create hbox row
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
            ViewFactory.getInstance().createHome();
        }
    }
}


