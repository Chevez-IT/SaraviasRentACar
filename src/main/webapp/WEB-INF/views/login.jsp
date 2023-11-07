<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Iniciar Sesión</title>
</head>
<body>
<h2>Iniciar Sesión</h2>
<form method="post" th:action="@{/login}">
    <label for="username">Nombre de Usuario:</label>
    <input type="text" id="username" name="username" required><br>

    <label for="password">Contraseña:</label>
    <input type="password" id="password" name="password" required><br>

    <button type="submit">Iniciar Sesión</button>
</form>
</body>
</html>
