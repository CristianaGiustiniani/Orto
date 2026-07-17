package com.orto.logic.view_controller.ui;

import com.orto.logic.utils.GUINavigator;
import com.orto.logic.utils.Session;
import com.orto.logic.view_controller.ui.backgrounds.AuthenticatedBackgroundView;
import com.orto.logic.view_controller.ui.backgrounds.BackgroundView;
import com.orto.logic.view_controller.ui.backgrounds.PublicBackgroundView;
import com.orto.logic.view_controller.ui.gui_1.background.BackgroundGUI1View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class GUIView implements View {
    protected final String fxmlPath;
    protected GUIView view;


    protected GUIView (String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    @Override
    public void show() {
        Stage stage = GUINavigator.getInstance().getStage();
        stage.setScene(new Scene(this.load()));
        stage.show();
    }

    protected Parent load() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            loader.setController(this);

            if (this.isBackgrounded()) {
                return wrapWithBackground(load());
            } else {
                return loader.load();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load FXML: " + fxmlPath, e);
        }
    }

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

    protected abstract void setupTexts();

    protected abstract void showError();
}
