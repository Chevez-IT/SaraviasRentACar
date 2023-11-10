<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/0fc218370a.js" crossorigin="anonymous"></script>
</head>
<body>

<div class="container-fluid p-0" style="display: flex;">
    <div class="col-sm-auto position-sticky sticky-top" >
        <!-- Menú Izquierdo -->
        <div id="MenuIzquierdo" class="d-flex flex-column flex-shrink-0 bg-dark position-sticky sticky-top" style="width: 4.5rem; height: 100vh">
            <a href="#" class="d-block p-3 link-dark text-decoration-none" title="" data-bs-toggle="tooltip"
               data-bs-placement="right" data-bs-original-title="Icon-only" previewlistener="true">
                <img src="../resources/img/logos/logo1.png" width="45" alt="logo-site">
                <span class="visually-hidden">Icon-only</span>
            </a>
            <ul class="nav nav-pills nav-flush flex-column mb-auto text-center">

                <li class="nav-item">
                    <a href="#" class="nav-link text-white py-3 border-bottom" aria-current="page" title=""
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
                        <li><a class="dropdown-item" href="#">Vehiculos Disponibles</a></li>
                        <li><a class="dropdown-item" href="#">Vehiculos Rentados</a></li>
                        <li><a class="dropdown-item" href="#">Vehiculos Vendidos</a></li>
                        <li><a class="dropdown-item" href="#">Vehiculos Inactivos</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Ver Vehiculos</a></li>
                        <li><a class="dropdown-item" href="#">Agregar Vehiculo</a></li>
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
                    <li><a class="dropdown-item" href="#">Perfil</a></li>
                    <li><a class="dropdown-item" href="#">Cambio de contraseña</a></li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>
                    <li><a class="dropdown-item" href="#">Salir</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="col">
        <!-- Menú Superior -->
        <div id="MenuSuperior" class="col-12 mb-lg-5 position-sticky sticky-top">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Saravia's Rent a Car</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Chats</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Mis Arquileres</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Mis Ventas</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                   data-bs-toggle="dropdown" aria-expanded="false">
                                    Vehiculos
                                </a>
                                <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Nuevo vehiculos</a></li>
                                    <li><a class="dropdown-item" href="#">Disponibles</a></li>
                                    <li><a class="dropdown-item" href="#">Inactivo</a></li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li><a class="dropdown-item" href="#">Vehiculos en Renta</a></li>
                                    <li><a class="dropdown-item" href="#">Vehiculos en Venta </a></li>
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
                                    <li><a class="dropdown-item" href="#">Perfil</a></li>
                                    <li><a class="dropdown-item" href="#">Cambio de contraseña</a></li>
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


        <!-- Contenido -->
        <div id="Contenido" class="col-12 my-2">

        </div>



        <!-- Footer -->
        <div id="Footer" class="col-12 mt-2">
            <footer class="px-4 mt-auto text-secondary text-center bg-dark border-top border-secondary border-5 p-3">
                <img class="d-block mx-auto mb-3" src="../resources/img/logos/logo1.png" alt="" height="60">
                <h1 class="display-3 fw-bold text-white">Saravia's Rent a Car</h1>
                <div class="col-lg-6 mx-auto">
                    <p class="lead mb-4 fw-bold">Un lugar mejor para mis vehiculos</p>
                    <p class="lead mb-4 text-white">© 2023 UDB SDR404, Inc.</p>
                </div>
            </footer>
        </div>
    </div>


</div>


</body>
</html>