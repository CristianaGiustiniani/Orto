package com.orto.logic.graphic_controller.gui_2.place_order;

import com.orto.logic.controller.bean.OrderLineBean;
import com.orto.logic.controller.bean.ProductBean;
import com.orto.logic.controller.bean.exceptions.AnnotationTooLongException;
import com.orto.logic.controller.bean.exceptions.NotPositiveQuantityException;
import com.orto.logic.controller.bean.exceptions.NullQuantityException;
import com.orto.logic.controller.bean.exceptions.WrongFormatQuantityException;
import com.orto.logic.graphic_controller.GUIGC;
import com.orto.logic.model.entity.exceptions.NoProductSelectedException;
import com.orto.logic.utils.I18n;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ProductSelectionGUI2GC extends GUIGC {
    //ATTRIBUTES
    List <ProductListItemGUI2GC> orderLinesGC = new ArrayList<>();

    //FXML ATTRIBUTES
    @FXML private VBox vboxProducts;

    //CONSTRUCTOR
    public ProductSelectionGUI2GC(List<ProductBean> products) {
        super("/views/views2/form/buyer/placeOrderElements/ProductSelection.fxml");
        root = load();
        createChildren(products);
        setupTexts();
    }

    //INPUT METHODS
    public List<OrderLineBean> getLines() throws NotPositiveQuantityException, AnnotationTooLongException, WrongFormatQuantityException {
        List<OrderLineBean> lines = new ArrayList<>();
        for (ProductListItemGUI2GC lineGC : orderLinesGC) {
                try {
                    lines.add(lineGC.getOrderLine());
                } catch (NullQuantityException e) {
                    //if quantity is null, product is not selected and not added to order lines
                }
        }
        return lines;
    }

    //OUTPUT METHODS
    private void createChildren(List<ProductBean> products) {
        //for each product, create row
        for (ProductBean product : products) {
            orderLinesGC.add(new ProductListItemGUI2GC(product));
            vboxProducts.getChildren().add(orderLinesGC.getLast().getRoot());
        }
    }


    @Override
    protected void setupTexts() {
        //nothing to set up
    }

    public void showError(Exception e) {
        String message = switch (e) {
            case NoProductSelectedException ignored ->
                    I18n.t("ERROR_PLACEORDER_PRODUCTSELECTION_EMPTYSELECTION");
            case NotPositiveQuantityException ignored ->
                    I18n.t("ERROR_PLACEORDER_PRODUCTSELECTION_NOTPOSITIVEQUANTITY");
            case AnnotationTooLongException ignored ->
                    I18n.t("ERROR_PLACEORDER_PRODUCTSELECTION_ANNOTATIONTOOLONG");
            case WrongFormatQuantityException ignored ->
                    I18n.t("ERROR_PLACEORDER_PRODUCTSELECTION_WRONGFORMATQUANTITY");
            default -> e.getMessage();
        };

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
