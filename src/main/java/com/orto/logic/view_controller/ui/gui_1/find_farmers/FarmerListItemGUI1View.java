package com.orto.logic.view_controller.ui.gui_1.find_farmers;

import com.orto.logic.utils.I18n;
import com.orto.logic.utils.ProductType;
import com.orto.logic.view_controller.bean.AddressBean;
import com.orto.logic.view_controller.bean.SellerBean;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.List;

public class FarmerListItemGUI1View {
    //CONSTRUCTOR
    public FarmerListItemGUI1View(SellerBean bean) {
        this.bean = bean;
    }

    //ATTRIBUTES
    private String fxmlPath = "views/views1/form/findFarmersElements/FarmerListItem.fxml";
    SellerBean bean;
    @FXML Button buttonPlaceOrder;
    @FXML Text textFarmerLocation;
    @FXML Text textFarmerName;
    @FXML Text textProductTypes;

    //ACTION-EVENTS
    @FXML private void onClickPlaceOrder(){};

    //SETUP
    protected void setupTexts() {
        buttonPlaceOrder.setText(I18n.t("GUI_FINDFARMERS_VIEW_PLACEORDER"));
        textFarmerName.setText(bean.getName());
        textFarmerLocation.setText(bean.getAddress());


        textProductTypes.setText(ProductType.toString(bean.getProductTypes()));
    }

    //TEXT FORMATTING
    private String toString(ProductType type) {
        return switch (type) {
            case AGRICULTURAL -> I18n.t("PRODUCTTYPE_AGRICULTURAL");
            case ANIMAL -> I18n.t("PRODUCTTYPE_ANIMAL");
            case CLEANING_COSMETICS -> I18n.t("PRODUCTTYPE_CLEANINGCOSMETICS");
        };
    }

    private String toString(List<ProductType> types) {
        String string = "";

        for(ProductType type: types) {
            string += switch (type) {
                case AGRICULTURAL -> I18n.t("PRODUCTTYPE_AGRICULTURAL");
                case ANIMAL -> I18n.t("PRODUCTTYPE_ANIMAL");
                case CLEANING_COSMETICS -> I18n.t("PRODUCTTYPE_CLEANINGCOSMETICS");
            } + "\n";
        }
        string = string.substring(0, string.length() - 1);

        return string;
    }

    private String toString(AddressBean addressBean) {
        return (addressBean.getStreetName() + ", " +
                addressBean.getCivicNumber() + ", " +
                addressBean.getPostalCode() + ", " +
                addressBean.getCity() +
                " (" + addressBean.getProvince() + "), " +
                addressBean.getCountry());
    }

    private String toString(AddressBean addressBean, String mode) {
        if (mode.equals("half")) {
            return (addressBean.getCity() +
                    " (" + addressBean.getProvince() + ")");
        } else {
            return toString(addressBean);
        }
    }


}
