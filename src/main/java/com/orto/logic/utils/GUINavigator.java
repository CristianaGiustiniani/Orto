package com.orto.logic.utils;

import com.orto.logic.view_controller.ui.gui_1.GUI1ViewFactory;
import com.orto.logic.view_controller.ui.gui_2.GUI2ViewFactory;
import javafx.stage.Stage;

public class GUINavigator extends Navigator {
    private static GUINavigator instance;
    private Stage stage;

    private GUINavigator() {
        switch (Configuration.getInstance().getUIType()) {
            case GUI_1 -> factory = new GUI1ViewFactory();
            case GUI_2 -> factory = new GUI2ViewFactory();
        }
    }
    public static GUINavigator getInstance() {
        if (instance == null) {
            instance = new GUINavigator();
        }
        return instance;
    }
    public static GUINavigator getInstance(Stage stage) {
        if (instance == null) {
            instance = new GUINavigator();
        }
        instance.setStage(stage);

        return instance;
    }

    public void setStage(Stage stage) {     //Da spostare poi solo nel GUINavigator
        this.stage = stage;
    }
    public Stage getStage() {
        return stage;
    }
}
