package com.orto.logic.graphic_controller.gui_1.find_farmers;

import com.orto.logic.graphic_controller.exceptions.FailedFXMLLoadException;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.ProductType;
import com.orto.logic.controller.bean.AddressBean;
import com.orto.logic.controller.bean.SellerBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class FarmerListItemGUI1GC extends HBox {
    //ATTRIBUTES
    private Consumer<SellerBean> placeOrder;
    private final SellerBean seller;

    //FXML ATTRIBUTES
    private final Parent root;
    @FXML Button buttonPlaceOrder;
    @FXML Text textFarmerLocation;
    @FXML Text textFarmerName;
    @FXML Text textProductTypes;

    //CONSTRUCTOR
    public FarmerListItemGUI1GC(SellerBean seller) {
        this.seller = seller;
        root = load();
        setupTexts();
    }

    //INPUT METHODS
    @FXML private void onClickPlaceOrder(){
        placeOrder(this.seller);
    }

    private void placeOrder(SellerBean seller) {
        placeOrder.accept(seller);
    }

    public void setPlaceOrder(Consumer<SellerBean> callback) {
        this.placeOrder = callback;
    }


    //OUTPUT METHODS
    private Parent load() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/views1/form/findFarmersElements/FarmerListItem.fxml"));
            loader.setController(this);
            return loader.load();
        } catch (IOException e) {
            throw new FailedFXMLLoadException();
        }
    }

    protected void setupTexts() {
        buttonPlaceOrder.setText(I18n.t("GUI_FINDFARMERS_VIEW_PLACEORDER"));
        textFarmerName.setText(seller.getName());
        textFarmerLocation.setText(toString(seller.getAddress(), "half"));
        textProductTypes.setText(toString(seller.getProductTypes()));
    }

    private String toString(List<ProductType> types) {
        StringBuilder string = new StringBuilder();

        for(ProductType type: types) {
            string.append(switch (type) {
                case AGRICULTURAL -> I18n.t("PRODUCTTYPE_AGRICULTURAL");
                case ANIMAL -> I18n.t("PRODUCTTYPE_ANIMAL");
                case CLEANING_COSMETICS -> I18n.t("PRODUCTTYPE_CLEANINGCOSMETICS");
            }).append("\n");
        }
        string = new StringBuilder(string.substring(0, string.length() - 1));

        return string.toString();
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

    public Parent getRoot() {
        return root;
    }
}
