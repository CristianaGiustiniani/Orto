package com.orto.logic.graphic_controller.gui_1.place_order;

import com.orto.logic.controller.bean.ProductBean;
import com.orto.logic.graphic_controller.graphic_elements.ProductListItemGC;

public class ProductListItemGUI1GC extends ProductListItemGC {
    //CONSTRUCTOR
    public ProductListItemGUI1GC(ProductBean product) {
        super(product, "/views/views1/form/buyer/placeOrderElements/ProductListItem.fxml");
    }

}
