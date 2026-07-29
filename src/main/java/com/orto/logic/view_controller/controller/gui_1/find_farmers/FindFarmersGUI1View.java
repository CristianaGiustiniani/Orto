package com.orto.logic.view_controller.controller.gui_1.find_farmers;


import com.orto.logic.view_controller.controller.FindFarmersView;
import com.orto.logic.view_controller.controller.GUIView;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class FindFarmersGUI1View extends GUIView implements FindFarmersView {
    //JAVAFX GRAPHIC ELEMENTS
    @FXML ScrollPane scrollPaneFarmersTable;
    @FXML VBox vBoxFarmers;

    public FindFarmersGUI1View() {
        super("views/views1/form/FindFarmers.fxml");
    }

    @Override
    protected Parent create() {
        return null;
    }

    @Override
    protected boolean hasHeader() {
        return false;
    }

    //IMPLEMENTED METHODS
    @Override
    protected void setupTexts() {

    }

    @Override
    protected void showError() {

    }
}
