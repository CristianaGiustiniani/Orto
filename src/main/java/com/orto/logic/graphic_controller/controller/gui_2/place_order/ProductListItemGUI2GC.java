package com.orto.logic.graphic_controller.controller.gui_2.place_order;

import com.orto.logic.graphic_controller.bean.OrderLineBean;
import com.orto.logic.graphic_controller.bean.ProductBean;
import com.orto.logic.graphic_controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.graphic_controller.bean.exceptions.NotPositiveQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.NullQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.graphic_controller.controller.exceptions.FailedFXMLLoadException;
import com.orto.logic.graphic_controller.controller.mapper.ProductMapper;
import com.orto.logic.graphic_controller.controller.mapper.QuantityMapper;
import com.orto.logic.model.entity.OrderLine;
import com.orto.logic.model.entity.Product;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.QuantityUnit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class ProductListItemGUI2GC extends HBox {
    //ATTRIBUTES
    private final Product product;

    //FXML ATTRIBUTES
    private final Parent root;
    @FXML TextField inputQuantity;
    @FXML TextField inputAdditionalRequests;
    @FXML Text textProductName;
    @FXML Text textProductDescription;
    @FXML Text textProductPrice;

    //CONSTRUCTOR
    public ProductListItemGUI2GC(Product product) {
        this.product = product;
        root = load();
        setupTexts();
    }

    //INPUT METHODS
    public OrderLine getOrderLine() throws AnnotationTooLongException, NullQuantityException, NotPositiveQuantityException, WrongFormatQuantityException {
        OrderLineBean bean = new OrderLineBean();
        bean.setProductId(product.getId());
        bean.setProductName(product.getName());
        bean.setQuantity(inputQuantity.getText());
        bean.setQuantityUnit(product.getQuantityUnit());
        bean.setAnnotation(inputAdditionalRequests.getText());
        bean.validate();
        return new OrderLine(
                product,
                (new QuantityMapper()).toEntity(bean.getQuantity()),
                bean.getAnnotation());
    }

    //OUTPUT METHODS
    private Parent load() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/views2/form/buyer/placeOrderElements/ProductListItem.fxml"));
            loader.setController(this);
            return loader.load();
        } catch (IOException e) {
            throw new FailedFXMLLoadException();
        }
    }

    protected void setupTexts() {
        ProductBean productBean = (new ProductMapper()).toBean(product);
        textProductName.setText(productBean.getName());
        textProductDescription.setText(productBean.getDescription());
        textProductPrice.setText("€" + productBean.getPrice() + "/" + toString(productBean.getQuantityUnit()));
    }
    private String toString(QuantityUnit unit) {
        return I18n.t(
                switch (unit) {
            case LITER -> "LITER";
            case MILLILITER -> "MILLILITER";
            case KILOGRAM -> "KILOGRAM";
            case HECTOGRAM -> "HECTOGRAM";
            case GRAM -> "GRAM";
            case PIECE -> "PIECE";
            case PACK -> "PACK";
        });
    }

    public Parent getRoot() {
        return root;
    }
}
