package com.orto.logic.graphic_controller.gui_1.find_farmers;

import com.orto.logic.graphic_controller.graphic_elements.FarmerListItemGC;
import com.orto.logic.controller.bean.SellerBean;

public class FarmerListItemGUI1GC extends FarmerListItemGC {
    //CONSTRUCTOR
    public FarmerListItemGUI1GC(SellerBean seller) {
        super(seller, "/views/views1/form/findFarmersElements/FarmerListItem.fxml");
        setupTexts();
    }
}
