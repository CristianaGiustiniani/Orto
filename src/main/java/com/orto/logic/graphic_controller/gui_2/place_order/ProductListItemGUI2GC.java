package com.orto.logic.graphic_controller.gui_2.place_order;

import com.orto.logic.controller.bean.ProductBean;
import com.orto.logic.graphic_controller.graphic_elements.ProductListItemGC;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ProductListItemGUI2GC extends ProductListItemGC {
    //FXML ATTRIBUTES
    @FXML Text textProductDescription;
    @FXML Text textProductPrice;

    //CONSTRUCTOR
    public ProductListItemGUI2GC(ProductBean product) {
        super(product);
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        super.setupTexts();
        textProductDescription.setText(product.getDescription());
        textProductPrice.setText("€" + product.getPrice() + "/" + toString(product.getQuantityUnit()));
    }
}
