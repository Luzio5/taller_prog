package com.entrenamosuy.core.model;

import java.util.Objects;
import java.util.Set;

public class Categoria {

    private String nombre;

    private Set<Actividad> actividades;

    public Categoria(String nombre, Set<Actividad> actividades) {
        Objects.requireNonNull(nombre, "nombre es null en constructor Categoria");
        Objects.requireNonNull(actividades, "actividades es null en constructor Categoria");

        this.nombre = nombre;
        this.actividades = actividades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        return Objects.equals(nombre, other.nombre);
    }
}
