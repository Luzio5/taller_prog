package com.entrenamosuy.core.model;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import com.entrenamosuy.core.data.Email;

public abstract class Usuario {

    private String nickname;

    private String nombre;

    private String apellido;

    private Email correo;

    private LocalDate nacimiento;

    private String password;

    private Set<Usuario> usuariosSeguidos;

    private Set<Usuario> seguidores;

    private ByteBuffer imagen;

    public Usuario(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
            String password, Set<Usuario> usuariosSeguidos, Set<Usuario> seguidores, ByteBuffer imagen) {

        Objects.requireNonNull(nickname, "nickname es null en constructor Usuario");
        Objects.requireNonNull(nombre, "nombre es null en constructor Usuario");
        Objects.requireNonNull(apellido, "apellido es null en constructor Usuario");
        Objects.requireNonNull(correo, "correo es null en constructor Usuario");
        Objects.requireNonNull(nacimiento, "nacimiento es null en constructor Usuario");
        Objects.requireNonNull(password, "password es null en constructor Usuario");
        Objects.requireNonNull(usuariosSeguidos, "usuariosSeguidos es null en constructor Usuario");
        Objects.requireNonNull(seguidores, "seguidores es null en constructor Usuario");

        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.password = password;
        this.usuariosSeguidos = usuariosSeguidos;
        this.seguidores = seguidores;
        this.imagen = imagen;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Email getCorreo() {
        return correo;
    }

    public void setCorreo(Email correo) {
        this.correo = correo;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Usuario> getUsuariosSeguidos() {
        return usuariosSeguidos;
    }

    public void setUsuariosSeguidos(Set<Usuario> usuariosSeguidos) {
        this.usuariosSeguidos = usuariosSeguidos;
    }

    public Set<Usuario> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Set<Usuario> seguidores) {
        this.seguidores = seguidores;
    }

    public ByteBuffer getImagen() {
        return imagen;
    }

    public void setImagen(ByteBuffer imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo, nickname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(nickname, other.nickname);
    }
}
