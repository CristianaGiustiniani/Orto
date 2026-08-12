package com.orto.test;

import com.orto.logic.graphic_controller.controller.GCFactory;
import com.orto.logic.graphic_controller.controller.GCFactoryProvider;
import com.orto.logic.graphic_controller.controller.gui_1.GUI1GCFactory;
import com.orto.logic.graphic_controller.controller.gui_2.GUI2GCFactory;
import com.orto.logic.utils.UIType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGCFactoryProvider {
    @Test
    public void testCreateFactoryUsesGui1Implementation() {
        GCFactory factory = GCFactoryProvider.createFactory(UIType.GUI_1);
        assertInstanceOf(GUI1GCFactory.class, factory);
    }

    @Test
    public void testCreateFactoryUsesGui2Implementation() {
        GCFactory factory = GCFactoryProvider.createFactory(UIType.GUI_2);
        assertInstanceOf(GUI2GCFactory.class, factory);
    }
}
