package com.orto.logic.graphic_controller;

import com.orto.logic.graphic_controller.gui_1.GUI1GCFactory;
import com.orto.logic.graphic_controller.gui_2.GUI2GCFactory;
import com.orto.logic.utils.Configuration;
import com.orto.logic.utils.UIType;

public final class GCFactoryProvider {
    private static GCFactory instance = null;

    private GCFactoryProvider() {
    }

    public static synchronized GCFactory getInstance() {
        if (instance == null) {
            instance = createFactory(Configuration.getInstance().getUIType());
        }
        return instance;
    }

    public static GCFactory createFactory(UIType uiType) {
        return switch (uiType) {
            case GUI_1 -> new GUI1GCFactory();
            case GUI_2 -> new GUI2GCFactory();
        };
    }
}
