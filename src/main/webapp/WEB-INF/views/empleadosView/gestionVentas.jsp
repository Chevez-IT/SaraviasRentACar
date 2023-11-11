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
        <form method="post" action="${pageContext.request.contextPath}/EmpleadoVEN/listven">
            <label for="estadoVenta">Filtrar por estado:</label>
            <select id="estadoVenta" name="estadoVenta" class="form-select">
                <option selected="true" disabled="disabled">${estadoVenta}</option>
                <option value="Disponible">Disponible</option>
                <option value="Rechazado">Rechazado</option>
                <option value="Vendido">Vendido</option>
                <option value="Pendiente">Pendiente</option>
                <option value="Ofertado">Ofertado</option>
            </select>
            <button type="submit" class="btn btn-primary">Filtrar</button>
        </form>


    </div>
    <table class="table table-striped table-bordered table-hover mt-4" id="tabla">
        <thead>
        <tr>
            <th>Id Venta</th>
            <th>Id Vehiculo</th>
            <th>Titulo</th>
            <th>Descripcion</th>
            <th>Precio</th>



            <c:choose>
                <c:when test="${estadoVenta eq 'Pendiente' || estadoVenta eq 'Vendido'}">
                    <th>Comprador</th>
                </c:when>
                <c:when test="${estadoVenta eq 'Ofertado'}">
                    <th>Comprador</th>
                </c:when>
            <c:otherwise>
            </c:otherwise>
            </c:choose>

            <th>Fecha Compra</th>
            <th>Gestor</th>
            <th>Estado</th>
            <th>Fecha creacion</th>


            <c:choose>
                <c:when test="${estadoVenta eq 'Pendiente' || estadoVenta eq 'Ofertado'}">
                    <th>Operaciones</th>
                </c:when>

                <c:otherwise>
                </c:otherwise>
            </c:choose>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listaVentaDIS}" var="ventas">
            <tr>
                <td>${ventas.ventaId}</td>
                <td>${ventas.vehiculosByVehiculoId.vehiculoId}</td>
                <td>${ventas.tituloVenta}</td>
                <td>${ventas.descripcionVenta}</td>
                <td>${ventas.precioVenta}</td>



                <c:choose>
                    <c:when test="${ventas.estadoVenta eq 'Pendiente' || ventas.estadoVenta eq 'Vendido'}">
                        <td>${ventas.clientesByCompradorVenta.clienteId}</td>
                    </c:when>
                    <c:when test="${ventas.estadoVenta eq 'Ofertado'}">
                        <td>${ventas.clientesByCompradorVenta.clienteId}</td>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>

                <td>${ventas.fechaCompraVenta}</td>
                <td>${ventas.empleadosByGestorId.empleadoId}</td>
                <td>${ventas.estadoVenta}</td>
                <td>${ventas.fechaCreacionVenta}</td>


                <c:choose>
                    <c:when test="${estadoVenta eq 'Pendiente'}">
                        <td>
                            <form action="aprobar" method="post">
                                <input type="hidden" name="ventaId" value="${ventas.ventaId}">
                                <button type="submit" class="btn btn-success">Aprobar</button>
                            </form>

                            <form action="rechazar" method="post">
                                <input type="hidden" name="ventaId" value="${ventas.ventaId}">
                                <button type="submit" class="btn btn-success">Rechazar</button>
                            </form>

                            <form action="activar" method="post">
                                <input type="hidden" name="usuarioId" value="${usuario.usuarioId}">
                                <button type="submit" class="btn btn-success">Chat</button>
                            </form>
                        </td>
                    </c:when>

                    <c:when test="${estadoVenta eq 'Ofertado'}">
                        <td>

                            <form action="vender" method="post">
                                <input type="hidden" name="ventaId" value="${ventas.ventaId}">
                                <button type="submit" class="btn btn-success">Vender</button>
                            </form>

                            <form action="rechazardis" method="post">
                                <input type="hidden" name="ventaId" value="${ventas.ventaId}">
                                <button type="submit" class="btn btn-success">Rechazar</button>
                            </form>

                            <form action="activar" method="post">
                                <input type="hidden" name="usuarioId" value="${usuario.usuarioId}">
                                <button type="submit" class="btn btn-success">Chat</button>
                            </form>

                        </td>
                    </c:when>


                    <c:otherwise>
                    </c:otherwise>
                </c:choose>


            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
