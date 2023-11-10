<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil de Administrador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/views/adminsView/menu.jsp"/>
<div class="container mt-5">
    <div class="row">
        <!-- Columna izquierda (6 columnas) para la imagen del usuario -->
        <div class="col-6">
            <img src="https://picsum.photos/400/400?random" class="img-fluid" alt="Imagen de perfil">
        </div>
        <!-- Columna derecha (6 columnas) para la información del usuario -->
        <div class="col-6">
            <h2>Información del Administrador</h2>
            <p><strong>ID Administrador: </strong>${admin.administradorId}</p>
            <p><strong>Nombre: </strong>${admin.nombresAdmin} ${admin.apellidosAdmin}</p>
            <p><strong>Teléfono: </strong>${admin.telefonoAdmin}</p>
            <p><strong>Estado de empleado: </strong> ${admin.estadoAdmin}</p>
            <p><strong>Fecha de creación: </strong> ${admin.fechaCreacionAdmin}</p>

            <h2>Información de usuario</h2>
            <p><strong>ID Usuario: </strong>${usuario.usuarioId}</p>
            <p><strong>Usuario: </strong>${usuario.username}</p>
            <p><strong>Correo electronico: </strong> ${usuario.correoUser}</p>
            <p><strong>Estado de usuario: </strong> ${usuario.estadoUser}</p>

            <c:choose>
                <c:when test="${admin.estadoAdmin eq 'Activo'}">
                    <form action="desactivar" method="post">
                        <input type="hidden" name="usuarioId" value="${usuario.usuarioId}">
                        <input type="hidden" name="adminId" value="${admin.administradorId}">
                        <button type="submit" class="btn btn-danger">Desactivar</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="activar" method="post">
                        <input type="hidden" name="usuarioId" value="${usuario.usuarioId}">
                        <input type="hidden" name="adminId" value="${admin.administradorId}">
                        <button type="submit" class="btn btn-success">Activar</button>
                    </form>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
</div>

<!-- Agrega el script de Bootstrap si es necesario -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
