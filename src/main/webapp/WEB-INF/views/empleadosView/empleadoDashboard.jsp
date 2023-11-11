<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .card {
            margin: 10px;
        }

        .card img {
            max-height: 150px;
            object-fit: cover;
        }

        .card-body {
            padding: 10px;
        }

        .card-title {
            font-size: 1.2em;
            font-weight: bold;
        }

        .card-text {
            margin-bottom: 5px;
        }

        .btn-primary {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/views/empleadosView/navbar.jsp"/>
<div class="container">
    <h3 class="mt-4">Inicio</h3>

    <!-- Sección de Gestión de Clientes -->
    <h4 class="mt-4">Gestión de Clientes</h4>
    <div class="row">
        <c:forEach var="cliente" items="${listaClientes}">
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="https://picsum.photos/200/200?random=${cliente.clienteId}" alt="Imagen del cliente">
                    <div class="card-body">
                        <h5 class="card-title">${cliente.nombresCli} ${cliente.apellidosCli}</h5>
                        <p class="card-text">Teléfono: ${cliente.telefonoCli}</p>
                        <p class="card-text">Estado: ${cliente.estadoCli}</p>
                        <p class="card-text">Correo: ${cliente.correoCli}</p>
                        <p class="card-text">Dirección: ${cliente.direccionCli}</p>
                        <!-- Enlace para ver detalles -->
                        <a href="${pageContext.request.contextPath}/EmpleadoCLI/clientep/${cliente.clienteId}" class="btn btn-primary">Ver detalles</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Sección de Gestión de Propietarios -->
    <h4 class="mt-4">Gestión de Propietarios</h4>
    <div class="row">
        <c:forEach var="propietario" items="${listaPropietarios}">
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="https://picsum.photos/200/200?random=${propietario.propietarioId}" alt="Imagen del propietario">
                    <div class="card-body">
                        <h5 class="card-title">${propietario.nombresProp} ${propietario.apellidosProp}</h5>
                        <p class="card-text">Teléfono: ${propietario.telefonoProp}</p>
                        <p class="card-text">Estado: ${propietario.estadoProp}</p>
                        <!-- Agregar más información según sea necesario -->
                        <!-- Enlace para ver detalles -->
                        <a href="${pageContext.request.contextPath}/EmpleadoPRO/propietariop/${propietario.propietarioId}" class="btn btn-primary">Ver detalles</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- Sección de Gestión de Ventas -->
    <h4 class="mt-4">Gestión de Ventas</h4>
    <div class="row">
        <c:forEach var="venta" items="${listaVentaDIS}">
            <div class="col-md-4">
                <div class="card">
                    <img class="card-img-top" src="https://picsum.photos/200/200?random=${venta.ventaId}" alt="Imagen de la venta">
                    <div class="card-body">
                        <h5 class="card-title">${venta.tituloVenta}</h5>
                        <p class="card-text">Precio: ${venta.precioVenta}</p>
                        <p class="card-text">Estado: ${venta.estadoVenta}</p>
                        <!-- Agregar más información según sea necesario -->
                        <!-- Enlace para ver detalles -->
                        <a href="${pageContext.request.contextPath}/EmpleadoVEN/venta/${venta.ventaId}" class="btn btn-primary">Ver detalles</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
