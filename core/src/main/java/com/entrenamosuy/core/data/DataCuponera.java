package com.entrenamosuy.core.data;

import java.util.Objects;
import java.util.Set;

public class DataCuponera {

    private final String nombre;

    private final String descripcion;

    private final Set<DescActividad> actividades;

    public DataCuponera(String nombre, String descripcion, Set<DescActividad> actividades) {
        Objects.requireNonNull(nombre, "nombre es null en constructor DataCuponera");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor DataCuponera");
        Objects.requireNonNull(actividades, "actividades es null en constructor DataCuponera");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.actividades = actividades;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Set<DescActividad> getActividades() {
        return actividades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataCuponera other = (DataCuponera) obj;
        return Objects.equals(nombre, other.nombre)
                && Objects.equals(descripcion, other.descripcion)
                && Objects.equals(actividades, other.actividades);
    }
}
