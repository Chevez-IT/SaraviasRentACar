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
    <title>Gestion Clientes</title>
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
    <div class="row">
        <h3>Gestión de clientes</h3>
    </div>
    <form method="post" action="${pageContext.request.contextPath}/EmpleadoCLI/listcli">
        <label for="estadoCliente">Filtrar por estado:</label>
        <select id="estadoCliente" name="estadoCliente" class="form-select">
            <option selected="true" disabled="disabled">${estadoCliente}</option>
            <option value="Activo">Activo</option>
            <option value="Inactivo">Inactivo</option>
        </select>
        <button type="submit" class="btn btn-primary">Filtrar</button>

    </form>
    <c:forEach var="elemento" items="${listaCliente}" varStatus="loop">
        <c:if test="${loop.index % 5 == 0}">
            <div class="row">
        </c:if>
        <div class="col-md-2 mb-4">
            <div class="card">
                <img class="card-img-top" src="https://picsum.photos/200/200?random=${elemento.clienteId}" alt="Imagen del elemento">
                <div class="card-body">
                    <h5 class="card-title">${elemento.nombresCli} ${elemento.apellidosCli}</h5>
                    <p class="card-text">${elemento.clienteId}</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Teléfono: ${elemento.telefonoCli}</li>
                    <li class="list-group-item">Estado: ${elemento.estadoCli}</li>
                </ul>
                <div class="card-body">
                    <a href="${pageContext.request.contextPath}/EmpleadoCLI/clientep/${elemento.clienteId}" class="card-link">Ver detalles</a>
                </div>
            </div>
        </div>
        <c:if test="${(loop.index + 1) % 5 == 0 or loop.last}">
            </div>
        </c:if>
    </c:forEach>
</div>
</body>
</html>