package com.orto.logic.controller;

import com.orto.logic.view_controller.controller.ViewFactory;

public class HomeController extends Controller {
   @Override
    public void start() {
       ViewFactory.getInstance().createHome().show();
    }
}
