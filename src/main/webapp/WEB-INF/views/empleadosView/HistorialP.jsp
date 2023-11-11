<%--
  Created by IntelliJ IDEA.
  User: Angie
  Date: 10/11/2023
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Historial Propietario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        /* Estilo para la tabla */
        #tabla {
            margin-top: 20px;
        }
    </style>
</head>
<body>

<jsp:include page="/WEB-INF/views/empleadosView/navbar.jsp"/>
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

