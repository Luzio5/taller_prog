package com.entrenamosuy.core.model;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DescActividad;

public class Cuponera {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;

        private String descripcion;

        private LocalDate inicio, fin, fechaRegistro;

        private int descuento;

        private Set<Integra> integras = new HashSet<>();

        private Set<Registro> registros = new HashSet<>();

        private ByteBuffer imagen;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder setInicio(LocalDate inicio) {
            this.inicio = inicio;
            return this;
        }

        public Builder setFin(LocalDate fin) {
            this.fin = fin;
            return this;
        }

        public Builder setFechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public Builder setDescuento(int descuento) {
            this.descuento = descuento;
            return this;
        }

        public Builder setIntegras(Set<Integra> integras) {
            this.integras = integras;
            return this;
        }

        public Builder setRegistros(Set<Registro> registros) {
            this.registros = registros;
            return this;
        }

        public Builder setImagen(ByteBuffer imagen) {
            this.imagen = imagen;
            return this;
        }

        public Cuponera build() {
            return new Cuponera(nombre, descripcion, inicio, fin, descuento, fechaRegistro, integras, registros, imagen);
        }
    }

    private String nombre;

    private String descripcion;

    private LocalDate inicio, fin, fechaRegistro;

    private int descuento;

    private Set<Integra> integras;

    private Set<Registro> registros;

    private ByteBuffer imagen;

    protected Cuponera(String nombre, String descripcion, LocalDate inicio, LocalDate fin, int descuento,
                    LocalDate fechaRegistro, Set<Integra> integras, Set<Registro> registros, ByteBuffer imagen) {

        Objects.requireNonNull(nombre, "nombre es null en constructor Cuponera");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor Cuponera");
        Objects.requireNonNull(inicio, "inicio es null en constructor Cuponera");
        Objects.requireNonNull(fin, "fin es null en constructor Cuponera");
        Objects.requireNonNull(fechaRegistro, "fechaRegistro es null en constructor Cuponera");
        Objects.requireNonNull(integras, "integras es null en constructor Cuponera");
        Objects.requireNonNull(registros, "registros es null en constructor Cuponera");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.descuento = descuento;
        this.integras = integras;
        this.registros = registros;
        this.fechaRegistro = fechaRegistro;
        this.imagen = imagen;
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

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public void setFin(LocalDate fin) {
        this.fin = fin;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public Set<Integra> getIntegras() {
        return integras;
    }

    public void setIntegras(Set<Integra> integras) {
        this.integras = integras;
    }

    public Set<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Set<Registro> registros) {
        this.registros = registros;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
	    this.fechaRegistro = fechaRegistro;
    }

    public ByteBuffer getImagen() {
        return imagen;
    }

    public void setImagen(ByteBuffer imagen) {
        this.imagen = imagen;
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
        Cuponera other = (Cuponera) obj;
        return Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cuponera = [nombre=")
            .append(nombre)
            .append(", registro=")
            .append(fechaRegistro)
            .append(", inicio=")
            .append(inicio)
            .append(", fin=")
            .append(fin)
            .append(", actividades=[");

        if (!integras.isEmpty()) {
            Iterator<Integra> it = integras.iterator();

            builder.append(it.next().getActividad().getNombre());

            while (it.hasNext())
                builder.append(", ").append(it.next().getActividad().getNombre());
        }

        builder.append("]]");
        return builder.toString();
    }

    public DataCuponera getDataCuponera() {
        Set<DescActividad> acts = new HashSet<>(integras.size());

        for (Integra i : integras) {
            Actividad actividad = i.getActividad();
            acts.add(actividad.getDescActividad());
        }

        return new DataCuponera(this.nombre, this.descripcion, acts);
    }

    public Integra getIntegra(Actividad a) {
        for (Integra integra : integras)
            if (integra.getActividad().equals(a))
                return integra;

        return null;
    }

    public boolean tieneActividad(Actividad act) {
        boolean ret = false;

        for (Integra i : integras) {
            if (act.equals(i.getActividad())) {
                ret = true;
                break;
            }
        }

        return ret;
    }
}
