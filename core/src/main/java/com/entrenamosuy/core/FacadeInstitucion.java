package com.entrenamosuy.core;

import java.nio.ByteBuffer;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.entrenamosuy.core.data.DataInstitucion;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.InstitucionRepetidaException;
import com.entrenamosuy.core.model.Institucion;

public class FacadeInstitucion extends AbstractFacadeInstitucion {

    @Override
    public CrearInstitucionChain crearInstitucion() {
        return new CrearInstitucionChain() {

            private String nombre;

            private String descripcion;

            private URL url;

            private ByteBuffer imagen;

            @Override
            public CrearInstitucionChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public CrearInstitucionChain setDescripcion(String descripcion) {
                this.descripcion = descripcion;
                return this;
            }

            @Override
            public CrearInstitucionChain setUrl(URL url) {
                this.url = url;
                return this;
            }

            @Override
            public CrearInstitucionChain setImagen(ByteBuffer imagen) {
                this.imagen = imagen;
                return this;
            }

            @Override
            public void invoke() throws InstitucionRepetidaException {
                Map<String, Institucion> instituciones = getRegistry().getInstituciones();

                if (instituciones.containsKey(nombre)) {
                    throw new InstitucionRepetidaException("La institución llamada " + nombre + " ya existe.");
                }

                Institucion res = Institucion.builder()
                    .setNombre(nombre)
                    .setDescripcion(descripcion)
                    .setUrl(url)
                    .setImagen(imagen)
                    .build();

                instituciones.put(nombre, res);
            }
        };
    }

    @Override
    public Set<String> getInstituciones() {
        Set<String> res = new HashSet<>();
        Map<String, Institucion> inst = getRegistry().getInstituciones();

        for (Institucion i : inst.values())
            res.add(i.getNombre());

        return res;
    }

    @Override
    public DataInstitucion getDataInstitucion(String institucion) {
        Institucion inst = getRegistry().getInstituciones().get(institucion);

        if (inst == null)
            throw new InstitucionNoEncontradaException(institucion);

        return inst.getDataInstitucion();
    }
}
