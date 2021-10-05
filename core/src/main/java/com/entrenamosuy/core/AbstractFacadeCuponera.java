package com.entrenamosuy.core;

import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.Set;

import com.entrenamosuy.core.exceptions.CuponeraInconsistenteException;
import com.entrenamosuy.core.data.DataCuponera;

public abstract class AbstractFacadeCuponera extends AbstractFacade {

    public interface CrearCuponeraChain {

        CrearCuponeraChain setNombre(String nombre);

        CrearCuponeraChain setDescripcion(String descripcion);

        CrearCuponeraChain setInicio(LocalDate inicio);

        CrearCuponeraChain setFin(LocalDate fin);

        CrearCuponeraChain setDescuento(int descuento);

        CrearCuponeraChain setFechaRegistro(LocalDate fechaRegistro);

        CrearCuponeraChain setImagen(ByteBuffer imagen);

        void invoke() throws CuponeraInconsistenteException;
    }

    public abstract CrearCuponeraChain crearCuponera();

    public abstract Set<String> cuponerasUsables(String actividad, String socio);

    public abstract Set<String> actividadesAgregables(String cuponera, String institucion);

    public abstract void agregarACuponera(String cuponera, String actividad, int cant);

    public abstract Set<String> getCuponeras();

    public abstract DataCuponera getDataCuponera(String nombre);
}
