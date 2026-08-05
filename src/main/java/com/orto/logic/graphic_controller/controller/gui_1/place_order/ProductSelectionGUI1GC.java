package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.graphic_controller.controller.GUIGC;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ProductSelectionGUI1GC extends GUIGC {

    //FXML ATTRIBUTES
    @FXML
    private VBox vBoxContent;
    @FXML private Text textProductName;
    @FXML private Text textDescription;
    @FXML private Text textPrice;
    @FXML private Text textQuantity;
    @FXML private Text textAdditionalRequests;
    @FXML private ScrollPane scrollPaneProductTable;

    //CONSTRUCTOR

    public ProductSelectionGUI1GC() {
        super("/views/views1/form/buyer/placeOrderElements/ProductSelection.fxml");
        root = load();
        setupTexts();
    }

    //INPUT METHODS

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {}

}
