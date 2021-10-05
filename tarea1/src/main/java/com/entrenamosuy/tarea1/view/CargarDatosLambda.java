package com.entrenamosuy.tarea1.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeUsuario;

public class CargarDatosLambda implements ActionListener {

    public interface Callback {

        void finished();
    }

    private final AbstractFacadeUsuario CU;

    private final AbstractFacadeActividad CAC;

    private final AbstractFacadeCuponera CC;

    private final Callback callback;

    public CargarDatosLambda(AbstractFacadeUsuario controladorUsuario,
                             AbstractFacadeActividad controladorActividadClase, AbstractFacadeCuponera controladorCuponera,
                             Callback callback) {
        this.CU = controladorUsuario;
        this.CAC = controladorActividadClase;
        this.CC = controladorCuponera;
        this.callback = callback;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        try {
            CU.crearSocio().setNickname("Emi71").setNombre("Emiliano").setApellido("Lucas").setCorreo(Email.of("emi71", "gmail.com")).setNacimiento(LocalDate.of(1971, 12, 31)).invoke();
            CU.crearSocio().setNickname("caro").setNombre("Carolina").setApellido("Omega").setCorreo(Email.of("caro", "gmail.com")).setNacimiento(LocalDate.of(1983, 11, 15)).invoke();
            CU.crearSocio().setNickname("euge").setNombre("Eugenia").setApellido("Williams").setCorreo(Email.of("e.will", "gmail.com")).setNacimiento(LocalDate.of(1990, 4, 15)).invoke();
            CU.crearSocio().setNickname("guille").setNombre("Guillermo").setApellido("Hector").setCorreo(Email.of("ghector", "gmail.com")).setNacimiento(LocalDate.of(1959, 5, 15)).invoke();
            CU.crearSocio().setNickname("sergiop").setNombre("Sergio").setApellido("Perez").setCorreo(Email.of("sergi", "gmail.uy")).setNacimiento(LocalDate.of(1950, 1, 28)).invoke();
            CU.crearSocio().setNickname("andy").setNombre("Andres").setApellido("Roman").setCorreo(Email.of("chino", "gmail.uy")).setNacimiento(LocalDate.of(1976, 3, 17)).invoke();
            CU.crearSocio().setNickname("tonyp").setNombre("Antonio").setApellido("Paz").setCorreo(Email.of("eltony", "gmail.uy")).setNacimiento(LocalDate.of(1955, 2, 14)).invoke();
            CU.crearSocio().setNickname("m1k4").setNombre("Micaela").setApellido("Lopez").setCorreo(Email.of("mika", "gmail.ar")).setNacimiento(LocalDate.of(1987, 2, 23)).invoke();
            CU.crearSocio().setNickname("charly").setNombre("Carlos").setApellido("Boston").setCorreo(Email.of("emi71", "gmail.uy")).setNacimiento(LocalDate.of(1937, 3, 8)).invoke();

            CAC.crearInstitucion("Instituto Natural", "Clases de gimnasia aerobica, spinning y yoga.", new URL("https://www.inatural.com"));
            CAC.crearInstitucion("Fuerza Bruta", "Gimnasio especializado en el desarrollo de la musculatura.", new URL("https://www.musculos.com/"));
            CAC.crearInstitucion("Telon", "Actividades deportivas para todas la edades.", new URL("https://telon.com.uy"));
            CAC.crearInstitucion("Olympic", "Gimnasia y aparatos.", new URL("https://www.olympic21.com/"));

            CU.crearProfesor()
                    .setNickname("viktor")
                    .setNombre("Victor")
                    .setApellido("Perez")
                    .setCorreo(Email.of("vperez", "fuerza.com"))
                    .setNacimiento(LocalDate.of(1977, 1, 1))
                    .setInstitucion("Fuerza Bruta")
                    .setDescripcion("Victor es un apasionado de los musculos. Sus clases son organizadas en funcion de distintos aparatos y pesas con el objetivo de desarrollar los musculos.")
                    .setBiografia("Victor nacio en Moscow en 1977. En el año 2005 emigro a Uruguay luego de quedar encantado con el pais en un viaje turistico.")
                    .setLink(new URL("https://www.vikgym.com"))
                    .invoke();

            CU.crearProfesor()
                    .setNickname("denis")
                    .setNombre("Denis")
                    .setApellido("Miguel")
                    .setCorreo(Email.of("den80", "fuerza.com"))
                    .setNacimiento(LocalDate.of(1980, 6, 14))
                    .setInstitucion("Telon")
                    .setDescripcion("A Denis le interesan los deportes con pelota, principalmente el voleibol y el hanball.")
                    .setBiografia("Denis fue un jugador de voleibol profesional.")
                    .setLink(new URL("https://www.depecho.com"))
                    .invoke();

            CU.crearProfesor()
                    .setNickname("clazar")
                    .setNombre("Carlos")
                    .setApellido("Lazaro")
                    .setCorreo(Email.of("claz4r0", "hotmail.com"))
                    .setNacimiento(LocalDate.of(1953, 6, 22))
                    .setInstitucion("Instituto Natural")
                    .setDescripcion("Carlos es un profesor muy divertido, cuyas clases de aerobica estan cargadas de energia.")
                    .setBiografia("El interes por la actividad fisica llevo a Carlos a dejar su trabajo en un estudio contable y abrir su propio gimnasio.")
                    .setLink(new URL("https://www.enforma.com"))
                    .invoke();

            CU.crearProfesor()
                    .setNickname("TheBoss")
                    .setNombre("Bruno")
                    .setApellido("Sosa")
                    .setCorreo(Email.of("bruceTheBoss", "gmail.com"))
                    .setNacimiento(LocalDate.of(1949, 9, 23))
                    .setInstitucion("Fuerza Bruta")
                    .setDescripcion("Bruno es un ex-boxeador que busca entrenar futuros campeones.")
                    .setBiografia("Bruno, mejor conocido como Bruce en el ring, compitio como boxeador entre los años 60s y 70s.")
                    .setLink(new URL("https://www.bruce.net"))
                    .invoke();

            CU.crearProfesor()
                    .setNickname("Nelson")
                    .setNombre("Luis")
                    .setApellido("Nelson")
                    .setCorreo(Email.of("nelson", "hotmail.com"))
                    .setNacimiento(LocalDate.of(1998, 1, 1))
                    .setInstitucion("Telon")
                    .setDescripcion("Profesor de natacion, especializado en braza y mariposa.")
                    .setBiografia(null)
                    .setLink(null)
                    .invoke();

            CU.crearProfesor()
                    .setNickname("lale")
                    .setNombre("Laura")
                    .setApellido("Leyes")
                    .setCorreo(Email.of("la_le", "outlook.com"))
                    .setNacimiento(LocalDate.of(1987, 2, 14))
                    .setInstitucion("Telon")
                    .setDescripcion("Luego de una exitosa carrera como jugadora de futbol profesional. Laura dedica sus clases a enseñar tacticas dee futbol.")
                    .setBiografia("Jugadora profesional de futbol desde 2010 a 2020.")
                    .setLink(new URL("https://www.laley.com"))
                    .invoke();

            CU.crearProfesor()
                    .setNickname("prisc")
                    .setNombre("Priscila")
                    .setApellido("Pappo")
                    .setCorreo(Email.of("pripa", "gmail.com"))
                    .setNacimiento(LocalDate.of(1981, 8, 13))
                    .setInstitucion("Olympic")
                    .setDescripcion("Priscila tiene un gran interespor los deportes olimpicos.")
                    .setBiografia(null)
                    .setLink(new URL("https://www.pi314.net"))
                    .invoke();

            CU.crearProfesor()
                    .setNickname("dagost")
                    .setNombre("Diana")
                    .setApellido("Agostini")
                    .setCorreo(Email.of("d_1940_ago", "gmail.com"))
                    .setNacimiento(LocalDate.of(1940, 3, 5))
                    .setInstitucion("Olympic")
                    .setDescripcion("Profesora dedicada y exigente. No acepta un no puedo como respuesta.")
                    .setBiografia(null)
                    .setLink(new URL("https://www.dygym.com"))
                    .invoke();

            CU.crearProfesor()
                    .setNickname("aldo")
                    .setNombre("Aldo")
                    .setApellido("Vivaldi")
                    .setCorreo(Email.of("aldo", "outlook.com"))
                    .setNacimiento(LocalDate.of(1952, 7, 17))
                    .setInstitucion("Telon")
                    .setDescripcion("Dada su gran estatura, aldo siempre jugo al basquetbol. Ahora se dedica a enseñarlo.")
                    .setBiografia(null)
                    .setLink(new URL("https://www.sportsaldo.net"))
                    .invoke();

            CAC.crearActividad().setInstitucion("Fuerza Bruta").setNombre("Aparatos y pesas").setDescripcion("Clases de aparatos, pesas y calistenia.").setDuracion(Duration.ofMinutes(90)).setCosto(550).setRegistro(LocalDate.of(2021, 3, 31)).invoke();
            CAC.crearActividad().setInstitucion("Telon").setNombre("Voleibol").setDescripcion("Voleibol en todas sus formas.").setDuracion(Duration.ofMinutes(120)).setCosto(750).setRegistro(LocalDate.of(2021, 4, 20)).invoke();
            CAC.crearActividad().setInstitucion("Instituto Natural").setNombre("Aerobica").setDescripcion("Para cuidar el aparato cardiovascular.").setDuracion(Duration.ofMinutes(110)).setCosto(800).setRegistro(LocalDate.of(2021, 5, 30)).invoke();
            CAC.crearActividad().setInstitucion("Fuerza Bruta").setNombre("Kickboxing").setDescripcion("En busca del nuevo campeon de boxeo.").setDuracion(Duration.ofMinutes(100)).setCosto(980).setRegistro(LocalDate.of(2021, 6, 7)).invoke();
            CAC.crearActividad().setInstitucion("Telon").setNombre("Atletismo").setDescripcion("100m, 200m, postas y carreras con obstaculos.").setDuracion(Duration.ofMinutes(150)).setCosto(500).setRegistro(LocalDate.of(2021, 7, 8)).invoke();
            CAC.crearActividad().setInstitucion("Telon").setNombre("Basquetbol").setDescripcion("Espectaculo conmemorando los 30 años de Violeta").setDuracion(Duration.ofMinutes(80)).setCosto(450).setRegistro(LocalDate.of(2021, 7, 31)).invoke();

            Set<String> p1 = new HashSet<>();
            p1.add("viktor");
            CAC.crearClase().setNombreActividad("Aparatos y pesas").setNombre("Calistenia").setInicio(LocalDateTime.of(2021, 4, 15, 15, 30)).setNicknameProfesores(p1).setCantMin(1).setCantMax(5).setAcceso(new URL("https://www.musculos.com/Calistenia")).setFechaRegistro(LocalDate.of(2021, 3, 31)).invoke();
            CAC.crearClase().setNombreActividad("Aparatos y pesas").setNombre("Peso libre").setInicio(LocalDateTime.of(2021, 5, 1, 17, 00)).setNicknameProfesores(p1).setCantMin(1).setCantMax(5).setAcceso(new URL("https://www.musculos.com/pesolibre")).setFechaRegistro(LocalDate.of(2021, 3, 31)).invoke();
            CAC.crearClase().setNombreActividad("Aparatos y pesas").setNombre("Aparatos").setInicio(LocalDateTime.of(2021, 6, 1, 18, 00)).setNicknameProfesores(p1).setCantMin(1).setCantMax(7).setAcceso(new URL("https://www.musculos.com/aparatos")).setFechaRegistro(LocalDate.of(2021, 3, 31)).invoke();

            Set<String> p2 = new HashSet<>();
            p2.add("denis");
            CAC.crearClase().setNombreActividad("Voleibol").setNombre("Voleibol").setInicio(LocalDateTime.of(2021, 6, 10, 19, 00)).setNicknameProfesores(p2).setCantMin(10).setCantMax(21).setAcceso(new URL("https://telon.com.uy/voley")).setFechaRegistro(LocalDate.of(2021, 4, 20)).invoke();

            Set<String> p3 = new HashSet<>();
            p3.add("Nelson");
            CAC.crearClase().setNombreActividad("Voleibol").setNombre("Braza").setInicio(LocalDateTime.of(2021, 7, 10, 20, 00)).setNicknameProfesores(p3).setCantMin(2).setCantMax(6).setAcceso(new URL("https://telon.com.uy/natacionB")).setFechaRegistro(LocalDate.of(2021, 4, 20)).invoke();
            CAC.crearClase().setNombreActividad("Voleibol").setNombre("Mariposa").setInicio(LocalDateTime.of(2021, 8, 10, 17, 45)).setNicknameProfesores(p3).setCantMin(2).setCantMax(6).setAcceso(new URL("https://telon.com.uy/natacionM")).setFechaRegistro(LocalDate.of(2021, 4, 20)).invoke();

            Set<String> p4 = new HashSet<>();
            p4.add("clazar");
            CAC.crearClase().setNombreActividad("Aerobica").setNombre("Aerobica niños").setInicio(LocalDateTime.of(2021, 8, 15, 16, 30)).setNicknameProfesores(p4).setCantMin(5).setCantMax(10).setAcceso(new URL("https://www.inatural.com/aeroni")).setFechaRegistro(LocalDate.of(2021, 5, 30)).invoke();
            CAC.crearClase().setNombreActividad("Aerobica").setNombre("Aerobica adulto 5or").setInicio(LocalDateTime.of(2021, 8, 31, 19, 30)).setNicknameProfesores(p4).setCantMin(5).setCantMax(12).setAcceso(new URL("https://www.inatural.com/aeroam")).setFechaRegistro(LocalDate.of(2021, 5, 30)).invoke();
            CAC.crearClase().setNombreActividad("Aerobica").setNombre("Aerobica").setInicio(LocalDateTime.of(2021, 9, 30, 20, 00)).setNicknameProfesores(p4).setCantMin(5).setCantMax(20).setAcceso(new URL("https://www.inatural.com/aerogral")).setFechaRegistro(LocalDate.of(2021, 5, 30)).invoke();

            Set<String> p5 = new HashSet<>();
            p5.add("clazar");
            CAC.crearClase().setNombreActividad("Kickboxing").setNombre("Boxeo I").setInicio(LocalDateTime.of(2021, 9, 1, 19, 30)).setNicknameProfesores(p5).setCantMin(1).setCantMax(4).setAcceso(new URL("https://www.musculos.com/boxeo1")).setFechaRegistro(LocalDate.of(2021, 6, 7)).invoke();
            CAC.crearClase().setNombreActividad("Kickboxing").setNombre("Boxeo II").setInicio(LocalDateTime.of(2021, 9, 30, 17, 00)).setNicknameProfesores(p5).setCantMin(2).setCantMax(2).setAcceso(new URL("https://www.musculos.com/boxeo2")).setFechaRegistro(LocalDate.of(2021, 6, 7)).invoke();
            CAC.crearClase().setNombreActividad("Kickboxing").setNombre("Musculos para boxeo").setInicio(LocalDateTime.of(2021, 10, 15, 20, 00)).setNicknameProfesores(p1).setCantMin(1).setCantMax(5).setAcceso(new URL("https://www.musculos.com/muscbox")).setFechaRegistro(LocalDate.of(2021, 6, 7)).invoke();

            Set<String> p6 = new HashSet<>();
            p6.add("lale");
            CAC.crearClase().setNombreActividad("Atletismo").setNombre("100 M").setInicio(LocalDateTime.of(2021, 9, 25, 19, 00)).setNicknameProfesores(p6).setCantMin(3).setCantMax(10).setAcceso(new URL("https://telon.com.uy/100m")).setFechaRegistro(LocalDate.of(2021, 7, 8)).invoke();
            CAC.crearClase().setNombreActividad("Atletismo").setNombre("200 M").setInicio(LocalDateTime.of(2021, 10, 25, 18, 30)).setNicknameProfesores(p6).setCantMin(3).setCantMax(10).setAcceso(new URL("https://telon.com.uy/200m")).setFechaRegistro(LocalDate.of(2021, 7, 8)).invoke();
            CAC.crearClase().setNombreActividad("Atletismo").setNombre("Posta").setInicio(LocalDateTime.of(2021, 11, 25, 17, 45)).setNicknameProfesores(p6).setCantMin(8).setCantMax(16).setAcceso(new URL("https://telon.com.uy/posta")).setFechaRegistro(LocalDate.of(2021, 7, 8)).invoke();

            Set<String> p7 = new HashSet<>();
            p7.add("aldo");
            CAC.crearClase().setNombreActividad("Basquetbol").setNombre("Basquet I").setInicio(LocalDateTime.of(2021, 9, 1, 21, 00)).setNicknameProfesores(p7).setCantMin(10).setCantMax(15).setAcceso(new URL("https://telon.com.uy/bball1")).setFechaRegistro(LocalDate.of(2021, 7, 31)).invoke();
            CAC.crearClase().setNombreActividad("Basquetbol").setNombre("Basquet II").setInicio(LocalDateTime.of(2021, 9, 10, 21, 00)).setNicknameProfesores(p7).setCantMin(10).setCantMax(15).setAcceso(new URL("https://telon.com.uy/bball2")).setFechaRegistro(LocalDate.of(2021, 7, 31)).invoke();

            /* IMPORTANTE Quedó sin la r el nombre... mejor cambiarlo aca que en todo el codigo*/
            CAC.registarseSinCuponera("caro", "Calistenia", LocalDate.of(2021, 4, 9));
            CAC.registarseSinCuponera("sergiop", "Calistenia", LocalDate.of(2021, 4, 10));
            CAC.registarseSinCuponera("andy", "Calistenia", LocalDate.of(2021, 4, 12));
            CAC.registarseSinCuponera("andy", "Peso libre", LocalDate.of(2021, 4, 15));
            CAC.registarseSinCuponera("tonyp", "Peso libre", LocalDate.of(2021, 4, 20));
            CAC.registarseSinCuponera("caro", "Peso libre", LocalDate.of(2021, 4, 25));
            CAC.registarseSinCuponera("m1k4", "Peso libre", LocalDate.of(2021, 4, 28));
            CAC.registarseSinCuponera("charly", "Aparatos", LocalDate.of(2021, 4, 16));
            CAC.registarseSinCuponera("caro", "Aparatos", LocalDate.of(2021, 5, 15));
            CAC.registarseSinCuponera("m1k4", "Aparatos", LocalDate.of(2021, 5, 20));
            CAC.registarseSinCuponera("Emi71", "Voleibol", LocalDate.of(2021, 5, 5));
            CAC.registarseSinCuponera("euge", "Voleibol", LocalDate.of(2021, 5, 10));
            CAC.registarseSinCuponera("sergiop", "Voleibol", LocalDate.of(2021, 5, 15));
            CAC.registarseSinCuponera("tonyp", "Voleibol", LocalDate.of(2021, 5, 20));
            CAC.registarseSinCuponera("guille", "Braza", LocalDate.of(2021, 6, 8));
            CAC.registarseSinCuponera("euge", "Braza", LocalDate.of(2021, 6, 13));
            CAC.registarseSinCuponera("m1k4", "Braza", LocalDate.of(2021, 6, 25));
            CAC.registarseSinCuponera("charly", "Mariposa", LocalDate.of(2021, 7, 5));
            CAC.registarseSinCuponera("sergiop", "Mariposa", LocalDate.of(2021, 7, 11));
            CAC.registarseSinCuponera("andy", "Mariposa", LocalDate.of(2021, 7, 18));
            CAC.registarseSinCuponera("m1k4", "Aerobica niños", LocalDate.of(2021, 7, 19));
            CAC.registarseSinCuponera("Emi71", "Aerobica adulto 5or", LocalDate.of(2021, 8, 17));
            CAC.registarseSinCuponera("guille", "Aerobica adulto 5or", LocalDate.of(2021, 8, 20));
            CAC.registarseSinCuponera("andy", "Aerobica adulto 5or", LocalDate.of(2021, 8, 23));
            CAC.registarseSinCuponera("caro", "Aerobica", LocalDate.of(2021, 8, 15));
            CAC.registarseSinCuponera("euge", "Aerobica", LocalDate.of(2021, 8, 26));
            CAC.registarseSinCuponera("andy", "Boxeo I", LocalDate.of(2021, 7, 19));
            CAC.registarseSinCuponera("tonyp", "Boxeo I", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("m1k4", "Boxeo I", LocalDate.of(2021, 8, 24));
            CAC.registarseSinCuponera("sergiop", "Boxeo II", LocalDate.of(2021, 8, 1));
            CAC.registarseSinCuponera("guille", "Boxeo II", LocalDate.of(2021, 8, 30));
            CAC.registarseSinCuponera("Emi71", "Musculos para boxeo", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("caro", "Musculos para boxeo", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("euge", "Musculos para boxeo", LocalDate.of(2021, 9, 1));
            CAC.registarseSinCuponera("sergiop", "Musculos para boxeo", LocalDate.of(2021, 9, 5));
            CAC.registarseSinCuponera("guille", "100 M", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("charly", "100 M", LocalDate.of(2021, 9, 3));
            CAC.registarseSinCuponera("Emi71", "200 M", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("charly", "200 M", LocalDate.of(2021, 9, 6));
            CAC.registarseSinCuponera("caro", "Posta", LocalDate.of(2021, 9, 1));
            CAC.registarseSinCuponera("sergiop", "Basquet I", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("Emi71", "Basquet I", LocalDate.of(2021, 8, 20));
            CAC.registarseSinCuponera("tonyp", "Basquet I", LocalDate.of(2021, 8, 31));
            CAC.registarseSinCuponera("andy", "Basquet II", LocalDate.of(2021, 8, 16));
            CAC.registarseSinCuponera("tonyp", "Basquet II", LocalDate.of(2021, 8, 20));
            CAC.registarseSinCuponera("caro", "Basquet II", LocalDate.of(2021, 9, 2));

            CC.crearCuponera().setNombre("Pelota").setDescripcion("Deportes con pelota.").setInicio(LocalDate.of(2021, 5, 1)).setFin(LocalDate.of(2021, 7, 31)).setDescuento(20).setFechaRegistro(LocalDate.of(2021, 4, 30)).invoke();
            CC.crearCuponera().setNombre("Gimnasia").setDescripcion("Aerobica y aparatos.").setInicio(LocalDate.of(2021, 8, 1)).setFin(LocalDate.of(2021, 9, 30)).setDescuento(30).setFechaRegistro(LocalDate.of(2021, 7, 15)).invoke();
            CC.crearCuponera().setNombre("Musculos").setDescripcion("Pesas.").setInicio(LocalDate.of(2021, 8, 15)).setFin(LocalDate.of(2021, 11, 15)).setDescuento(10).setFechaRegistro(LocalDate.of(2021, 8, 1)).invoke();

            CC.agregarACuponera("Pelota", "Voleibol", 7);
            CC.agregarACuponera("Pelota", "Basquetbol", 18);
            CC.agregarACuponera("Gimnasia", "Aerobica", 2);
            CC.agregarACuponera("Gimnasia", "Aparatos y pesas", 8);
            CC.agregarACuponera("Musculos", "Kickboxing", 11);
            CC.agregarACuponera("Musculos", "Aparatos y pesas", 12);
        } catch (Exception e) {
            e.printStackTrace();
        }

        callback.finished();
    }
}
