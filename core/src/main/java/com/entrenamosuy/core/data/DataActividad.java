package com.entrenamosuy.core.data;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class DataActividad {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;

        private String descripcion;

        private Duration duracion;

        private LocalDate registro;

        private float costo;

        private Set<DataClase> clases = Collections.emptySet();

        private Set<DataCuponera> cuponeras = Collections.emptySet();

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder setDuracion(Duration duracion) {
            this.duracion = duracion;
            return this;
        }

        public Builder setRegistro(LocalDate registro) {
            this.registro = registro;
            return this;
        }

        public Builder setCosto(float costo) {
            this.costo = costo;
            return this;
        }

        public Builder setClases(Set<DataClase> clases) {
            this.clases = clases;
            return this;
        }

        public Builder setCuponeras(Set<DataCuponera> cuponeras) {
            this.cuponeras = cuponeras;
            return this;
        }

        public DataActividad build() {
            return new DataActividad(nombre, descripcion, duracion, registro, costo,
                    clases, cuponeras);
        }
    }

    private final String nombre;

    private final String descripcion;

    private final Duration duracion;

    private final LocalDate registro;

    private final float costo;

    private final Set<DataClase> clases;

    private final Set<DataCuponera> cuponeras;

    protected DataActividad(String nombre, String descripcion, Duration duracion,
            LocalDate registro, float costo, Set<DataClase> clases,
            Set<DataCuponera> cuponeras) {

        Objects.requireNonNull(nombre, "nombre es null en constructor DataActividad");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor DataActividad");
        Objects.requireNonNull(duracion, "duracion es null en constructor DataActividad");
        Objects.requireNonNull(registro, "registro es null en constructor DataActividad");
        Objects.requireNonNull(clases, "clases es null en constructor DataActividad");
        Objects.requireNonNull(cuponeras, "cuponeras es null en constructor DataActividad");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.registro = registro;
        this.costo = costo;
        this.clases = clases;
        this.cuponeras = cuponeras;
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

    public Set<DataClase> getClases() {
        return clases;
    }

    public Set<DataCuponera> getCuponeras() {
        return cuponeras;
    }

    @Override
    public int hashCode() {
        return Objects.hash(costo, descripcion, duracion, nombre, registro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataActividad other = (DataActividad) obj;
        return Objects.equals(clases, other.clases)
                && Objects.equals(cuponeras, other.cuponeras)
                && Float.floatToIntBits(costo) == Float.floatToIntBits(other.costo)
                && Objects.equals(descripcion, other.descripcion)
                && Objects.equals(duracion, other.duracion)
                && Objects.equals(nombre, other.nombre)
                && Objects.equals(registro, other.registro);
    }
}
