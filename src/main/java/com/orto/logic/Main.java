package com.orto.logic;

import com.orto.logic.controller.HomeController;
import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.exceptions.ConfigurationException;
import javafx.application.Application;
import javafx.stage.Stage;


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
        Configuration.getInstance().setStage(stage);
        (new HomeController()).start();
    }
}