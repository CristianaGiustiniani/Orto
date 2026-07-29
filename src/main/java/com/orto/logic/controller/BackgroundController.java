package com.orto.logic.controller;

import com.orto.logic.utils.Session;
import com.orto.logic.view_controller.controller.ViewFactory;

public class BackgroundController extends Controller {
    public BackgroundController(ViewFactory factory) {
        super(controllerFactory);
    }

    public void logOut() {
        Session.getInstance().logout();
    }

}
