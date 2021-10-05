package com.entrenamosuy.core.util;

import com.entrenamosuy.core.AbstractRegistry;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.AbstractFacadeClase;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeInstitucion;
import com.entrenamosuy.core.AbstractFacadeUsuario;

public class FacadeContainer {

    private AbstractFacadeActividad facadeActividad;

    private AbstractFacadeClase facadeClase;

    private AbstractFacadeCuponera facadeCuponera;

    private AbstractFacadeInstitucion facadeInstitucion;

    private AbstractFacadeUsuario facadeUsuario;

    private AbstractRegistry registry;

    public AbstractFacadeActividad getFacadeActividad() {
        return facadeActividad;
    }

    public void setFacadeActividad(AbstractFacadeActividad facadeActividad) {
        this.facadeActividad = facadeActividad;
    }

    public AbstractFacadeClase getFacadeClase() {
        return facadeClase;
    }

    public void setFacadeClase(AbstractFacadeClase facadeClase) {
        this.facadeClase = facadeClase;
    }

    public AbstractFacadeCuponera getFacadeCuponera() {
        return facadeCuponera;
    }

    public void setFacadeCuponera(AbstractFacadeCuponera facadeCuponera) {
        this.facadeCuponera = facadeCuponera;
    }

    public AbstractFacadeInstitucion getFacadeInstitucion() {
        return facadeInstitucion;
    }

    public void setFacadeInstitucion(AbstractFacadeInstitucion facadeInstitucion) {
        this.facadeInstitucion = facadeInstitucion;
    }

    public AbstractFacadeUsuario getFacadeUsuario() {
        return facadeUsuario;
    }

    public void setFacadeUsuario(AbstractFacadeUsuario facadeUsuario) {
        this.facadeUsuario = facadeUsuario;
    }

    public AbstractRegistry getRegistry() {
        return registry;
    }

    public void setRegistry(AbstractRegistry registry) {
        this.registry = registry;
    }
}
