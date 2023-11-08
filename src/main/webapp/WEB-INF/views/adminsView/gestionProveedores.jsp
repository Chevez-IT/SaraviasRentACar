<%--
  Created by IntelliJ IDEA.
  User: Erick
  Date: 1/11/2023
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>Gestión proveedores</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script><body>
<jsp:include page="/WEB-INF/views/adminsView/menu.jsp"/>
<div class="container">
    <div class="row">
        <h3>Gestión de proveedores</h3>
    </div>
    <div class="row">
        <div class="col-md-10">
            <br>
            <table class="table table-striped table-bordered table-hover" id="tabla">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>Nombre</th>
                    <th>Teléfono</th>
                    <th>DUI</th>
                    <th>Dirección</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="#" var="editorial">
                    <tr>
                        <td>ID</td>
                        <td>Usuario</td>
                        <td>Nombre</td>
                        <td>Teléfono</td>
                        <td>DUI</td>
                        <td>Dirección</td>
                        <td>Estado</td>
                        <td>
                            <a class="btn btn-success"
                               href="#"> <span class="glyphicon glyphicon-refresh"></span>Cambiar estado</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
