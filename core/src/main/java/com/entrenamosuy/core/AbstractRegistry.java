package com.entrenamosuy.core;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Clase;
import com.entrenamosuy.core.model.Cuponera;
import com.entrenamosuy.core.model.Institucion;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.model.Socio;

import java.util.Map;

public interface AbstractRegistry {

     Map<String, Actividad> getActividades();

     Map<String, Clase> getClases();

     Map<String, Cuponera> getCuponeras();

     Map<String, Institucion> getInstituciones();

     Map<String, Profesor> getProfesores();

     Map<Email, Profesor> getProfesoresMail();

     Map<String, Socio> getSocios();

     Map<Email, Socio> getSociosMail();
}
