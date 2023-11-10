<%--
  Created by IntelliJ IDEA.
  User: cesar
  Date: 9/11/2023
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verificación de Código</title>
</head>
<body>

<h2>Ingrese el Código de Verificación</h2>

<form action="<c:url value='verificarCodigo' />" method="post">
    <label for="codigo">Código:</label>
    <input type="text" id="codigo" name="codigo" required>
    <br>
    <input type="submit" value="Verificar Código">
</form>

</body>
</html>