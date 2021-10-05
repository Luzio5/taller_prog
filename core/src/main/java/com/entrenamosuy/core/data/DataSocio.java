package com.entrenamosuy.core.data;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class DataSocio extends DataUsuario {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nickname;

        private String nombre;

        private String apellido;

        private Email correo;

        private LocalDate nacimiento;

        private Set<DataClase> clases = Collections.emptySet();

        public Builder setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder setCorreo(Email correo) {
            this.correo = correo;
            return this;
        }

        public Builder setNacimiento(LocalDate nacimiento) {
            this.nacimiento = nacimiento;
            return this;
        }

        public Builder setClases(Set<DataClase> clases) {
            this.clases = clases;
            return this;
        }

        public DataSocio build() {
            return new DataSocio(nickname, nombre, apellido, correo, nacimiento, clases);
        }
    }

    private final Set<DataClase> clases;

    protected DataSocio(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
            Set<DataClase> clases) {

        super(nickname, nombre, apellido, correo, nacimiento);
        this.clases = clases;
    }

    public Set<DataClase> getClases() {
        return clases;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj) || getClass() != obj.getClass())
            return false;
        DataSocio other = (DataSocio) obj;
        return Objects.equals(clases, other.clases);
    }
}
