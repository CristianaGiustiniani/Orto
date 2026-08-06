package com.orto.logic.graphic_controller.controller.gui_1.place_order;

import com.orto.logic.graphic_controller.bean.OrderLineBean;
import com.orto.logic.graphic_controller.bean.ProductBean;
import com.orto.logic.graphic_controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.graphic_controller.bean.exceptions.NotPositiveQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.NullQuantityException;
import com.orto.logic.graphic_controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.graphic_controller.controller.mapper.ProductMapper;
import com.orto.logic.graphic_controller.controller.mapper.QuantityMapper;
import com.orto.logic.model.entity.OrderLine;
import com.orto.logic.model.entity.Product;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class ProductListItemGUI1GC extends HBox {
    //ATTRIBUTES
    private final Product product;

    //FXML ATTRIBUTES
    private final Parent root;
    public final String fxmlPath = "/views/views1/form/findFarmersElements/FarmerListItem.fxml";
    @FXML TextField inputQuantity;
    @FXML TextField inputAdditionalRequests;
    @FXML Text textProductName;
    @FXML Text textProductDescription;
    @FXML Text textProductPrice;

    //CONSTRUCTOR
    public  ProductListItemGUI1GC(Product product) {
        this.product = product;
        root = load();
        setupTexts();
    }

    //INPUT METHODS
    public OrderLine getOrderLine() throws AnnotationTooLongException, NullQuantityException, NotPositiveQuantityException, WrongFormatQuantityException {
        OrderLineBean bean = new OrderLineBean();
        bean.setQuantity(inputQuantity.getText());
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(this);
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML: " + fxmlPath, e);
        }
    }

    protected void setupTexts() {
        ProductBean productBean = (new ProductMapper()).toBean(product);
        textProductName.setText(productBean.getName());
        textProductDescription.setText(productBean.getDescription());
        textProductPrice.setText("€" + productBean.getPrice() + "/" + I18n.t(productBean.getQuantityUnit().name()));
    }

    public Parent getRoot() {
        return root;
    }
}
