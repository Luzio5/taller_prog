package com.entrenamosuy.core;

import java.util.*;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.LocalDate;

import com.entrenamosuy.core.exceptions.*;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.model.*;

public class FacadeActividad extends AbstractFacadeActividad {

    @Override
    public CrearActividadChain crearActividad() {
        return new CrearActividadChain() {

            private String institucion;

            private String nombre;

            private String descripcion;

            private Duration duracion;

            private float costo;

            private LocalDate registro;

            private ByteBuffer imagen;

            @Override
            public CrearActividadChain setInstitucion(String institucion) {
                this.institucion = institucion;
                return this;
            }

            @Override
            public CrearActividadChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public CrearActividadChain setDescripcion(String descripcion) {
                this.descripcion = descripcion;
                return this;
            }

            @Override
            public CrearActividadChain setDuracion(Duration duracion) {
                this.duracion = duracion;
                return this;
            }

            @Override
            public CrearActividadChain setCosto(float costo) {
                this.costo = costo;
                return this;
            }

            @Override
            public CrearActividadChain setRegistro(LocalDate registro) {
                this.registro = registro;
                return this;
            }

            @Override
            public CrearActividadChain setImagen(ByteBuffer imagen) {
                this.imagen = imagen;
                return null;
            }

            @Override
            public void invoke() throws ActividadRepetidaException, InstitucionNoEncontradaException {
                Map<String, Actividad> actividades = getRegistry().getActividades();
                Map<String, Institucion> instituciones = getRegistry().getInstituciones();

                if (actividades.containsKey(nombre))
                    throw new ActividadRepetidaException("La actividad llamada " + nombre + " ya existe.");

                if (!instituciones.containsKey(institucion))
                    throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);

                Institucion inst = instituciones.get(institucion);
                Actividad nuevaActividad = Actividad.builder()
                        .setNombre(nombre)
                        .setDescripcion(descripcion)
                        .setDuracion(duracion)
                        .setFechaRegistro(registro)
                        .setCosto(costo)
                        .setImagen(imagen)
                        .build();
                inst.getActividadesOfrecidas().add(nuevaActividad);
                actividades.put(nombre, nuevaActividad);
            }
        };
    }

    @Override
    public void registarseSinCuponera(String socio, String clase, LocalDate fechaRegistro) throws RegistroInconsistenteException {

        Clase c = getRegistry().getClases().get(clase);
        Socio s = getRegistry().getSocios().get(socio);

        if (c == null)
            throw new ClaseNoEncontradaException("No existe una clase con nombre: " + clase);

        if (s == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

        List<RegistroInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

        if ((c.getCantMax() - c.getRegistros().size()) <= 0)
            inconsistencias.add(RegistroInconsistenteException.Restriccion.CLASE_LLENA);

        if (fechaRegistro.isBefore(c.getFechaRegistro()))
            inconsistencias.add(RegistroInconsistenteException.Restriccion.FECHA_REGISTRO_MENOR_REGISTRO_CLASE);

        if (!inconsistencias.isEmpty())
            throw new RegistroInconsistenteException(inconsistencias);

        c.registrarseSinCuponera(s, fechaRegistro);
    }

    @Override
    public void registraseConCuponera(String socio, String clase, String cuponera, LocalDate fechaRegistro)
        throws RegistroInconsistenteException {

        Clase c = getRegistry().getClases().get(clase);
        Socio s = getRegistry().getSocios().get(socio);
        Cuponera cup = getRegistry().getCuponeras().get(cuponera);

        if (c == null)
            throw new ClaseNoEncontradaException("No existe una clase con nombre: " + clase);

        if (s == null)
            throw new SocioNoEncontradoException("No existe un socio con nickname: " + socio);

        if (cup == null)
            throw new CuponeraNoEncontradaException("No existe una cuponera con nombre: " + cuponera);

        List<RegistroInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

        if ((c.getCantMax() - c.getRegistros().size()) <= 0)
            inconsistencias.add(RegistroInconsistenteException.Restriccion.CLASE_LLENA);

        if (fechaRegistro.isBefore(c.getFechaRegistro()))
            inconsistencias.add(RegistroInconsistenteException.Restriccion.FECHA_REGISTRO_MENOR_REGISTRO_CLASE);

        if (!inconsistencias.isEmpty())
            throw new RegistroInconsistenteException(inconsistencias);

        c.registrarseConCuponera(s, fechaRegistro, cup);
    }

    @Override
    public Set<String> getActividadesDeInstitucion(String institucion) throws InstitucionNoEncontradaException {
        Set<String> res = new HashSet<>();
        Map<String, Institucion> inst = getRegistry().getInstituciones();

        Institucion i = inst.get(institucion);
        if (i == null) {
            throw new InstitucionNoEncontradaException("No existe una institucion con nombre: " + institucion);
        }
        Set<Actividad> acts = i.getActividadesOfrecidas();
        for (Actividad a : acts)
            res.add(a.getNombre());

        return res;
    }

    @Override
    public DataActividad getDataActividad(String actividad) throws ActividadNoEncontradaException {
        Map<String, Actividad> acts = getRegistry().getActividades();
        if (acts.isEmpty())
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        Actividad a = acts.get(actividad);
        if (a == null) {
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        }
        return a.getDataActividad();
    }
}
