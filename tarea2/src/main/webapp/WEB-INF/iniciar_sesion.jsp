<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
        <meta charset="UTF-8">
        <c:if test="${successful_login eq true}">
            <meta http-equiv="refresh" content="3; URL=<c:url value="/"/>">
        </c:if>
        <title>Entrenamos.uy</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="styles/iniciar_sesion.css">
    </head>
	<body class="d-flex flex-column text-center justify-content-center py-12">
        <c:choose>
            <c:when test="${successful_login eq true}">
                <div class="form-login">
                    <h1 class="h3 mb-3 fw-normal">Inicio exitoso</h1>
                    <span class="mb-3">Sera direccionado automáticamente a la pagina principal en un momento</span>
                    <a class="btn btn-primary" href="<c:url value="/"/>">Pagina principal</a>
                </div>
            </c:when>
            <c:otherwise>
                <form class="d-flex flex-column form-login" method="post">
                    <h1 class="h3 mb-3 fw-normal">Inicio de sesión</h1>
                    <input class="form-control mb-3" placeholder="nickname" name="nick">
                    <input class="form-control mb-3" placeholder="contraseña" name="pass" type="password">
                    <c:if test="${attempted_login}">
                        <c:if test="${reason == 'nickname'}">
                            <span class="text-danger mb-3">Nickname invalido</span>
                        </c:if>
                        <c:if test="${reason == 'password'}">
                            <span class="text-danger mb-3">Contraseña invalida</span>
                        </c:if>
                    </c:if>
                    <input class="w-100 btn btn-primary" type="submit" value="Iniciar sesión">
                </form>
            </c:otherwise>
        </c:choose>
	</body>
</html>
