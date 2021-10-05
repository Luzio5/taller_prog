<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="d-flex flex-row justify-content-end bg-dark text-white p-3">
    <form class="col-6 mx-3" action="search" method="post">
        <input class="form-control" type="search" placeholder="buscar" name="keyword">
    </form>
    <c:choose>
        <c:when test="${usuario == null}">
            <a class="btn btn-outline-light mx-3" href="iniciar_sesion">Iniciar sesión</a>
            <a class="btn btn-outline-light mx-3" href="alta_usuario">Registrarse</a>
        </c:when>
        <c:otherwise>
            <span>${usuario.nombre} ${usuario.apellido}</span>
        </c:otherwise>
    </c:choose>
</header>
