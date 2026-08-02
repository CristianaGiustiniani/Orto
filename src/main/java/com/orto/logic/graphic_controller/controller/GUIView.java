package com.orto.logic.graphic_controller.controller;

import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public abstract class GUIView {
    /*I controller grafici fanno quattro cose:
        - metodi per gestire azioni dell'utente
        - metodi per leggere input
        - metodi per mostrare output ----> showError, composizione della view o delego a ViewFactory
        - metodi per convertire bean in model e viceversa ---> lo delego a Mapper
     */
    protected Parent root;
    protected final String fxmlPath;

    protected GUIView (String fxmlPath) {
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
        if (Session.getInstance().isLogged()) {
            return ((GUIView)(ViewFactory.getInstance().createAuthenticatedBackground())).getRoot();
        } else {
            return ((GUIView)(ViewFactory.getInstance().createPublicBackground())).getRoot();
        }
    }

    protected abstract void setupTexts();

    public Parent getRoot() {
        return root;
    }
}
