<%--
  Created by IntelliJ IDEA.
  User: cesar
  Date: 8/11/2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Iniciar Sesión</title>
    <!-- Agregar enlaces a los archivos CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
</head>
<body class="d-flex align-items-center justify-content-center" style="min-height: 100vh;">
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h2 class="text-center">Se le enviará un código al correo para comprobar sus identidad</h2>
            <form action="<c:url value='/Login/cambiarComprobación' />" method="post" onsubmit="return validarFormulario()" class="mt-4">
                <div class="form-group">
                    <label for="email">Correo Electrónico:</label>
                    <input type="text" id="email" name="email" class="form-control" required>
                    <small id="emailError" style="color: red;"></small>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Enviar</button>
            </form>
            <form action="<c:url value='/Login' />" method="get" class="mt-4">
                <button type="submit" class="btn btn-success btn-sm btn-block">Atrás</button>
            </form>
        </div>
    </div>
</div>

<!-- Agregar el enlace al archivo JavaScript de Bootstrap y jQuery (opcional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    function validarFormulario() {
        var email = document.getElementById('email').value;
        var emailError = document.getElementById('emailError');

        // Utilizar una expresión regular para validar el formato del correo electrónico
        var emailRegex = /^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$/;

        if (!emailRegex.test(email)) {
            emailError.innerHTML = 'El formato del correo electrónico no es válido.';
            return false;
        } else {
            emailError.innerHTML = '';
            return true;
        }
    }
</script>
</body>
</html>
