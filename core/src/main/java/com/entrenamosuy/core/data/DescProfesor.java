package com.entrenamosuy.core.data;

import java.net.URL;
import java.util.Objects;

public class DescProfesor {

    private final String nickname;

    private final String nombre;

    private final String apellido;

    private final URL sitioWeb;

    public DescProfesor(String nickname, String nombre, String apellido, URL sitioWeb) {
        Objects.requireNonNull(nickname, "nickname es null en constructor DescProfesor");
        Objects.requireNonNull(nombre, "nombre es null en constructor DescProfesor");
        Objects.requireNonNull(apellido, "apellido es null en constructor DescProfesor");

        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sitioWeb = sitioWeb;
    }

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public URL getSitioWeb() {
        return sitioWeb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, nombre, apellido, sitioWeb);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DescProfesor other = (DescProfesor) obj;
        return Objects.equals(nickname, other.nickname)
                && Objects.equals(nombre, other.nombre)
                && Objects.equals(apellido, other.apellido)
                && Objects.equals(sitioWeb, other.sitioWeb);
    }
}
