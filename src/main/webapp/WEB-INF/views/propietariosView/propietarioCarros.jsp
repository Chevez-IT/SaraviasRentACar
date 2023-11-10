<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Carros - Propietario</title>
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
                <h1 class="display-4 fw-bold text-body-emphasis">Vehiculos</h1>
            </div>

            <br>

            <div class="container">
                <div class="row mb-2">
                    <div class="col-md-6">
                        <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                            <div class="col-7 p-4 d-flex flex-column position-static">
                                <strong class="d-inline-block mb-2 text-primary">Estado</strong>
                                <h3 class="mb-0">$Marca + $Modelo + $Año</h3>
                                <div class="mb-1 text-secondary fs-6">Postulacion: Fecha de creacion</div>
                                <p class="card-text mb-auto">Este es un vehiculo + $TipoCarro + la pintura general es +$ColorCarro+
                                    el cual tiene placa "+$PlacaCarro+", normalmente su consumo es +$ConsumoCarro+ por kilómetro ya que cuenta con un motor +$MotorVehiculo</p>
                            </div>
                            <div class="col-auto d-none d-lg-block">
                                <div id="carouselExampleRide" class="carousel slide" data-bs-ride="carousel" style="width: 200px; height: 250px;">
                                    <div class="carousel-inner">
                                        <!-- Agrega cada imagen al carrusel aquí -->
                                        <div class="carousel-item active">
                                            <img src="tu_primera_imagen.jpg" class="d-block w-100" alt="Imagen 1">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="tu_segunda_imagen.jpg" class="d-block w-100" alt="Imagen 2">
                                        </div>
                                        <!-- Agrega más imágenes según sea necesario -->
                                    </div>
                                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Previous</span>
                                    </button>
                                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Next</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                            <div class="col-7 p-4 d-flex flex-column position-static">
                                <strong class="d-inline-block mb-2 text-primary">Estado</strong>
                                <h3 class="mb-0">$Marca + $Modelo + $Año</h3>
                                <div class="mb-1 text-secondary fs-6">Postulacion: Fecha de creacion</div>
                                <p class="card-text mb-auto">Este es un vehiculo + $TipoCarro + la pintura general es +$ColorCarro+
                                    el cual tiene placa "+$PlacaCarro+", normalmente su consumo es +$ConsumoCarro+ por kilómetro ya que cuenta con un motor +$MotorVehiculo</p>
                            </div>
                            <div class="col-auto d-none d-lg-block">
                                <div id="carouselExampleRide" class="carousel slide" data-bs-ride="carousel" style="width: 200px; height: 250px;">
                                    <div class="carousel-inner">
                                        <!-- Agrega cada imagen al carrusel aquí -->
                                        <div class="carousel-item active">
                                            <img src="tu_primera_imagen.jpg" class="d-block w-100" alt="Imagen 1">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="tu_segunda_imagen.jpg" class="d-block w-100" alt="Imagen 2">
                                        </div>
                                        <!-- Agrega más imágenes según sea necesario -->
                                    </div>
                                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Previous</span>
                                    </button>
                                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Next</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                            <div class="col-7 p-4 d-flex flex-column position-static">
                                <strong class="d-inline-block mb-2 text-primary">Estado</strong>
                                <h3 class="mb-0">$Marca + $Modelo + $Año</h3>
                                <div class="mb-1 text-secondary fs-6">Postulacion: Fecha de creacion</div>
                                <p class="card-text mb-auto">Este es un vehiculo + $TipoCarro + la pintura general es +$ColorCarro+
                                    el cual tiene placa "+$PlacaCarro+", normalmente su consumo es +$ConsumoCarro+ por kilómetro ya que cuenta con un motor +$MotorVehiculo</p>
                            </div>
                            <div class="col-auto d-none d-lg-block">
                                <div id="carouselExampleRide" class="carousel slide" data-bs-ride="carousel" style="width: 200px; height: 250px;">
                                    <div class="carousel-inner">
                                        <!-- Agrega cada imagen al carrusel aquí -->
                                        <div class="carousel-item active">
                                            <img src="tu_primera_imagen.jpg" class="d-block w-100" alt="Imagen 1">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="tu_segunda_imagen.jpg" class="d-block w-100" alt="Imagen 2">
                                        </div>
                                        <!-- Agrega más imágenes según sea necesario -->
                                    </div>
                                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Previous</span>
                                    </button>
                                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="visually-hidden">Next</span>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Footer -->
        <jsp:include page="/WEB-INF/views/propietariosView/plantillas/footer.jsp"/>
    </div>


</div>


</body>
</html>
