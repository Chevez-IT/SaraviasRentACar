<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Gestión Ventas</title>
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
    <h3 class="mt-4">Gestión de Ventas</h3>
    <div class="row mt-3">
        <form method="post" action="${pageContext.request.contextPath}/EmpleadoVEN/listvend">
            <label for="estadoVenta">Filtrar por estado:</label>
            <select id="estadoVenta" name="estadoVenta" class="form-select">
                <option selected="true" disabled="disabled">${estadoVenta}</option>
                <option value="Disponible">Disponible</option>
                <option value="Rechazado">Rechazado</option>
                <option value="Vendido">Vendido</option>
                <option value="Pendiente">Pendiente</option>
                <option value="Ofertada">Ofertado</option>
            </select>
            <button type="submit" class="btn btn-primary">Filtrar</button>
        </form>


    </div>
    <table class="table table-striped table-bordered table-hover mt-4" id="tabla">
        <thead>
        <tr>
            <th>Id Venta</th>
            <th>Titulo</th>
            <th>Descripcion</th>
            <th>Precio</th>
            <th>Fecha Compra</th>
            <th>Estado</th>
            <th>Fecha creacion</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaVentasDIS}" var="ventas">
            <tr>
                <td>${ventas.ventaId}</td>
                <td>${ventas.tituloVenta}</td>
                <td>${ventas.descripcionVenta}</td>
                <td>${ventas.precioVenta}</td>
                <td>${ventas.fechaCompraVenta}</td>
                <td>${ventas.estadoVenta}</td>
                <td>${ventas.fechaCreacionVenta}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
