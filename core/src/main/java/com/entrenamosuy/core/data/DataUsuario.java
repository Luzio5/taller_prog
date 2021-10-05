package com.entrenamosuy.core.data;

import java.time.LocalDate;
import java.util.Objects;

public abstract class DataUsuario {

    private final String nickname;

    private final String nombre;

    private final String apellido;

    private final Email correo;

    private final LocalDate nacimiento;

    public DataUsuario(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento) {
        Objects.requireNonNull(nickname, "nickname es null en constructor DataUsuario");
        Objects.requireNonNull(nombre, "nombre es null en constructor DataUsuario");
        Objects.requireNonNull(apellido, "apellido es null en constructor DataUsuario");
        Objects.requireNonNull(correo, "correo es null en constructor DataUsuario");
        Objects.requireNonNull(nacimiento, "nacimiento es null en constructor DataUsuario");

        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nacimiento = nacimiento;
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

    public Email getCorreo() {
        return correo;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, nombre, apellido, correo, nacimiento);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataUsuario other = (DataUsuario) obj;
        return Objects.equals(nickname, other.nickname)
                && Objects.equals(nombre, other.nombre)
                && Objects.equals(apellido, other.apellido)
                && Objects.equals(correo, other.correo)
                && Objects.equals(nacimiento, other.nacimiento);
    }
}
