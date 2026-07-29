package com.orto.logic.view_controller.controller;

import com.orto.logic.utils.Configuration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class GUIView extends View {
    private Parent root;
    protected final String fxmlPath;

    protected GUIView (String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    protected abstract Parent create();
    @Override
    public void show() {
        Parent parent = create();
        Stage stage = Configuration.getInstance().getStage();
        stage.setScene(new Scene(parent));
//        stage.setScene(new Scene(this.load()));
        stage.show();
    }

    protected Parent load() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(this);
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML: " + fxmlPath, e);
        }
    }

    protected Parent load(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(this);
            return loader.load();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML: " + fxmlPath, e);
        }
    }


    protected abstract boolean hasHeader();

   /*
    private Parent wrapWithBackground(Parent content) {
        BackgroundView backgroundView;

        if (Session.getInstance().isLogged()) {
            backgroundView = new AuthenticatedBackgroundView();
        } else {
            backgroundView = new PublicBackgroundView();
        }

        BackgroundGUI1View backgroundGUI1View = new BackgroundGUI1View();
        BorderPane background = (BorderPane) backgroundView.load();
        background.setCenter(content);

        return background;
    }
*/
    protected abstract void setupTexts();

    protected abstract void showError();
}
