<%--
  Created by IntelliJ IDEA.
  User: Erick
  Date: 4/11/2023
  Time: 01:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Administrador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/views/adminsView/menu.jsp"/>
<div class="container mt-3">
    <h3>Nuevo Administrador</h3>
    <div class="row">
        <div class="col-md-7">
            <f:form method="POST" action="create" modelAttribute="admin">
                <div class="alert alert-warning"><strong><span class="glyphicon glyphicon-asterisk"></span> Campos requeridos</strong></div>

                <div class="mb-3">
                    <label for="nombresAdmin" class="form-label">Nombres:</label>
                    <div class="input-group">
                        <f:input path="nombresAdmin" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="apellidosAdmin" class="form-label">Apellidos:</label>
                    <div class="input-group">
                        <f:input path="apellidosAdmin" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="telefonoAdmin" class="form-label">Teléfono:</label>
                    <div class="input-group">
                        <f:input path="telefonoAdmin" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="correoAdmin" class="form-label">Correo electrónico:</label>
                    <div class="input-group">
                        <f:input path="correoAdmin" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <button type="submit" class="btn btn-info">Guardar</button>
            </f:form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
