package com.entrenamosuy.core;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.nio.ByteBuffer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;
import com.entrenamosuy.core.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.core.exceptions.ProfesorNoEncontradoException;
import com.entrenamosuy.core.model.Actividad;
import com.entrenamosuy.core.model.Clase;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.model.Registro;

public class FacadeClase extends AbstractFacadeClase {

    @Override
    public CrearClaseChain crearClase() {
        return new CrearClaseChain() {

            private String nombreActividad;

            private String nombre;

            private LocalDateTime inicio;

            private Set<String> nicknameProfesores;

            private int cantMin, cantMax;

            private URL acceso;

            private LocalDate fechaRegistro;

            private ByteBuffer imagen;

            @Override
            public CrearClaseChain setNombreActividad(String nombreActividad) {
                this.nombreActividad = nombreActividad;
                return this;
            }

            @Override
            public CrearClaseChain setNombre(String nombre) {
                this.nombre = nombre;
                return this;
            }

            @Override
            public CrearClaseChain setInicio(LocalDateTime inicio) {
                this.inicio = inicio;
                return this;
            }

            @Override
            public CrearClaseChain setNicknameProfesores(Set<String> nicknameProfesores) {
                this.nicknameProfesores = nicknameProfesores;
                return this;
            }

            @Override
            public CrearClaseChain setCantMin(int cantMin) {
                this.cantMin = cantMin;
                return this;
            }

            @Override
            public CrearClaseChain setCantMax(int cantMax) {
                this.cantMax = cantMax;
                return this;
            }

            @Override
            public CrearClaseChain setAcceso(URL acceso) {
                this.acceso = acceso;
                return this;
            }

            @Override
            public CrearClaseChain setFechaRegistro(LocalDate fechaRegistro) {
                this.fechaRegistro = fechaRegistro;
                return this;
            }

            @Override
            public CrearClaseChain setImagen(ByteBuffer imagen) {
                this.imagen = imagen;
                return this;
            }

            @Override
            public void invoke() throws ClaseInconsistenteException {
                Map<String, Actividad> actividades = getRegistry().getActividades();
                Map<String, Clase> clases = getRegistry().getClases();
                Map<String, Profesor> profesores = getRegistry().getProfesores();
                Actividad actividad = actividades.get(nombreActividad);

                if (actividad == null)
                    throw new ActividadNoEncontradaException("No existe actividad con nombre: " + nombreActividad);

                LocalDateTime registroDateTime = LocalDateTime.of(fechaRegistro, LocalTime.of(0, 0));
                LocalDateTime actividadRegistroDateTime = LocalDateTime.of(actividad.getFechaRegistro(), LocalTime.of(0, 0));

                List<ClaseInconsistenteException.Restriccion> inconsistencias = new ArrayList<>();

                if (clases.containsKey(nombre))
                    inconsistencias.add(ClaseInconsistenteException.Restriccion.NOMBRE_REPETIDO);

                if (cantMin > cantMax)
                    inconsistencias.add(ClaseInconsistenteException.Restriccion.CANT_MAX_MENOR_MIN);

                if (registroDateTime.isAfter(inicio))
                    inconsistencias.add(ClaseInconsistenteException.Restriccion.INICIO_MENOR_REGISTRO);

                if (actividadRegistroDateTime.isAfter(registroDateTime))
                    inconsistencias.add(ClaseInconsistenteException.Restriccion.REGISTRO_MENOR_REGISTRO_ACTIVIDAD);

                if (!inconsistencias.isEmpty())
                    throw new ClaseInconsistenteException(inconsistencias);

                Set<Profesor> profes = new HashSet<>();
                for (String nickname : nicknameProfesores) {
                    Profesor p = profesores.get(nickname);

                    if (p == null)
                        throw new ProfesorNoEncontradoException("No existe un profesor con nickname: " + nickname);

                    profes.add(p);
                }

                Set<Registro> registros = new HashSet<>();
                Clase nuevaClase = Clase.builder()
                        .setNombre(nombre)
                        .setInicio(inicio)
                        .setCantMin(cantMin)
                        .setCantMax(cantMax)
                        .setAcceso(acceso)
                        .setFechaRegistro(fechaRegistro)
                        .setRegistros(registros)
                        .setProfesores(profes)
                        .setActividad(actividad)
                        .setImagen(imagen)
                        .build();

                for (Profesor p : profes) {
                    p.getClasesDictadas().add(nuevaClase);
                    p.getActividadesRegistradas().add(actividad);
                }

                actividad.getClases().add(nuevaClase);
                clases.put(nombre, nuevaClase);
            }
        };
    }

    @Override
    public Set<String> getClases(String actividad) {
        Actividad act = getRegistry().getActividades().get(actividad);
        if (act == null)
            throw new ActividadNoEncontradaException("No existe actividad con nombre:" + actividad);
        Set<Clase> clases = act.getClases();
        Set<String> res = new HashSet<>();
        for (Clase clase : clases)
            res.add(clase.getNombre());

        return res;
    }

    @Override
    public DataClase getDataClase(String nombre) {
        Clase clase = getRegistry().getClases().get(nombre);

        if (clase == null)
            throw new ClaseNoEncontradaException("No existe clase con nombre:" + nombre);

        return clase.getDataClase();
    }
}
