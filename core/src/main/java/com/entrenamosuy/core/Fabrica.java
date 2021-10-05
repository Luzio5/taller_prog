package com.entrenamosuy.core;

import com.entrenamosuy.core.util.FacadeContainer;

public class Fabrica {

    public FacadeContainer createFacades() {
        FacadeContainer ret = new FacadeContainer();

        AbstractRegistry registry = new Registry();
        AbstractFacadeActividad facadeActividad = new FacadeActividad();
        AbstractFacadeClase facadeClase = new FacadeClase();
        AbstractFacadeCuponera facadeCuponera = new FacadeCuponera();
        AbstractFacadeInstitucion facadeInstitucion = new FacadeInstitucion();
        AbstractFacadeUsuario facadeUsuario = new FacadeUsuario();

        facadeActividad.setRegistry(registry);
        facadeClase.setRegistry(registry);
        facadeCuponera.setRegistry(registry);
        facadeInstitucion.setRegistry(registry);
        facadeUsuario.setRegistry(registry);

        ret.setRegistry(registry);
        ret.setFacadeActividad(facadeActividad);
        ret.setFacadeClase(facadeClase);
        ret.setFacadeCuponera(facadeCuponera);
        ret.setFacadeInstitucion(facadeInstitucion);
        ret.setFacadeUsuario(facadeUsuario);

        return ret;
    }
}
