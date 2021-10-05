package com.entrenamosuy.core;

import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;

import java.nio.ByteBuffer;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public abstract class AbstractFacadeClase extends AbstractFacade {

    public interface CrearClaseChain {

        CrearClaseChain setNombreActividad(String nombreActividad);

        CrearClaseChain setNombre(String nombre);

        CrearClaseChain setInicio(LocalDateTime inicio);

        CrearClaseChain setNicknameProfesores(Set<String> nicknameProfesores);

        CrearClaseChain setCantMin(int cantMin);

        CrearClaseChain setCantMax(int cantMax);

        CrearClaseChain setAcceso(URL acceso);

        CrearClaseChain setFechaRegistro(LocalDate fechaRegistro);

        CrearClaseChain setImagen(ByteBuffer imagen);

        void invoke() throws ClaseInconsistenteException;
    }

    public abstract CrearClaseChain crearClase();

    public abstract Set<String> getClases(String actividad);

    public abstract DataClase getDataClase(String nombre);
}
