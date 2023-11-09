<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión Clientes</title>
    <style>
        .card-body {
            max-height: 150px; /* Ajusta la altura máxima según tus necesidades */
            overflow: hidden;
        }
        .card-img-top {
            max-height: 100px; /* Ajusta la altura máxima de la imagen */
            object-fit: cover;
        }
    </style>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<body>
<jsp:include page="/WEB-INF/views/empleadosView/navbar.jsp"/>
<div class="container">
    <div class="row">
        <h3>Gestión de clientes</h3>
    </div>
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
                    <a href="#" class="card-link">Ver detalles</a>
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