<div id="MenuSuperior" class="col-12 mb-lg-5 position-sticky sticky-top">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/Propietario/">Saravia's Rent a Car</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/Propietario/">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="#">Chats</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Propietario/Alquileres">Mis Arquileres</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/Propietario/Ventas">Mis Ventas</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            Vehiculos
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos">Mis Vehiculos</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Nuevo">Nuevo vehiculos</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Disponibles">Disponibles</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Rechazados">Rechazados</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/EnEspera">En espera</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Arquilados">Vehiculos en
                                Arquiler</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Vendidos">Vehiculos en
                                Vendidos</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="d-flex">
                    <a class="btn btn-dark rounded-pill px-3" href="#">Cerrar Sesion <i
                            class="fa-solid fa-arrow-right-from-bracket ms-2"></i></a>
                    <div class="dropdown dropstart">
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle"
                           id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32"
                                 class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark text-small" aria-labelledby="dropdownUser1"
                            style="">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/MiPefil">Perfil</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/MiPefil/NuevaContraseña">Cambio de contraseña</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#">Salir</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</div>
