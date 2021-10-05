package com.entrenamosuy.core.exceptions;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CuponeraInconsistenteException extends Exception {

    public enum Restriccion {
        NOMBRE_REPETIDO,
        FIN_MENOR_INICIO,
        INICIO_MENOR_REGISTRO
    }

    private final List<Restriccion> inconsistencias;

    public CuponeraInconsistenteException(List<Restriccion> inconsistencias) {
        Objects.requireNonNull(inconsistencias);
        this.inconsistencias = inconsistencias;
    }

    public CuponeraInconsistenteException(Restriccion inconsistencia) {
        this(Collections.singletonList(inconsistencia));
    }

    public List<Restriccion> getInconsistencias() {
        return inconsistencias;
    }
}
