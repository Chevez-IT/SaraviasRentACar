<div class="col-sm-auto position-sticky sticky-top" >
    <!-- Menú Izquierdo -->
    <div id="MenuIzquierdo" class="d-flex flex-column flex-shrink-0 bg-dark position-sticky sticky-top" style="width: 4.5rem; height: 100vh">
        <a href="${pageContext.request.contextPath}/Propietario/" class="d-block p-3 link-dark text-decoration-none" title="" data-bs-toggle="tooltip"
           data-bs-placement="right" data-bs-original-title="Icon-only" previewlistener="true">
            <img src="../resources/img/logos/logo1.png" width="45" alt="logo-site">
            <span class="visually-hidden">Icon-only</span>
        </a>
        <ul class="nav nav-pills nav-flush flex-column mb-auto text-center">

            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/Propietario/" class="nav-link text-white py-3 border-bottom" aria-current="page" title=""
                   data-bs-toggle="tooltip"
                   data-bs-placement="right" data-bs-original-title="Inicio">
                    <i class="fa-solid fa-gauge-high" style="font-size:20pt"></i>
                </a>
            </li>

            <li class="nav-item">
                <a href="#" class="nav-link text-white py-3 border-bottom" aria-current="page" title=""
                   data-bs-toggle="tooltip"
                   data-bs-placement="right" data-bs-original-title="Chats">
                    <i class="fa-solid fa-comments" style="font-size:20pt"></i>
                </a>
            </li>

            <li class="nav-item dropend">
                <a href="#" class="nav-link text-white py-3 border-bottom dropdown-toggle" id="dropdownCar"
                   data-bs-toggle="dropdown"
                   aria-expanded="false">
                    <i class="fa-solid fa-car-side" style="font-size:20pt"></i>
                </a>
                <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownCar">
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Vendidos">Vehiculos Vendidos</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Alquilados">Vehiculos Alquilados</a></li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Disponibles">Vehiculos
                        Disponibles</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Rechazados">Vehiculos Rechazados</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/EnEspera">Vehiculos En Espera</a></li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos">Ver Vehiculos</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietario/Vehiculos/Nuevo">Agregar Vehiculo</a></li>
                </ul>
            </li>

            <li class="nav-item">
                <a href="#" class="nav-link text-white py-3 border-bottom" aria-current="page" title=""
                   data-bs-toggle="tooltip"
                   data-bs-placement="right" data-bs-original-title="Salir">
                    <i class="fa-solid fa-right-from-bracket" style="font-size:20pt"></i>
                </a>
            </li>

        </ul>
        <div class="dropdown border-top">
            <a href="#"
               class="d-flex align-items-center justify-content-center p-3 link-dark text-decoration-none dropdown-toggle"
               id="dropdownUser3" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://github.com/mdo.png" alt="mdo" width="30" height="30" class="rounded-circle">
            </a>
            <ul class="dropdown-menu text-small shadow dropdown-menu-dark" aria-labelledby="dropdownUser3" style="">
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietarios/MiPerfil">Perfil
                </a></li>
                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Propietarios/MiPerfil/NuevaContraseña">Cambio
                    de contraseña</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Salir</a></li>
            </ul>
        </div>
    </div>
</div>