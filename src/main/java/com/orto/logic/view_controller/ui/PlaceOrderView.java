package com.orto.logic.view_controller.ui;

public interface PlaceOrderView extends View {
    @Override
    default boolean isBackgrounded(){
        return true;
    }
}
