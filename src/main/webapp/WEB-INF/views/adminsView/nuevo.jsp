<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/views/adminsView/menu.jsp"/>
<div class="container mt-3">
    <h3>Nuevo empleado</h3>
    <div class="row">
        <div class="col-md-7">
            <f:form method="POST" action="create" modelAttribute="empleado">
                <div class="alert alert-warning"><strong><span class="glyphicon glyphicon-asterisk"></span> Campos requeridos</strong></div>

                <div class="mb-3">
                    <label for="nombresEmp" class="form-label">Nombres:</label>
                    <div class="input-group">
                        <f:input path="nombresEmp" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="apellidosEmp" class="form-label">Apellidos:</label>
                    <div class="input-group">
                        <f:input path="apellidosEmp" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="telefonoEmp" class="form-label">Teléfono:</label>
                    <div class="input-group">
                        <f:input path="telefonoEmp" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="correo" class="form-label">Correo electrónico:</label>
                    <div class="input-group">
                        <f:input path="correo" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="duiEmp" class="form-label">DUI:</label>
                    <div class="input-group">
                        <f:input path="duiEmp" cssClass="form-control"/>
                        <span class="input-group-text"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="mb-3">
                    <label for="direccionEmp" class="form-label">Dirección de domicilio:</label>
                    <div class="input-group">
                        <f:input path="direccionEmp" cssClass="form-control"/>
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
