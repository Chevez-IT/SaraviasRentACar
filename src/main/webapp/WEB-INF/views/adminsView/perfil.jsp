<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil de Usuario</title>
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
            <h2>Información del empleado</h2>
            <p><strong>ID Empleado: </strong>${empleado.empleadoId}</p>
            <p><strong>Nombre: </strong>${empleado.nombresEmp} ${empleado.apellidosEmp}</p>
            <p><strong>DUI: </strong> ${empleado.duiEmp}</p>
            <p><strong>Teléfono: </strong>${empleado.telefonoEmp}</p>
            <p><strong>Dirección: </strong> ${empleado.direccionEmp}</p>
            <p><strong>Estado de empleado: </strong> ${empleado.estadoEmp}</p>
            <a href="#" class="btn btn-primary">Editar Empleado</a>

            <h2>Información de usuario</h2>
            <p><strong>ID Usuario: </strong>${usuario.usuarioId}</p>
            <p><strong>Usuario: </strong>${usuario.username}</p>
            <p><strong>Correo electronico: </strong> ${usuario.correoUser}</p>
            <p><strong>Estado de usuario: </strong> ${usuario.estadoUser}</p>
            <a href="#" class="btn btn-primary">Editar Usuario</a>

            <form action="/panel/empleados/desactivar" method="post">
                <button type="submit" class="btn btn-danger">Desactivar Empleado y Usuario</button>
            </form>
        </div>
    </div>
</div>

<!-- Agrega el script de Bootstrap si es necesario -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
