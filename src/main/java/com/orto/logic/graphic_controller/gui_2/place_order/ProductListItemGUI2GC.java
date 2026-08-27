package com.orto.logic.graphic_controller.gui_2.place_order;

import com.orto.logic.controller.bean.ProductBean;
import com.orto.logic.graphic_controller.graphic_elements.ProductListItemGC;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class ProductListItemGUI2GC extends ProductListItemGC {
    //FXML ATTRIBUTES
    @FXML Text textQuantity;
    @FXML Text textAdditionalRequests;

    //CONSTRUCTOR
    public ProductListItemGUI2GC(ProductBean product) {
        super(product, "/views/views2/form/buyer/placeOrderElements/ProductListItem.fxml");
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        super.setupTexts();
        textQuantity.setText(I18n.t("GUI_PLACEORDER_PRODUCTSELECTION_VIEW_QUANTITY"));
        textAdditionalRequests.setText(I18n.t("GUI_PLACEORDER_PRODUCTSELECTION_VIEW_ADDITIONALREQUESTS"));
    }
}
