package com.orto.logic.graphic_controller.graphic_elements;

import com.orto.logic.controller.bean.OrderLineBean;
import com.orto.logic.controller.bean.ProductBean;
import com.orto.logic.controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.controller.bean.exceptions.NotPositiveQuantityException;
import com.orto.logic.controller.bean.exceptions.NullQuantityException;
import com.orto.logic.controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.graphic_controller.exceptions.FailedFXMLLoadException;
import com.orto.logic.utils.I18n;
import com.orto.logic.utils.QuantityUnit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public abstract class ProductListItemGC extends HBox {
    //ATTRIBUTES
    protected final ProductBean product;

    //FXML ATTRIBUTES
    private final Parent root;
    @FXML TextField inputQuantity;
    @FXML TextField inputAdditionalRequests;
    @FXML Text textProductName;
    @FXML Text textProductDescription;
    @FXML Text textProductPrice;

    //CONSTRUCTOR
    protected ProductListItemGC(ProductBean product, String fxmlPath) {
        this.product = product;
        root = load(fxmlPath);
        setupTexts();
    }

    //INPUT METHODS
    public OrderLineBean getOrderLine() throws AnnotationTooLongException, NullQuantityException, NotPositiveQuantityException, WrongFormatQuantityException {
        OrderLineBean bean = new OrderLineBean();
        bean.setProductId(product.getId());
        bean.setProductName(product.getName());
        bean.setPrice(product.getPrice());
        bean.setQuantity(inputQuantity.getText());
        bean.setQuantityUnit(product.getQuantityUnit());
        bean.setAnnotation(inputAdditionalRequests.getText());
        bean.validate();
        return bean;
    }

    //OUTPUT METHODS
    private Parent load(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(this);
            return loader.load();
        } catch (IOException e) {
            throw new FailedFXMLLoadException();
        }
    }

    protected void setupTexts() {
        textProductName.setText(product.getName());
        textProductDescription.setText(product.getDescription());
        textProductPrice.setText("€" + product.getPrice() + "/" + toString(product.getQuantityUnit()));
    }
    protected String toString(QuantityUnit unit) {
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
