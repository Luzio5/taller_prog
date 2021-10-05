package com.entrenamosuy.core;

import java.nio.ByteBuffer;
import java.net.URL;
import java.time.LocalDate;
import java.util.Set;

import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.exceptions.PasswordInvalidaException;
import com.entrenamosuy.core.exceptions.ProfesorNoEncontradoException;

public abstract class AbstractFacadeUsuario extends AbstractFacade {

    public interface CrearProfesorChain {

        CrearProfesorChain setNickname(String nickname);

        CrearProfesorChain setNombre(String nombre);

        CrearProfesorChain setApellido(String apellido);

        CrearProfesorChain setCorreo(Email correo);

        CrearProfesorChain setNacimiento(LocalDate nacimiento);

        CrearProfesorChain setInstitucion(String institucion);

        CrearProfesorChain setDescripcion(String descripcion);

        CrearProfesorChain setBiografia(String bio);

        CrearProfesorChain setSitioWeb(URL link);

        CrearProfesorChain setPassword(String password);

        CrearProfesorChain setImagen(ByteBuffer imagen);

        void invoke() throws UsuarioRepetidoException;
    }

    public abstract CrearProfesorChain crearProfesor();

    public interface CrearSocioChain {

        CrearSocioChain setNickname(String nickname);

        CrearSocioChain setNombre(String nombre);

        CrearSocioChain setApellido(String apellido);

        CrearSocioChain setCorreo(Email correo);

        CrearSocioChain setNacimiento(LocalDate nacimiento);

        CrearSocioChain setPassword(String password);

        CrearSocioChain setImagen(ByteBuffer imagen);

        void invoke() throws UsuarioRepetidoException;
    }

    public abstract CrearSocioChain crearSocio();

    public interface ModificarDatosSocioChain {

        ModificarDatosSocioChain setNickname(String nickname);

        ModificarDatosSocioChain setNombre(String nombre);

        ModificarDatosSocioChain setApellido(String apellido);

        ModificarDatosSocioChain setNacimiento(LocalDate nacimiento);

        ModificarDatosSocioChain setImagen(ByteBuffer imagen);

        void invoke() throws ProfesorNoEncontradoException;
    }

    public abstract ModificarDatosSocioChain modificarDatosSocio();

    public interface ModificarDatosProfesorChain {

        ModificarDatosProfesorChain setNickname(String nickname);

        ModificarDatosProfesorChain setNombre(String nombre);

        ModificarDatosProfesorChain setApellido(String apellido);

        ModificarDatosProfesorChain setNacimiento(LocalDate nacimiento);

        ModificarDatosProfesorChain setDescripcion(String descripcion);

        ModificarDatosProfesorChain setBiografia(String biografia);

        ModificarDatosProfesorChain setSitioWeb(URL sitioWeb);

        ModificarDatosProfesorChain setImagen(ByteBuffer imagen);

        void invoke() throws ProfesorNoEncontradoException;
    }

    public abstract ModificarDatosProfesorChain modificarDatosProfesor();

    public abstract Set<String> getSocios();

    public abstract Set<String> getProfesores();

    public abstract Set<String> getProfesoresDeInstitucion(String institucion);

    public abstract DataSocio getDataSocio(String nickname);

    public abstract DataProfesor getDataProfesor(String nickname);

    public abstract void validarCredenciales(String nickname, String password) throws PasswordInvalidaException;
}
