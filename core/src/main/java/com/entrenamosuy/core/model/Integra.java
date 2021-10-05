package com.entrenamosuy.core.model;

import java.util.Objects;

public class Integra {

    private int cantClases;

    private Actividad actividad;

    private Cuponera cuponera;

    public Integra(int cantClases, Actividad actividad, Cuponera cuponera) {
        Objects.requireNonNull(actividad, "actividad es null en constructor Integra");
        Objects.requireNonNull(cuponera, "cuponera es null en constructor Integra");

        this.cantClases = cantClases;
        this.actividad = actividad;
        this.cuponera = cuponera;
    }

    public int getCantClases() {
        return cantClases;
    }

    public void setCantClases(int cantClases) {
        this.cantClases = cantClases;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Cuponera getCuponera() {
        return cuponera;
    }

    public void setCuponera(Cuponera cuponera) {
        this.cuponera = cuponera;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantClases, actividad, cuponera);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Integra other = (Integra) obj;
        return cantClases == other.cantClases &&
            Objects.equals(actividad, other.actividad) &&
            Objects.equals(cuponera, other.cuponera);
    }

    @Override
    public String toString() {
        return "Integra [actividad=" + actividad.getNombre() +
            ", cuponera=" + cuponera.getNombre() +
            ", cantClases=" + cantClases + "]";
    }
}
