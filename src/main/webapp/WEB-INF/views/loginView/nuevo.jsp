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
<html>
<head>
    <title>Iniciar Sesión</title>
    <!-- Agregar enlaces a los archivos CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h2 class="text-center">Iniciar Sesión</h2>
            <form action="<c:url value='/Login/sendEmail' />" method="post" class="mt-4">
                <div class="form-group">
                    <label for="email">Correo Electronico:</label>
                    <input type="text" id="email" name="email" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión</button>
            </form>
            <a class="btn btn-primary btn-md" href="<s:url value="/Login"/>">Atras</a>
        </div>
    </div>
</div>

<!-- Agregar el enlace al archivo JavaScript de Bootstrap y jQuery (opcional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>