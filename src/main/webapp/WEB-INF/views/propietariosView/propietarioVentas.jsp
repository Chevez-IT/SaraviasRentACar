<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ventas - Propietario</title>
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
            <!-- Navegacion -->
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb p-3 bg-body-tertiary rounded-3">
                    <li class="breadcrumb-item">
                        <a class="link-body-emphasis" href="#">
                            <i class="fa-solid fa-house bi"></i>
                        </a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                        Mis Vehiculos
                    </li>
                </ol>
            </nav>


            <div class="px-lg-5 pt-5 text-center">
                <h1 class="display-4 fw-bold text-body-emphasis">Ventas</h1>
            </div>

            <div class="px-lg-5 pt-5 text-center">
                <table class="table table-hover table-sm caption-top">
                    <caption>Ventas</caption>
                    <thead class="table-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">First</th>
                        <th scope="col">Last</th>
                        <th scope="col">Handle</th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>Jacob</td>
                        <td>Thornton</td>
                        <td>@fat</td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td colspan="2">Larry the Bird</td>
                        <td>@twitter</td>
                    </tr>
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

