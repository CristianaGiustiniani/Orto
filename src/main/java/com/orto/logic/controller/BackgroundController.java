package com.orto.logic.controller;

import com.orto.logic.utils.Session;

public class BackgroundController extends Controller {
    public void logOut() {
        Session.getInstance().logout();
    }

}
