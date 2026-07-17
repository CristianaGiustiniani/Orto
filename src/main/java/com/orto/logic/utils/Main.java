package com.orto.logic.utils;

import com.orto.logic.utils.exceptions.ConfigurationException;
import javafx.application.Application;
import javafx.stage.Stage;

import static com.orto.logic.utils.ViewType.HOME;

public class Main extends Application {
    public static void main(String[] args) {
        try {
            Configuration.init(args);
        } catch (ConfigurationException e) {
            System.err.println(e.getMessage());
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Navigator navigator;

        switch(Configuration.getInstance().getUIType()) {
            case GUI_1:
                navigator = GUINavigator.getInstance(stage);
                navigator.goTo(HOME);      //TODO: voglio che vada alla home
                break;
            case GUI_2:
                navigator = GUINavigator.getInstance(stage);
                navigator.goTo(HOME);      //TODO: voglio che vada alla home
                break;
            default:
                navigator = GUINavigator.getInstance(stage);
                navigator.goTo(HOME);      //TODO: voglio che vada alla home
                break;

        }

    }
}