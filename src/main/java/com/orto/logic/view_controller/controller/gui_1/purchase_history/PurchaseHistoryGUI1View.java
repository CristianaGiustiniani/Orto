package com.orto.logic.view_controller.controller.gui_1.purchase_history;

import com.orto.logic.view_controller.controller.GUIView;
import com.orto.logic.view_controller.controller.PurchaseHistoryView;
import javafx.scene.Parent;

public class PurchaseHistoryGUI1View extends GUIView implements PurchaseHistoryView {
    public PurchaseHistoryGUI1View() {
        super("views/views1/form/buyer/PurchaseHistory.fxml");
    }

    @Override
    protected Parent create() {
        return null;
    }

    @Override
    protected boolean hasHeader() {
        return false;
    }

    @Override
    protected void setupTexts() {

    }

    @Override
    protected void showError() {

    }
}
