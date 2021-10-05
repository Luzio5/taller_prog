package com.entrenamosuy.core;

import java.util.HashMap;
import java.util.Map;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Clase;
import com.entrenamosuy.core.model.Cuponera;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.model.Socio;

import com.entrenamosuy.core.data.Email;

public class Registry implements AbstractRegistry {

    private Map<String, Actividad> actividades = new HashMap<>();

    private Map<String, Clase> clases = new HashMap<>();

    private Map<String, Cuponera> cuponeras = new HashMap<>();

    private Map<String, Institucion> instituciones = new HashMap<>();

    private Map<String, Profesor> profesores = new HashMap<>();

    private Map<Email, Profesor> profesoresMail = new HashMap<>();

    private Map<String, Socio> socios = new HashMap<>();

    private Map<Email, Socio> sociosMail = new HashMap<>();

    @Override
    public Map<String, Actividad> getActividades() {
        return actividades;
    }

    @Override
    public Map<String, Clase> getClases() {
        return clases;
    }

    @Override
    public Map<String, Cuponera> getCuponeras() {
        return cuponeras;
    }

    @Override
    public Map<String, Institucion> getInstituciones() {
        return instituciones;
    }

    @Override
    public Map<String, Profesor> getProfesores() {
        return profesores;
    }

    @Override
    public Map<Email, Profesor> getProfesoresMail() {
        return profesoresMail;
    }

    @Override
    public Map<String, Socio> getSocios() {
        return socios;
    }

    @Override
    public Map<Email, Socio> getSociosMail() {
        return sociosMail;
    }
}
