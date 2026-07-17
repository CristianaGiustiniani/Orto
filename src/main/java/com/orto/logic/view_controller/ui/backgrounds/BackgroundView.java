package com.orto.logic.view_controller.ui.backgrounds;

import com.orto.logic.view_controller.ui.View;

public interface BackgroundView extends View {
    @Override
    default boolean isBackgrounded(){
        return false;
    }
}
