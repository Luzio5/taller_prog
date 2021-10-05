package com.entrenamosuy.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DescProfesor;

public class Clase {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;

        private LocalDateTime inicio;

        private int cantMin, cantMax;

        private URL acceso;

        private LocalDate fechaRegistro;

        private Set<Registro> registros = new HashSet<>();

        private Set<Profesor> profesores = new HashSet<>();

        private Actividad actividad;

        private ByteBuffer imagen;

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setInicio(LocalDateTime inicio) {
            this.inicio = inicio;
            return this;
        }

        public Builder setCantMin(int cantMin) {
            this.cantMin = cantMin;
            return this;
        }

        public Builder setCantMax(int cantMax) {
            this.cantMax = cantMax;
            return this;
        }

        public Builder setAcceso(URL acceso) {
            this.acceso = acceso;
            return this;
        }

        public Builder setFechaRegistro(LocalDate fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public Builder setRegistros(Set<Registro> registros) {
            this.registros = registros;
            return this;
        }

        public Builder setProfesores(Set<Profesor> profesores) {
            this.profesores = profesores;
            return this;
        }

        public Builder setActividad(Actividad actividad) {
            this.actividad = actividad;
            return this;
        }

        public Builder setImagen(ByteBuffer imagen) {
            this.imagen = imagen;
            return this;
        }

        public Clase build() {
            return new Clase(nombre, inicio, cantMin, cantMax, acceso, fechaRegistro,
                    registros, profesores, actividad, imagen);
        }
    }

    private String nombre;

    private LocalDateTime inicio;

    private int cantMin, cantMax;

    private URL acceso;

    private LocalDate fechaRegistro;

    private Set<Registro> registros;

    private Set<Profesor> profesores;

    private Actividad actividad;

    private ByteBuffer imagen;

    protected Clase(String nombre, LocalDateTime inicio, int cantMin, int cantMax,
                 URL acceso, LocalDate fechaRegistro, Set<Registro> registros,
                 Set<Profesor> profesores, Actividad actividad, ByteBuffer imagen) {

        Objects.requireNonNull(nombre, "nombre es null en constructor Clase");
        Objects.requireNonNull(inicio, "inicio es null en constructor Clase");
        Objects.requireNonNull(acceso, "acceso es null en constructor Clase");
        Objects.requireNonNull(fechaRegistro, "fechaRegistro es null en constructor Clase");
        Objects.requireNonNull(registros, "registros es null en constructor Clase");
        Objects.requireNonNull(profesores, "profesores es null en constructor Clase");
        Objects.requireNonNull(actividad, "actividad es null en constructor Clase");

        this.nombre = nombre;
        this.inicio = inicio;
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.acceso = acceso;
        this.fechaRegistro = fechaRegistro;
        this.registros = registros = new HashSet<>();
        this.profesores = profesores;
        this.actividad = actividad;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public int getCantMin() {
        return cantMin;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public URL getAcceso() {
        return acceso;
    }

    public void setAcceso(URL acceso) {
        this.acceso = acceso;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Set<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Set<Registro> registros) {
        this.registros = registros;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public ByteBuffer getImagen() {
        return imagen;
    }

    public void setImagen(ByteBuffer imagen) {
        this.imagen = imagen;
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
        Clase other = (Clase) obj;
        return Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Clase = [nombre=")
            .append(nombre)
            .append(", actividad=")
            .append(actividad.getNombre())
            .append(", profesores=[");

        if (!profesores.isEmpty()) {
            Iterator<Profesor> it = profesores.iterator();

            builder.append(it.next().getNombre());

            while (it.hasNext())
                builder.append(", ").append(it.next().getNombre());
        }

        builder.append("]]");
        return builder.toString();
    }

    public void registrarseSinCuponera(Socio socio, LocalDate fecha) {
        Registro reg = Registro.builder()
                .setFecha(fecha)
                .setSocio(socio)
                .setClaseAsociada(this)
                .build();
        registros.add(reg);
        socio.asociarSocioRegistro(reg);
    }

    public void registrarseConCuponera(Socio socio, LocalDate fecha, Cuponera cup) {
        Registro nuevoReg = Registro.builder()
                .setFecha(fecha)
                .setClaseAsociada(this)
                .setSocio(socio)
                .setCuponera(cup)
                .build();
        registros.add(nuevoReg);
        socio.asociarSocioRegistro(nuevoReg);
    }

    public DataClase getDataClase() {
        Set<DescProfesor> descProfes = new HashSet<>();

        for (Profesor p : profesores)
            descProfes.add(p.getDescProfesor());

        return DataClase.builder()
            .setNombre(nombre)
            .setInicio(inicio)
            .setCantMin(cantMin)
            .setCantMax(cantMax)
            .setAccesoURL(acceso)
            .setActividad(actividad.getDescActividad())
            .setProfesores(descProfes)
            .build();
    }
}
