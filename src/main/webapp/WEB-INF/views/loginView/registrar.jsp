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
    <title>Nuevo Cliente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script>
        function validarFormulario() {
            var nombresCli = document.getElementById('nombresCli').value;
            var apellidosCli = document.getElementById('apellidosCli').value;
            var telefonoCli = document.getElementById('telefonoCli').value;
            var duiCli = document.getElementById('duiCli').value;
            var direccionCli = document.getElementById('direccionCli').value;

            var nombresError = document.getElementById('nombresError');
            var apellidosError = document.getElementById('apellidosError');
            var telefonoError = document.getElementById('telefonoError');
            var duiError = document.getElementById('duiError');
            var direccionError = document.getElementById('direccionError');

            var nombresRegex = /^[a-zA-Z ]+$/;
            var apellidosRegex = /^[a-zA-Z ]+$/;

            if (!nombresRegex.test(nombresCli)) {
                nombresError.innerHTML = 'Solo se permiten letras y espacios en el campo de nombres.';
                return false;
            } else {
                nombresError.innerHTML = '';
            }

            if (!apellidosRegex.test(apellidosCli)) {
                apellidosError.innerHTML = 'Solo se permiten letras y espacios en el campo de apellidos.';
                return false;
            } else {
                apellidosError.innerHTML = '';
            }

            if (nombresCli.trim() === '') {
                apellidosError.innerHTML = 'El campo de nombres no puede estar vacío.';
                return false;
            } else {
                apellidosError.innerHTML = '';
            }

            if (apellidosCli.trim() === '') {
                apellidosError.innerHTML = 'El campo de apellidos no puede estar vacío.';
                return false;
            } else {
                apellidosError.innerHTML = '';
            }

            var telefonoRegex = /^[0-9]{8}$/;
            if (!telefonoRegex.test(telefonoCli)) {
                telefonoError.innerHTML = 'El formato del teléfono debe ser 00000000.';
                return false;
            } else {
                telefonoError.innerHTML = '';
            }

            var duiRegex = /^\d{8}-\w$/;

            if (!duiRegex.test(duiCli)) {
                duiError.innerHTML = 'El formato del DUI debe de ser 00000000-0.';
                return false;
            } else {
                duiError.innerHTML = '';
            }

            if (direccionCli.trim() === '') {
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
<body>
<body class="center-container">
<div class="col-md-7">
    <div class="row">
        <h3>Ingresa tus datos, tus credenciales seran enviadas a tu correo electrónico.</h3>
    </div>
    <f:form method="POST" action="create" modelAttribute="cliente" onsubmit="return validarFormulario()">
        <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campos requeridos</strong></div>

        <div class="form-group">
            <label for="nombresCli">Nombres:</label>
            <div class="input-group">
                <f:input path="nombresCli" id="nombresCli" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="nombresError" class="error-message"></small>
        </div>
        <div class="form-group">
            <label for="apellidosCli">Apellidos:</label>
            <div class="input-group">
                <f:input path="apellidosCli" id="apellidosCli" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="apellidosError" class="error-message"></small>
        </div>
        <div class="form-group">
            <label for="telefonoCli">Teléfono:</label>
            <div class="input-group">
                <f:input path="telefonoCli" id="telefonoCli" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="telefonoError" class="error-message"></small>
        </div>
        <div class="form-group">
            <label for="duiCli">DUI:</label>
            <div class="input-group">
                <f:input path="duiCli" id="duiCli" cssClass="form-control" required="true"/>
                <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
            </div>
            <small id="duiError" class="error-message"></small>
        </div>
        <div class="form-group">
            <label for="direccionCli">Dirección de domicilio:</label>
            <div class="input-group">
                <f:input path="direccionCli" id="direccionCli" cssClass="form-control" required="true"/>
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

