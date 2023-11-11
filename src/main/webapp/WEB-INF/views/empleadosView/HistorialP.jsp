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
    <title>Historial Propietario</title>
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
<div class="container">
    <h3 class="mt-4">Historial de Ventas</h3>
    <table class="table table-striped table-bordered table-hover mt-4" id="tabla">
        <thead>
        <tr>
            <th>Id Venta</th>
            <th>Id Vehiculo</th>
            <th>Titulo</th>
            <th>Descripcion</th>
            <th>Precio</th>
            <th>Comprador</th>
            <th>Fecha Compra</th>
            <th>Estado</th>
            <th>Gestor</th>
            <th>Fecha creacion</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ventasvehiculo}" var="ventas">
            <tr>
                <td>${ventas.ventaId}</td>
                <td>${ventas.vehiculosByVehiculoId.vehiculoId}</td>
                <td>${ventas.tituloVenta}</td>
                <td>${ventas.descripcionVenta}</td>
                <td>${ventas.precioVenta}</td>
                <td>${ventas.clientesByCompradorVenta.clienteId}</td>
                <td>${ventas.fechaCompraVenta}</td>
                <td>${ventas.estadoVenta}</td>
                <td>${ventas.empleadosByGestorId.empleadoId}</td>
                <td>${ventas.fechaCreacionVenta}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="container">
    <h3 class="mt-4">Historial de Alquiler</h3>
    <table class="table table-striped table-bordered table-hover mt-4" id="2">
        <thead>
        <tr>
            <th>Id Alquiler</th>
            <th>Id Vehiculo</th>
            <th>Titulo</th>
            <th>Descripcion</th>
            <th>Precio</th>
            <th>Fecha de inicio</th>
            <th>Fecha de finalizacion</th>
            <th>Fecha creacion</th>
            <th>Gestor</th>
            <th>Estado</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${arquilervehiculo}" var="arquiler">
            <tr>
                <td>${arquiler.arquilerId}</td>
                <td>${arquiler.vehiculosByVehiculoId.vehiculoId}</td>
                <td>${arquiler.tituloArquiler}</td>
                <td>${arquiler.descripcionArquiler}</td>
                <td>${arquiler.precioArquiler}</td>
                <td>${arquiler.fechaInicio}</td>
                <td>${arquiler.fechaFinalizacion}</td>
                <td>${arquiler.fechaCreacion}</td>
                <td>${arquiler.empleadosByGestorId.empleadoId}</td>
                <td>${arquiler.estadoArquiler}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>




<div class="container">
<h3 class="mt-4">Historial de Vehiculos</h3>
<table class="table table-striped table-bordered table-hover mt-4" id="3">
    <thead>
    <tr>
        <th>Id Vehiculo</th>
        <th>Estado:</th>
        <th>Marca:</th>
        <th>Modelo:</th>
        <th>Año:</th>
        <th>Tipo Vehiculo:</th>
        <th>Color:</th>
        <th>Placa:</th>
        <th>Propietario:</th>
        <th>Motor:</th>
        <th>Consumo Vehiculo</th>
        <th>Fecha Creacion:</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach items="${propietariovehiculo}" var="vehiculo">
        <tr>
            <td>${vehiculo.vehiculoId}</td>
            <td>${vehiculo.estadoVehiculo}</td>
            <td>${vehiculo.marcaVehiculo}</td>
            <td>${vehiculo.modeloVehiculo}</td>
            <td>${vehiculo.añoVehiculo}</td>
            <td>${vehiculo.tipoVehiculo}</td>
            <td>${vehiculo.colorVehiculo}</td>
            <td>${vehiculo.placaVehiculo}</td>
            <td>${vehiculo.propietariosByPropietarioVehiculo.propietarioId}</td>
            <td>${vehiculo.motorVehiculo}</td>
            <td>${vehiculo.consumoVehiculo}</td>
            <td>${vehiculo.fechaCreacion}</td>


        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>

