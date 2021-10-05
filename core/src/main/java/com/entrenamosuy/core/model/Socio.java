package com.entrenamosuy.core.model;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.Email;

public class Socio extends Usuario {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nickname;

        private String nombre;

        private String apellido;

        private Email correo;

        private LocalDate nacimiento;

        private String password;

        private Set<Usuario> usuariosSeguidos = new HashSet<>();

        private Set<Usuario> seguidores = new HashSet<>();

        private ByteBuffer imagen;

        private Set<Registro> registros = new HashSet<>();

        private Set<Compra> compras = new HashSet<>();

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

        public Builder setRegistros(Set<Registro> registros) {
            this.registros = registros;
            return this;
        }

        public Builder setCompras(Set<Compra> compras) {
            this.compras = compras;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setUsuariosSeguidos(Set<Usuario> usariosSeguidos) {
            this.usuariosSeguidos = usariosSeguidos;
            return this;
        }

        public Builder setSeguidores(Set<Usuario> seguidores) {
            this.seguidores = seguidores;
            return this;
        }

        public Builder setImagen(ByteBuffer imagen) {
            this.imagen = imagen;
            return this;
        }

        public Socio build() {
            return new Socio(nickname, nombre, apellido, correo, nacimiento, registros, compras,
                    password, usuariosSeguidos, seguidores, imagen);
        }
    }

    private Set<Registro> registros;

    private Set<Compra> compras;

    protected Socio(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
                 Set<Registro> registros, Set<Compra> compras, String password, Set<Usuario> usuariosSeguidos,
                 Set<Usuario> seguidores, ByteBuffer imagen) {

        super(nickname, nombre, apellido, correo, nacimiento, password, usuariosSeguidos, seguidores, imagen);

        Objects.requireNonNull(registros, "registros es null en constructor Socio");
        Objects.requireNonNull(compras, "compras es null en constructor Socio");

        this.registros = registros;
        this.compras = compras;
    }

    public Set<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Set<Registro> registros) {
        this.registros = registros;
    }

    public Set<Compra> getCompras() {
        return compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Profesor = [nickname=")
            .append(getNickname())
            .append(", nombre=")
            .append(getNombre())
            .append(", apellido=")
            .append(getApellido())
            .append(", registros=[");

        if (!registros.isEmpty()) {
            Iterator<Registro> it = registros.iterator();

            builder.append(it.next().getClaseAsociada().getNombre());

            while (it.hasNext())
                builder.append(", ")
                    .append(it.next().getClaseAsociada().getNombre());
        }

        builder.append("], cuponeras=[");

        if (!compras.isEmpty()) {
            Iterator<Compra> it = compras.iterator();

            builder.append(it.next().getCuponera().getNombre());

            while (it.hasNext())
                builder.append(", ")
                    .append(it.next().getCuponera().getNombre());
        }

        builder.append("]]");
        return builder.toString();
    }

    public Set<String> cuponerasUsables(Actividad a) {
        List<Cuponera> cuponerasADescribir = new ArrayList<>();

        for (Compra compra : compras) {
            Cuponera cup = compra.getCuponera();
            // Obtener el tipo asociativo integra entre cup y a.
            Integra integra = cup.getIntegra(a);
            // Si la cuponera actual no tiene la actividad deseada no continuar.
            if (integra == null)
                continue;
            // Obtener la cantidad de registros que utilizan cup y compararlo con la cantidad de integra.
            int cantRegistros = cantRegistrosConCuponeraA(a, cup);
            int cantClases = integra.getCantClases();
            if (cantRegistros < cantClases)
                cuponerasADescribir.add(cup);
        }
        Set<String> ret = new HashSet<>(cuponerasADescribir.size());

        for (Cuponera cup : cuponerasADescribir)
            ret.add(cup.getNombre());

        return ret;
    }

    public int cantRegistrosConCuponeraA(Actividad a, Cuponera cup) {
        int ret = 0;

        for (Registro reg : registros) {
            Clase claseRegistro = reg.getClaseAsociada();

            if (reg.getCuponera().equals(cup) && a.getClases().contains(claseRegistro))
                ret++;
        }

        return ret;
    }

    public DataSocio getDataSocio() {
        Set<Registro> registros = getRegistros();
        Set<DataClase> dataClases = new HashSet<>(registros.size());

        for (Registro r : registros) {
            Clase clase = r.getClaseAsociada();
            dataClases.add(clase.getDataClase());
        }

        return DataSocio.builder()
            .setNickname(getNickname())
            .setNombre(getNombre())
            .setApellido(getApellido())
            .setCorreo(getCorreo())
            .setNacimiento(getNacimiento())
            .setClases(dataClases)
            .build();
    }

    public void asociarSocioRegistro(Registro reg) {
        registros.add(reg);
    }
}
