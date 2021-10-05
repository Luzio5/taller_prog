package com.entrenamosuy.core;

import java.nio.ByteBuffer;
import java.util.Set;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.RegistroInconsistenteException;

import java.time.Duration;
import java.time.LocalDate;

public abstract class AbstractFacadeActividad extends AbstractFacade {

    public interface CrearActividadChain {

        CrearActividadChain setInstitucion(String institucion);

        CrearActividadChain setNombre(String nombre);

        CrearActividadChain setDescripcion(String descripcion);

        CrearActividadChain setDuracion(Duration duracion);

        CrearActividadChain setCosto(float costo);

        CrearActividadChain setRegistro(LocalDate registro);

        CrearActividadChain setImagen(ByteBuffer imagen);

        void invoke() throws ActividadRepetidaException;
    }

    public abstract CrearActividadChain crearActividad();

    public abstract void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro)
            throws RegistroInconsistenteException;

    public abstract void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro)
            throws RegistroInconsistenteException;

    public abstract Set<String> getActividadesDeInstitucion(String institucion);

    public abstract DataActividad getDataActividad(String actividad);
}
