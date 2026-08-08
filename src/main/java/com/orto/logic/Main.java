package com.orto.logic;

import com.orto.logic.controller.LoginController;
import com.orto.logic.graphic_controller.controller.GCFactory;
import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.exceptions.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class Main extends Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        try {
            Configuration.init(args);
        } catch (ConfigurationException e) {
            logger.info(e.getMessage());
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Configuration.getInstance().setStage(stage);
        (new LoginController()).tryAutologin();
        GCFactory.getInstance().createHome();
    }
}