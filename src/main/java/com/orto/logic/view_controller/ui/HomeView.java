package com.orto.logic.view_controller.ui;

public interface HomeView extends View {
    @Override
    default boolean isBackgrounded(){
        return true;
    }
}
