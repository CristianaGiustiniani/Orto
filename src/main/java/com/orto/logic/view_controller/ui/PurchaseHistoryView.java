package com.orto.logic.view_controller.ui;

public interface PurchaseHistoryView extends View{
    @Override
    default boolean isBackgrounded(){
        return true;
    }
}
