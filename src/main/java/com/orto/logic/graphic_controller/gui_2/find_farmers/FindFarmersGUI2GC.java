package com.orto.logic.graphic_controller.gui_2.find_farmers;


import com.orto.logic.controller.bean.SellerBean;
import com.orto.logic.graphic_controller.FindFarmersGC;
import com.orto.logic.graphic_controller.GUIGC;
import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class FindFarmersGUI2GC extends GUIGC implements FindFarmersGC {
    //FXML ATTRIBUTES
    @FXML private VBox vboxFarmers;
    @FXML private Text textTitleFindFarmers;
    @FXML private Text textSubtitleFindFarmers;

    //CONSTRUCTOR
    public FindFarmersGUI2GC() {
        super("/views/views2/form/FindFarmers.fxml");

        Parent background = loadBackground();
        Parent findFarmers = this.load();
        ((BorderPane) background).setCenter(findFarmers);
        root = background;

        createChildren();
        setupTexts();

        Configuration.getInstance().getStage().setScene(new Scene(root));
    }

    //INPUT METHODS

    //OUTPUT METHODS
    private void createChildren() {
        //retrieve sellers
        List<SellerBean> sellers = retrieveFarmers();

        //for each seller, create row
        List <FarmerListItemGUI2GC> rows = new ArrayList<>();

        for (SellerBean seller : sellers) {
            rows.add(new FarmerListItemGUI2GC(seller));
            rows.getLast().setPlaceOrder(this::placeOrder);
            vboxFarmers.getChildren().add(rows.getLast().getRoot());
        }
    }

    @Override
    protected void setupTexts() {
        textTitleFindFarmers.setText(I18n.t("GUI_FINDFARMERS_VIEW_TITLE"));
        textSubtitleFindFarmers.setText(I18n.t("GUI_FINDFARMERS_VIEW_SUBTITLE"));
    }

    @Override
    public void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


