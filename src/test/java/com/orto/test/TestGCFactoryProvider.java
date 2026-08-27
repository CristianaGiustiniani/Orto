package com.orto.test;

import com.orto.logic.graphic_controller.GCFactory;
import com.orto.logic.graphic_controller.GCFactoryProvider;
import com.orto.logic.graphic_controller.gui_1.GUI1GCFactory;
import com.orto.logic.graphic_controller.gui_2.GUI2GCFactory;
import com.orto.logic.utils.UIType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestGCFactoryProvider {
    @Test
    void testCreateFactoryUsesGui1Implementation() {
        GCFactory factory = GCFactoryProvider.createFactory(UIType.GUI_1);
        assertInstanceOf(GUI1GCFactory.class, factory);
    }

    @Test
    void testCreateFactoryUsesGui2Implementation() {
        GCFactory factory = GCFactoryProvider.createFactory(UIType.GUI_2);
        assertInstanceOf(GUI2GCFactory.class, factory);
    }
}
