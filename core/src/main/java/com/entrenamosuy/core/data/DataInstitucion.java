package com.entrenamosuy.core.data;

import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DataInstitucion {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String nombre;

        private String descripcion;

        private URL url;

        private Set<DataActividad> actividadesOfrecidas = new HashSet<>();

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder setUrl(URL url) {
            this.url = url;
            return this;
        }

        public Builder setActividadesOfrecidas(Set<DataActividad> actividadesOfrecidas) {
            this.actividadesOfrecidas = actividadesOfrecidas;
            return this;
        }

        public DataInstitucion build() {
            return new DataInstitucion(nombre, descripcion, url, actividadesOfrecidas);
        }
    }

    private final String nombre;

    private final String descripcion;

    private final URL url;

    private final Set<DataActividad> actividadesOfrecidas;

    protected DataInstitucion(String nombre, String descripcion, URL url, Set<DataActividad> actividadesOfrecidas) {

        Objects.requireNonNull(nombre, "nombre es null en constructor DataInstitucion");
        Objects.requireNonNull(descripcion, "descripcion es null en constructor DataInstitucion");
        Objects.requireNonNull(url, "url es null en constructor DataInstitucion");
        Objects.requireNonNull(actividadesOfrecidas, "actividadesOfrecidas es null en constructor DataInstitucion");

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.actividadesOfrecidas = actividadesOfrecidas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public URL getUrl() {
        return url;
    }

    public Set<DataActividad> getActividadesOfrecidas() {
        return actividadesOfrecidas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, url);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DataInstitucion other = (DataInstitucion) obj;
        return Objects.equals(descripcion, other.descripcion)
                && Objects.equals(nombre, other.nombre)
                && Objects.equals(url, other.url);
    }
}
