package com.entrenamosuy.core.exceptions;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ClaseInconsistenteException extends Exception {

    public enum Restriccion {
        CANT_MAX_MENOR_MIN,
        INICIO_MENOR_REGISTRO,
        REGISTRO_MENOR_REGISTRO_ACTIVIDAD,
        NOMBRE_REPETIDO
    }

    private final List<Restriccion> inconsistencias;

    public ClaseInconsistenteException(List<Restriccion> inconsistencias) {
        Objects.requireNonNull(inconsistencias);
        this.inconsistencias = inconsistencias;
    }

    public ClaseInconsistenteException(Restriccion inconsistencia) {
        this(Collections.singletonList(inconsistencia));
    }

    public List<Restriccion> getInconsistencias() {
        return inconsistencias;
    }
}
