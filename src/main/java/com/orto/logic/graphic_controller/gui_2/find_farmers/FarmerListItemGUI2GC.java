package com.orto.logic.graphic_controller.gui_2.find_farmers;

import com.orto.logic.controller.FindFarmersController;
import com.orto.logic.controller.bean.SellerBean;
import com.orto.logic.graphic_controller.graphic_elements.FarmerListItemGC;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class FarmerListItemGUI2GC extends FarmerListItemGC {
    //ATTRIBUTES
    private final FindFarmersController controller;

    //FXML ATTRIBUTES
    @FXML private Text textOpeningStatus;

    //CONSTRUCTOR
    public FarmerListItemGUI2GC(SellerBean seller) {
        super(seller, "/views/views2/form/findFarmersElements/FarmerListItem.fxml");
        this.controller = new FindFarmersController();
        setupTexts();
    }

    //OUTPUT METHODS
    @Override
    protected void setupTexts() {
        buttonPlaceOrder.setText(I18n.t("GUI_FINDFARMERS_VIEW_PLACEORDER"));
        textFarmerName.setText(seller.getName());
        textFarmerLocation.setText(toString(seller.getAddress(), "half"));
        textProductTypes.setText(toString(seller.getProductTypes()));
        String openingStatus = I18n.t(controller.isSellerOpen(seller) ? "GUI_FINDFARMERS_VIEW_OPEN" : "GUI_FINDFARMERS_VIEW_CLOSED");
        textOpeningStatus.setText(openingStatus);
    }
}
