package com.entrenamosuy.core.model;

import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DescActividad;

public class Actividad {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;

        private String descripcion;

        private Duration duracion;

        private LocalDate fechaRegistro;

        private float costo;

        private ActividadEstado estado = ActividadEstado.INGRESADA;

        private ByteBuffer imagen;

        private Set<Clase> clases = new HashSet<>();

        private Set<Categoria> categorias = new HashSet<>();

        private Set<Integra> integras = new HashSet<>();

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

        public Builder setFechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public Builder setCosto(float costo) {
            this.costo = costo;
            return this;
        }

        public Builder setClases(Set<Clase> clases) {
            this.clases = clases;
            return this;
        }

        public Builder setCategorias(Set<Categoria> categorias) {
            this.categorias = categorias;
            return this;
        }

        public Builder setImagen(ByteBuffer imagen) {
            this.imagen = imagen;
            return this;
        }

        public Builder setEstado(ActividadEstado estado) {
            this.estado = estado;
            return this;
        }

        public Builder setIntegras(Set<Integra> integras) {
            this.integras = integras;
            return this;
        }

        public Actividad build() {
            return new Actividad(nombre, descripcion, duracion, fechaRegistro, costo,
                    clases, categorias, imagen, estado, integras);
        }
    }

    private String nombre;

    private String descripcion;

    private Duration duracion;

    private LocalDate fechaRegistro;

    private float costo;

    private ActividadEstado estado;

    private ByteBuffer imagen;

    private Set<Clase> clases;

    private Set<Categoria> categorias;

    private Set<Integra> integras;

    protected Actividad(String nombre, String descripcion, Duration duracion, LocalDate fechaRegistro,
                     float costo, Set<Clase> clases, Set<Categoria> categorias, ByteBuffer imagen,
                     ActividadEstado estado, Set<Integra> integras) {

        Objects.requireNonNull(nombre, "nombre es null en constructor Actividad");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor Actividad");
        Objects.requireNonNull(duracion, "duracion es null en constructor Actividad");
        Objects.requireNonNull(fechaRegistro, "fechaRegistro es null en constructor Actividad");
        Objects.requireNonNull(clases, "clases es null en constructor Actividad");
        Objects.requireNonNull(categorias, "categorias es null en constructor Actividad");
        Objects.requireNonNull(estado, "estado es null en constructor Actividad");
        Objects.requireNonNull(integras, "integras es null en constructor Actividad");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaRegistro = fechaRegistro;
        this.costo = costo;
        this.clases = clases;
        this.categorias = categorias;
        this.imagen = imagen;
        this.estado = estado;
        this.integras = integras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void setDuracion(Duration duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Set<Clase> getClases() {
        return clases;
    }

    public void setClases(Set<Clase> clases) {
        this.clases = clases;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ByteBuffer getImagen() {
        return imagen;
    }

    public void setImagen(ByteBuffer imagen) {
        this.imagen = imagen;
    }

    public ActividadEstado getEstado() {
        return estado;
    }

    public void setEstado(ActividadEstado estado) {
        this.estado = estado;
    }

    public Set<Integra> getIntegras() {
        return integras;
    }

    public void setIntegras(Set<Integra> integras) {
        this.integras = integras;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Actividad other = (Actividad) obj;
        return Objects.equals(nombre, other.getNombre());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Actividad = [nombre=")
            .append(nombre)
            .append(", clases=[");

        if (!clases.isEmpty()) {
            Iterator<Clase> it = clases.iterator();

            builder.append(it.next().getNombre());

            while (it.hasNext())
                builder.append(", ").append(it.next().getNombre());
        }

        builder.append("]]");
        return builder.toString();
    }

    public DataActividad getDataActividad() {
        Set<DataCuponera> cuponeras = new HashSet<>();

        for (Integra i : integras) {
            Cuponera cupo = i.getCuponera();
            Set<Integra> integs = cupo.getIntegras();

            for (Integra integ : integs) {
                Actividad act = integ.getActividad();
                if (act.getNombre().equals(this.nombre)) {
                    DataCuponera cupoAagregar = cupo.getDataCuponera();
                    cuponeras.add(cupoAagregar);
                }
            }
        }

        Set<DataClase> dataClases = new HashSet<>();
        for (Clase c : this.clases)
            dataClases.add(c.getDataClase());

        return DataActividad.builder()
                .setNombre(nombre)
                .setDescripcion(descripcion)
                .setDuracion(duracion)
                .setRegistro(fechaRegistro)
                .setCosto(costo)
                .setClases(dataClases)
                .setCuponeras(cuponeras)
                .build();
    }

    public DescActividad getDescActividad() {
        return new DescActividad(this.nombre, this.descripcion, this.duracion, this.fechaRegistro, this.costo);
    }

    public float calcularPrecioConDescuento(Cuponera cup) {
        int desc = cup.getDescuento();
        return costo - (costo * desc);
    }
}
