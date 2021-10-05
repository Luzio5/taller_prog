package com.entrenamosuy.core.data;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

public class DescActividad {

    private final String nombre;

    private final String descripcion;

    private final Duration duracion;

    private final LocalDate registro;

    private final float costo;

    public DescActividad(String nombre, String descripcion, Duration duracion, LocalDate registro, float costo) {
        Objects.requireNonNull(nombre, "nombre es null en constructor DescActividad");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor DescActividad");
        Objects.requireNonNull(duracion, "duracion es null en constructor DescActividad");
        Objects.requireNonNull(registro, "registro es null en constructor DescActividad");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.registro = registro;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public LocalDate getRegistro() {
        return registro;
    }

    public float getCosto() {
        return costo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, duracion, registro, costo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DescActividad other = (DescActividad) obj;
        return Objects.equals(nombre, other.nombre)
                && Objects.equals(descripcion, other.descripcion)
                && Objects.equals(duracion, other.duracion)
                && Objects.equals(registro, other.registro)
                && Float.floatToIntBits(costo) == Float.floatToIntBits(other.costo);
    }
}
