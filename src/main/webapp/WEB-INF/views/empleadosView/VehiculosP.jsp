<%--
  Created by IntelliJ IDEA.
  User: Angie
  Date: 9/11/2023
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehiculo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/views/empleadosView/navbar.jsp"/>
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
            <c:choose>
                <c:when test="${vehiculos.estadoVehiculo eq 'Pendiente'}">
                    <form action="activar" method="post">
                        <input type="hidden" name="propietarioId" value="${propietariovehiculo.propietarioId}">
                        <input type="hidden" name="vehiculoId" value="${vehiculos.vehiculoId}">
                        <button type="submit" class="btn btn-success">Activar</button>
                    </form>

                    <form action="rechazar" method="post">
                        <input type="hidden" name="propietarioId" value="${propietariovehiculo.propietarioId}">
                        <input type="hidden" name="vehiculoId" value="${vehiculos.vehiculoId}">
                        <button type="submit" class="btn btn-success">Desactivar</button>
                    </form>

                    <form action="si" method="post">
                        <input type="hidden" name="propietarioId" value="">
                        <input type="hidden" name="vehiculoId" value="">
                        <button type="submit" class="btn btn-success">Chat</button>
                    </form>

                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>

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
