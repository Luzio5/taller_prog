package com.entrenamosuy.core.exceptions;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RegistroInconsistenteException extends Exception {

    public enum Restriccion {
        CLASE_LLENA,
        FECHA_REGISTRO_MENOR_REGISTRO_CLASE,
        CUPONERA_NO_COMPRADA,
        CUPONERA_NO_TIENE_ACTIVIDAD_CON_CLASE,
        CUPONERA_LLENA
    }

    private final List<Restriccion> inconsistencias;

    public RegistroInconsistenteException(List<Restriccion> inconsistencias) {
        Objects.requireNonNull(inconsistencias);
        this.inconsistencias = inconsistencias;
    }

    public RegistroInconsistenteException(Restriccion inconsistencia) {
        this(Collections.singletonList(inconsistencia));
    }

    public List<Restriccion> getInconsistencias() {
        return inconsistencias;
    }
}