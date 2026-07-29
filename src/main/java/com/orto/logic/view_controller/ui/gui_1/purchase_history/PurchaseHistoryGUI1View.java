package com.orto.logic.view_controller.ui.gui_1.purchase_history;

import com.orto.logic.view_controller.ui.GUIView;
import com.orto.logic.view_controller.ui.PurchaseHistoryView;
import javafx.scene.Parent;

public class PurchaseHistoryGUI1View extends GUIView implements PurchaseHistoryView {
    protected PurchaseHistoryGUI1View(String fxmlPath) {
        super(fxmlPath);
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
