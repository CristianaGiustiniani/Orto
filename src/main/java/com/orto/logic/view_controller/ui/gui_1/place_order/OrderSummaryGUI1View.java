package com.orto.logic.view_controller.ui.gui_1.place_order;

import com.orto.logic.controller.OrderSummaryController;
import com.orto.logic.view_controller.ui.GUIView;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class OrderSummaryGUI1View extends GUIView {
    //CONTROLLER
    OrderSummaryController controller = new OrderSummaryController();

    //JAVAFX GRAPHIC ELEMENTS
    @FXML private VBox vBoxContent;
    @FXML private Text textOrderConfirmation;

    @Override
    protected void setupTexts() {

    }

    @Override
    protected void showError() {

    }

    @Override
    public boolean isBackgrounded() {
        return false;
    }

    //BEANS

    //CONSTRUCTOR

    //JAVAFX ACTIONS-EVENTS

}
