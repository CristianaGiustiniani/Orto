package com.orto.logic.utils;

import com.orto.logic.utils.exceptions.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;

import static com.orto.logic.utils.Mode.*;
import static com.orto.logic.utils.UIType.*;

public class Configuration {
    /*
    * Singleton
    * */
    private static Configuration instance = null;
    private final Mode mode;
    private final UIType uiType;
    private Locale locale;
    private Stage stage;

    private Configuration(Mode mode, UIType uiType) {
        this.mode = mode;
        this.uiType = uiType;
        this.locale = Locale.ENGLISH;
    }

    public static Configuration getInstance() {
        return instance;
    }

    public static void init(String[] args) throws AlreadyInstantiatedException, NullModeException, InvalidModeException, NullUITypeException, InvalidUITypeException {
        if (instance != null) {
            throw new AlreadyInstantiatedException();
        }

        Mode mode;
        UIType uiType;

        mode = switch (args[0]) {
            case "DEMO" -> DEMO;
            case "FULL" -> FULL;
            case null -> throw new NullModeException();
            default -> throw new InvalidModeException();
        };

        uiType = switch (args[1]) {
            case "GUI1" -> GUI_1;
            case "GUI2" -> GUI_2;
            case null -> throw new NullUITypeException();
            default -> throw new InvalidUITypeException();
        };

        instance = new Configuration(mode, uiType);
        I18n.init(instance.locale);
    }

    public Mode getMode() {
        return this.mode;
    }

    public UIType getUIType() {
        return this.uiType;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
