package com.entrenamosuy.web;

import com.entrenamosuy.core.Fabrica;
import com.entrenamosuy.core.util.FacadeContainer;

public class Facades {

    private static final Fabrica fabrica = new Fabrica();

    private static FacadeContainer facades;

    public static FacadeContainer getFacades() {
        if (facades == null)
            facades = fabrica.createFacades();

        return facades;
    }
}
