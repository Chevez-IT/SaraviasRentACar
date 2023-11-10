<%--
  Created by IntelliJ IDEA.
  User: cesar
  Date: 8/11/2023
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Nuevo propietario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script>
        function validarFormulario() {
            var nombresProp = document.getElementById('nombresProp').value;
            var apellidosProp = document.getElementById('apellidosProp').value;
            var telefonoProp = document.getElementById('telefonoProp').value;
            var duiProp = document.getElementById('duiProp').value;
            var direccionProp = document.getElementById('direccionProp').value;

            var nombresError = document.getElementById('nombresError');
            var apellidosError = document.getElementById('apellidosError');
            var telefonoError = document.getElementById('telefonoError');
            var duiError = document.getElementById('duiError');
            var direccionError = document.getElementById('direccionError');

            var nombresRegex = /^[a-zA-Z ]+$/;
            var apellidosRegex = /^[a-zA-Z ]+$/;
            var telefonoRegex = /^[0-9]{8}$/;
            var duiRegex = /^[0-9]{8}-[0-9]$/;

            // Validación de nombres
            if (nombresProp.trim() === '') {
                nombresError.innerHTML = 'El campo de nombres no puede estar vacío.';
                return false;
            } else if (!nombresRegex.test(nombresProp)) {
                nombresError.innerHTML = 'Solo se permiten letras y espacios en el campo de nombres.';
                return false;
            } else {
                nombresError.innerHTML = '';
            }

            // Validación de apellidos
            if (apellidosProp.trim() === '') {
                apellidosError.innerHTML = 'El campo de apellidos no puede estar vacío.';
                return false;
            } else if (!apellidosRegex.test(apellidosProp)) {
                apellidosError.innerHTML = 'Solo se permiten letras y espacios en el campo de apellidos.';
                return false;
            } else {
                apellidosError.innerHTML = '';
            }

            // Validación de teléfono
            if (telefonoProp.trim() === '') {
                telefonoError.innerHTML = 'El campo de teléfono no puede estar vacío.';
                return false;
            } else if (!telefonoRegex.test(telefonoProp)) {
                telefonoError.innerHTML = 'El formato del teléfono debe ser 00000000.';
                return false;
            } else {
                telefonoError.innerHTML = '';
            }

            // Validación de DUI
            if (duiProp.trim() === '') {
                duiError.innerHTML = 'El campo de DUI no puede estar vacío.';
                return false;
            } else if (!duiRegex.test(duiProp)) {
                duiError.innerHTML = 'El formato del DUI debe ser 00000000-0.';
                return false;
            } else {
                duiError.innerHTML = '';
            }

            // Validación de dirección (no se especifica una validación específica en el código proporcionado)
            if (direccionProp.trim() === '') {
                direccionError.innerHTML = 'El campo de dirección no puede estar vacío.';
                return false;
            } else {
                direccionError.innerHTML = '';
            }

            return true;
        }
    </script>
    <style>
        body {
            background-image: url("${pageContext.request.contextPath}/resources/background2Log.jpg");
            color: white;
        }
        label {
            color: white;
        }
        h3 {
            color: white;
        }
        .error-message {
            color: red;
        }
        /* Reglas de estilo para centrar el formulario */
        .center-container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .btn-save {
            margin-top: 10px;
        }
    </style>
</head>

<body class="center-container">
<div class="col-md-7">
    <div class="row">
        <h3>Ingresa tus datos para registrarte como propietario, sus credenciales seran enviadas a su correo electrónico</h3>
    </div>
    <f:form method="POST" action="createProp" modelAttribute="propietario" onsubmit="return validarFormulario()">
        <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>

        <div class="form-group">
            <label for="nombresProp">Nombres:</label>
            <div class="input-group">
                <f:input path="nombresProp" id="nombresProp" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="nombresError" class="error-message"></small>
        </div>
        <div class="form-group">
            <label for="apellidosProp">Apellidos:</label>
            <div class="input-group">
                <f:input path="apellidosProp" id="apellidosProp" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="apellidosError" class="error-message"></small>
        </div>
        <div class="form-group">
            <label for="telefonoProp">Teléfono:</label>
            <div class="input-group">
                <f:input path="telefonoProp" id="telefonoProp" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="telefonoError" class="error-message"></small>
        </div>
        <div class="form-group">
            <label for="duiProp">DUI:</label>
            <div class="input-group">
                <f:input path="duiProp" id="duiProp" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="duiError" class="error-message"></small>
        </div>
        <div class="form-group">
            <label for="direccionProp">Dirección de domicilio:</label>
            <div class="input-group">
                <f:input path="direccionProp" id="direccionProp" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="direccionError" class="error-message"></small>
        </div>
        <div class="form-group text-center">
            <f:button class="btn btn-info btn-save">Guardar</f:button>
        </div>
    </f:form>
</div>
</body>
</html>



