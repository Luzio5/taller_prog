<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="com.entrenamosuy.web.Facades" %>
<%@ page import="com.entrenamosuy.core.data.DataInstitucion" %>
<%@ page import="com.entrenamosuy.core.data.DataActividad" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/sidebar.css">
    </head>
	</head>
	<body class="d-flex flex-column">
        <jsp:include page="/WEB-INF/templates/header.jsp"/>
        <%
            String institucionNombre = request.getParameter("institucion");
            DataInstitucion institucion = Facades
                .getFacades()
                .getFacadeInstitucion()
                .getDataInstitucion(institucionNombre);

            String nombre = institucion.getNombre();
            String descripcion = institucion.getDescripcion();
            String url = institucion.getUrl().toString();
            Set<String> actividadesOfrecidas = institucion.getActividadesOfrecidas()
                .stream()
                .map(DataActividad::getNombre)
                .collect(Collectors.toSet());

            request.setAttribute("nombre", nombre);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("url", url);
            request.setAttribute("actividadesOfrecidas", actividadesOfrecidas);
        %>
        <div class="d-flex flex-row">
            <jsp:include page="/WEB-INF/templates/aside.jsp"/>
            <main class="d-flex flex-column p-3">
                <section class="d-flex flex-column">
                    <h1 class="fs-1 fw-bold p-3">${nombre}</h1>
                    <p class="fs-6">${descripcion}</p>
                    <a class="fs-6" href="${url}">url</a>
                </section>
            </main>
        </div>
	</body>
</html>
