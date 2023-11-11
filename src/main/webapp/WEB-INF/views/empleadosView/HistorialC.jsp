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
    <title>Historial Cliente</title>
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
        <c:forEach items="${compravehiculo}" var="compra">
            <tr>
                <td>${compra.ventaId}</td>
                <td>${compra.vehiculosByVehiculoId}</td>
                <td>${compra.tituloVenta}</td>
                <td>${compra.descripcionVenta}</td>
                <td>${compra.precioVenta}</td>
                <td>${compra.clientesByCompradorVenta.clienteId}</td>
                <td>${compra.fechaCompraVenta}</td>
                <td>${compra.estadoVenta}</td>
                <td>${compra.empleadosByGestorId.empleadoId}</td>
                <td>${compra.fechaCreacionVenta}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="container">
    <h3 class="mt-4">Gestión de Alquiler</h3>
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
        <c:forEach items="${arquilervehiculocli}" var="arquiler">
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
</div>
</body>
</html>

