package com.orto.logic.graphic_controller;

import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.SessionManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public abstract class GUIGC {
    protected Parent root;
    protected final String fxmlPath;

    protected GUIGC(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    public void show() {
        Configuration.getInstance().getStage().show();
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

    protected Parent loadBackground() {
        if (SessionManager.getInstance().isLogged()) {
            return ((GUIGC)(GCFactoryProvider.getInstance().createAuthenticatedBackground())).getRoot();
        } else {
            return ((GUIGC)(GCFactoryProvider.getInstance().createPublicBackground())).getRoot();
        }
    }

    protected abstract void setupTexts();

    public Parent getRoot() {
        return root;
    }
}
