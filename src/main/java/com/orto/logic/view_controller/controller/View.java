package com.orto.logic.view_controller.controller;

import com.orto.logic.controller.Controller;
import com.orto.logic.view_controller.bean.Bean;

public abstract class View {
    /*I controller grafici fanno quattro cose:
        - metodi per gestire azioni dell'utente
        - metodi per leggere input
        - metodi per mostrare output
        - metodi per convertire bean in model e viceversa ---> lo delego a Mapper
     */
    protected abstract Bean getInput();

    public abstract void show();


}
