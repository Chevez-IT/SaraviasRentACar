<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión</title>

    <style>
        body {
            background-image: url("${pageContext.request.contextPath}/resources/background2Log.jpg");
        }
         label {
             color: white;
         }
         h2 {
             color: white;
         }


    </style>
    <!-- Agregar enlaces a los archivos CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row d-flex align-items-center justify-content-center" style="margin-top: 100px;">
        <div class="col-md-6">
            <h2 class="text-center">Iniciar Sesión</h2>
            <form action="<c:url value='/Login/log' />" method="post" class="mt-4">
                <div class="form-group">
                    <label for="username">Nombre de Usuario:</label>
                    <input type="text" id="username" name="username" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión</button>
            </form>
            <form action="<c:url value='/Login/email' />" method="get" class="mt-4"><button type="submit" class="btn btn-success btn-block">Registrate</button></form>
            <form action="<c:url value='/Login/emailProp' />" method="get" class="mt-4"><button type="submit" class="btn btn-success btn-block">¿Quieres ofertar un vehiculo?</button></form>
            <form action="<c:url value='/Login/olvido' />" method="get" class="mt-4"><button type="submit" class="btn btn-danger btn-block">¿Olvidaste tu contraseña?</button></form>
        </div>
    </div>
</div>

<!-- Agregar el enlace al archivo JavaScript de Bootstrap y jQuery (opcional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>