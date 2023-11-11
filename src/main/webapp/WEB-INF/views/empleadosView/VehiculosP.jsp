<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Vehiculos</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <link href="<spring:url value='resources/empleadoview/css/styles.css' />" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/EmpleadoDASH/inicio">Saravias Rent-a-Car</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/EmpleadoCLI/listcli">Clientes</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/EmpleadoPRO/listpro">Propietarios</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/EmpleadoVEH/listveh">Vehiculos</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/EmpleadoVEN/listven">Ventas</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/EmpleadoARQ/listarq">Alquiler</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <div class="row">
        <!-- Columna izquierda (6 columnas) para la imagen del usuario -->
        <div class="col-6">
            <img src="https://picsum.photos/400/400?random" class="img-fluid" alt="Imagen de perfil">
        </div>
        <!-- Columna derecha (6 columnas) para la información del usuario -->
        <div class="col-6">
            <h2>Información del Vehiculo</h2>
            <p><strong>ID Vehiculo: </strong>${vehiculos.vehiculoId}</p>
            <p><strong>Marca: </strong> ${vehiculos.marcaVehiculo}</p>
            <p><strong>Modelo: </strong> ${vehiculos.modeloVehiculo}</p>
            <p><strong>Año: </strong>${vehiculos.añoVehiculo}</p>
            <p><strong>Tipo Vehiculo: </strong> ${vehiculos.tipoVehiculo}</p>
            <p><strong>Color: </strong> ${vehiculos.colorVehiculo}</p>
            <p><strong>Placa: </strong> ${vehiculos.placaVehiculo}</p>
            <p><strong>Motor: </strong> ${vehiculos.motorVehiculo}</p>
            <p><strong>Consumo: </strong> ${vehiculos.consumoVehiculo}</p>
            <p><strong>Propietario: </strong> ${vehiculos.propietariosByPropietarioVehiculo.propietarioId}</p>
            <p><strong>Fecha creacion: </strong> ${vehiculos.fechaCreacion}</p>
            <p><strong>Estado de empleado: </strong> ${vehiculos.estadoVehiculo}</p>

            <h2>Información de propietario</h2>
            <p><strong>ID Propietario: </strong>${propietariovehiculo.propietarioId}</p>
            <p><strong>Usuario: </strong>${propietariovehiculo.usuariosByUsuarioPropietario.usuarioId}</p>
            <p><strong>Nombres: </strong> ${propietariovehiculo.nombresProp} ${propietariovehiculo.apellidosProp}</p>
            <p><strong>Telefono: </strong> ${propietariovehiculo.telefonoProp}</p>
            <p><strong>DUI: </strong> ${propietariovehiculo.duiProp}</p>
            <p><strong>Direccion: </strong> ${propietariovehiculo.direccionProp}</p>
            <p><strong>Fecha Creacion: </strong> ${propietariovehiculo.fechaCreacionProp}</p>
            <p><strong>Gestor: </strong> ${propietariovehiculo.empleadosByGestorId.empleadoId}</p>
            <p><strong>Estado de usuario: </strong> ${propietariovehiculo.estadoProp}</p>

        </div>
    </div>
</div>

<!-- Agrega el script de Bootstrap si es necesario -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
