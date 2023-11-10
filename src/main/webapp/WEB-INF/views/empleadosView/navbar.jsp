<%--
  Created by IntelliJ IDEA.
  User: Angie
  Date: 7/11/2023
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand" href="#">Saravias Rent-a-Car</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="#">Inicio</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="#">Perfil Empleado</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Gestiones
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/EmpleadoCLI/listcli">Clientes</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/EmpleadoPRO/listpro">Empleados</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/EmpleadoVEN/listvend">Ventas</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/EmpleadoVEN/listvend">Arquileres</a>
          </div>
        </li>
      </ul>
    </div>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">
          <span class="glyphicon glyphicon-log-in"></span> Logout
        </a>
      </li>
    </ul>
  </div>
</nav>
</body>
</html>
