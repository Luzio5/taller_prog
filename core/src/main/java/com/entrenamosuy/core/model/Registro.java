package com.entrenamosuy.core.model;

import java.time.LocalDate;
import java.util.Objects;

public class Registro {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private LocalDate fecha;

        private Clase claseAsociada;

        private Socio socio;

        private Cuponera cuponera;

        public Builder setClaseAsociada(Clase claseAsociada) {
            this.claseAsociada = claseAsociada;
            return this;
        }

        public Builder setFecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder setSocio(Socio socio) {
            this.socio = socio;
            return this;
        }

        public Builder setCuponera(Cuponera cuponera) {
            this.cuponera = cuponera;
            return this;
        }

        public Registro build() {
            return new Registro(fecha, claseAsociada, socio, cuponera);
        }
    }

    private LocalDate fecha;

    private Clase claseAsociada;

    private Socio socio;

    private Cuponera cuponera;

    protected Registro(LocalDate fecha, Clase claseAsociada, Socio socio, Cuponera cuponera) {
        Objects.requireNonNull(fecha, "fecha es null en constructor Registro");
        Objects.requireNonNull(claseAsociada, "claseAsociada es null en constructor Registro");
        Objects.requireNonNull(socio, "socio es null en constructor Registro");

        this.fecha = fecha;
        this.claseAsociada = claseAsociada;
        this.socio = socio;
        this.cuponera = cuponera;
    }

    public Cuponera getCuponera() {
        return cuponera;
    }

    public void setCuponera(Cuponera cup) {
        this.cuponera = cup;
    }

    public Clase getClaseAsociada() {
        return claseAsociada;
    }

    public void setClaseAsociada(Clase claseAsociada) {
        this.claseAsociada = claseAsociada;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        return Objects.hash(claseAsociada, cuponera, fecha, socio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Registro other = (Registro) obj;
        return Objects.equals(claseAsociada, other.claseAsociada)
                && Objects.equals(cuponera, other.cuponera) && Objects.equals(fecha, other.fecha)
                && Objects.equals(socio, other.socio);
    }

    @Override
    public String toString() {
        return "Registro [claseAsociada=" + claseAsociada.getNombre() +
            ", cuponera=" + cuponera.getNombre() +
            ", fecha=" + fecha +
            ", socio=" + socio.getNickname() + "]";
    }
}

