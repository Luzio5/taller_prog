package com.entrenamosuy.core;

import com.entrenamosuy.core.data.DataInstitucion;
import com.entrenamosuy.core.exceptions.InstitucionRepetidaException;

import java.nio.ByteBuffer;
import java.net.URL;
import java.util.Set;

public abstract class AbstractFacadeInstitucion extends AbstractFacade {

    public interface CrearInstitucionChain {

        CrearInstitucionChain setNombre(String nombre);

        CrearInstitucionChain setDescripcion(String descripcion);

        CrearInstitucionChain setUrl(URL url);

        CrearInstitucionChain setImagen(ByteBuffer imagen);

        void invoke() throws InstitucionRepetidaException;
    }

    public abstract CrearInstitucionChain crearInstitucion();

    public abstract Set<String> getInstituciones();

    public abstract DataInstitucion getDataInstitucion(String institucion);
}
