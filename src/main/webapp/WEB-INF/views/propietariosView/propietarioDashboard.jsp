<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home - Propietario</title>
    <jsp:include page="/WEB-INF/views/propietariosView/plantillas/head.jsp"/>
</head>
<body>
<div class="container-fluid p-0" style="display: flex;">
    <!-- Menú Izquierdo -->
    <jsp:include page="/WEB-INF/views/propietariosView/plantillas/menu-izquierdo.jsp"/>

    <div class="col">
        <!-- Menú Superior -->
        <jsp:include page="/WEB-INF/views/propietariosView/plantillas/menu-superior.jsp"/>

        <!-- Contenido -->
        <div id="Contenido" class="col-12 my-2">
            <div class="container col-12 my-2">
                <div class="row">
                    <div class="col-12 col-md-4 mb-4">
                        <div class="card shadow-lg bg-dark text-white">
                            <div class="container card-body border-start border-warning h-100 border-3 py-3 px-4">
                                <div class="row h-100">
                                    <div class="col-8">
                                        <a class="font-monospace text-warning fw-bold text-uppercase fs-6">
                                            Mis Arquileres
                                        </a>
                                        <h4 class="fw-bold text-white">Arquileres</h4>
                                        <h4 class="fw-bold text-white">Pendientes</h4>
                                    </div>
                                    <div class="col-2 d-flex align-items-center justify-content-center">
                                        <h1 class="fw-bold text-white">${nArquileresEnEspera}</h1>
                                    </div>
                                    <div class="col-2 d-flex align-items-center justify-content-center">
                                        <i class="fa-solid fa-receipt fw-bold fs-1 text-warning"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-4 mb-4">
                        <div class="card shadow-lg bg-dark text-white">
                            <div class="container card-body border-start border-danger border-3 h-100 py-3 px-4">
                                <div class="row h-100">
                                    <div class="col-8">
                                        <a class="font-monospace text-danger fw-bold text-uppercase fs-6">
                                            Mis Vehiculos
                                        </a>
                                        <h4 class="fw-bold text-white">Vehiculos</h4>
                                        <h4 class="fw-bold text-white">Pendientes</h4>
                                    </div>
                                    <div class="col-2 d-flex align-items-center justify-content-center">
                                        <h1 class="fw-bold text-white">${nVehiculosEnEspera}</h1>
                                    </div>
                                    <div class="col-2 d-flex align-items-center justify-content-center">
                                        <i class="fa-solid fa-car-on fw-bold fs-1 text-danger"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-4 mb-4">
                        <div class="card shadow-lg bg-dark text-white">
                            <div class="container card-body border-start border-warning border-3 h-100 py-3 px-4">
                                <div class="row h-100">
                                    <div class="col-8">
                                        <a class="font-monospace text-warning fw-bold text-uppercase fs-6">
                                            Mis Ventas
                                        </a>
                                        <h4 class="fw-bold text-white">Ventas</h4>
                                        <h4 class="fw-bold text-white">Pendientes</h4>
                                    </div>
                                    <div class="col-2 d-flex align-items-center justify-content-center">
                                        <h1 class="fw-bold text-white">${nVentasEnEspera}</h1>
                                    </div>
                                    <div class="col-2 d-flex align-items-center justify-content-center">
                                        <h1><i class="fa-solid fa-receipt text-warning fw-bold fs-1"></i></h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container col-12 my-2">
                <div class="row">
                    <div class="col-12 col-md-6 mb-4">
                        <div class="card shadow-lg">
                            <div class="container card-body border-start border-success border-3 py-3 px-4">
                                <div class="row">
                                    <div class="col-6">
                                        <a class="font-monospace text-success fw-bold text-uppercase fs-6">Ventas
                                            Realizadas</a>
                                        <h2 class="fw-bold text-secondary">Ventas Actuales</h2>
                                    </div>
                                    <div class="col-2">
                                        <h1 class="fw-bold text-secondary">${nVentasActivas}</h1>
                                    </div>
                                    <div class="col-4 d-flex align-items-center justify-content-center">
                                        <i class="fa-solid fa-file-invoice-dollar fw-bold fs-1 text-success"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-6 mb-4">
                        <div class="card shadow-lg">
                            <div class="container card-body border-start border-primary border-3 h-100 py-3 px-4">
                                <div class="row">
                                    <div class="col-6">
                                        <a class="font-monospace text-primary fw-bold text-uppercase fs-6">Arquileres
                                            Realizadas</a>
                                        <h2 class="fw-bold text-secondary">Arquileres Actuales</h2>
                                    </div>
                                    <div class="col-2">
                                        <h1 class="fw-bold text-secondary">${nArquileresActivos}</h1>
                                    </div>
                                    <div class="col-4 d-flex align-items-center justify-content-center">
                                        <i class="fa-solid fa-handshake text-primary fw-bold fs-1"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="b-example-divider"
                 style="width: 100%;height: 3rem;background-color: rgba(0, 0, 0, .1);border: solid rgba(0, 0, 0, .15);border-width: 1px 0;box-shadow: inset 0 0.5em 1.5em rgba(0, 0, 0, .1), inset 0 0.125em 0.5em rgba(0, 0, 0, .15);"></div>

            <div class="container col-12 text-center py-4">
                <img class="d-block mx-auto mb-4" src="../resources/img/ilustraciones/saludo.png" alt="Saludo"
                     width="85">
                <h1 class="display-5 fw-bold">Bienvenido #nombre</h1>
                <div class="col-lg-6 mx-auto">
                    <p class="lead mb-5">El dia de ahora tenemos muchas cosas por hacer, asi que te recomendamos
                        iniciar por revisar los nuevos chat y tus solicitudes de arquiler y/o ventas</p>
                    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
                        <a class="btn btn-warning btn-lg px-4">Arquileres Aprobados</a>
                        <a class="btn btn-outline-secondary btn-lg px-4 gap-3">Chats Nuevos</a>
                        <a class="btn btn-warning btn-lg px-4">Ventas Aprobadas</a>
                    </div>
                </div>
            </div>
            <div class="b-example-divider"
                 style="width: 100%;height: 3rem;background-color: rgba(0, 0, 0, .1);border: solid rgba(0, 0, 0, .15);border-width: 1px 0;box-shadow: inset 0 0.5em 1.5em rgba(0, 0, 0, .1), inset 0 0.125em 0.5em rgba(0, 0, 0, .15);"></div>

            <div class="px-lg-5 pt-5 text-center">
                <h1 class="display-4 fw-bold text-body-emphasis">Vehiculos en espera</h1>
                <table class="table table-hover table-sm caption-top">
                    <caption>Vehiculos sin aprobar</caption>
                    <thead class="table-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Marca</th>
                        <th scope="col">Modelo - Año</th>
                        <th scope="col">Placa</th>
                        <th scope="col">Estado</th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    <c:forEach items="${vehiculosEnEspera}" var="vehiculos">
                        <tr>
                            <th scope="row">${vehiculos.vehiculoId}</th>
                            <td>${vehiculos.marcaVehiculo}</td>
                            <td>${vehiculos.modeloVehiculo}</td>
                            <td>${vehiculos.placaVehiculo}</td>
                            <td>${vehiculos.estadoVehiculo}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="px-lg-5 pt-5 text-center">
                <h1 class="display-4 fw-bold text-body-emphasis">Arquileres en espera</h1>
                <table class="table table-hover table-sm caption-top">
                    <caption>Arquileres sin aprobar</caption>
                    <thead class="table-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Titulo</th>
                        <th scope="col">Descripcion</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Estado</th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    <c:forEach items="${alquileresEnEspera}" var="alquiler">
                        <tr>
                            <th scope="row">${alquiler.arquilerId}</th>
                            <td>${alquiler.tituloArquiler}</td>
                            <td>${alquiler.descripcionArquiler}</td>
                            <td>${alquiler.precioArquiler}></td>
                            <td>${alquiler.estadoArquiler}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="px-lg-5 pt-5 text-center">
                <h1 class="display-4 fw-bold text-body-emphasis">Ventas en espera</h1>
                <table class="table table-hover table-sm caption-top">
                    <caption>Ventas sin aprobar</caption>
                    <thead class="table-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Titulo</th>
                        <th scope="col">Descripcion</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Estado</th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    <c:forEach items="${ventasEnEspera}" var="venta">
                        <tr>
                            <th scope="row">${venta.ventaId}</th>
                            <td>${venta.tituloVenta}</td>
                            <td>${venta.descripcionVenta}</td>
                            <td>${venta.precioVenta}></td>
                            <td>${venta.estadoVenta}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>


        </div>


        <!-- Footer -->
        <jsp:include page="/WEB-INF/views/propietariosView/plantillas/footer.jsp"/>
    </div>


</div>

</body>
</html>