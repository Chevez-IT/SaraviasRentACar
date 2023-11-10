<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nueva Venta - Propietario</title>
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
                    <li class="breadcrumb-item">
                        <a class="link-body-emphasis fw-semibold text-decoration-none" href="#">Mis Vehiculos</a>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                        Nuevo Vehiculo
                    </li>
                </ol>
            </nav>

            <div class="px-4 pt-5 my-5 text-center">
                <h1 class="display-4 fw-bold text-body-emphasis">Nueva Venta</h1>
                <div class="col-lg-6 mx-auto">
                    <p class="lead mb-4">¡Listo para vender tu vehículo de manera rápida y efectiva? Aquí te damos el
                        consejo clave: antes de publicar, realiza un análisis minucioso de la información. La exactitud
                        y coherencia de los detalles no solo aceleran la aceptación de tu publicación, sino que también
                        la impulsan a ser vista por un público más amplio. Una descripción precisa, acompañada de
                        información detallada, no solo brinda confianza a los compradores, sino que también aumenta la
                        visibilidad de tu venta. ¡Asegúrate de que cada detalle cuente y prepárate para que tu vehículo
                        sea la próxima joya que encuentre su nuevo hogar!</p>
                </div>
            </div>

            <div class="container col-12 my-2 justify-content-center text-center">
                <form>
                    <div class="card text-bg-dark ">
                        <div id="carouselExampleDark" class="carousel carousel-dark slide">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active" data-bs-interval="10000">
                                    <img src="..." class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>First slide label</h5>
                                        <p>Some representative placeholder content for the first slide.</p>
                                    </div>
                                </div>
                                <div class="carousel-item" data-bs-interval="2000">
                                    <img src="..." class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>Second slide label</h5>
                                        <p>Some representative placeholder content for the second slide.</p>
                                    </div>
                                </div>
                                <div class="carousel-item">
                                    <img src="..." class="d-block w-100" alt="...">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>Third slide label</h5>
                                        <p>Some representative placeholder content for the third slide.</p>
                                    </div>
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="inputitulo" class="form-label">Titulo de la venta</label>
                        <input type="text" class="form-control" id="inputitulo"
                               placeholder="Carro bueno, bonito y barata">
                    </div>

                    <div class="mb-3">
                        <label for="inputPrecio" class="form-label">Precio de la publicación</label>
                        <input type="text" class="form-control" id="inputPrecio"
                               placeholder="Carro bueno, bonito y barato"
                               pattern="^[0-9]+(\.[0-9]{1,2})?$" min="0" required>
                    </div>

                    <div class="mb-3">
                        <label for="inputDescripcion" class="form-label">Descripcion de la
                            publicacion</label>
                        <textarea class="form-control" id="inputDescripcion" rows="3"
                                  placeholder="Tabiceria al 100, Helando Rico "></textarea>
                    </div>

                    <div class="d-grid gap-2">
                        <button class="btn btn-primary" type="button">Agregar</button>
                        <button class="btn btn-secondary" type="button">Cancelar</button>
                    </div>
                </form>
            </div>


        </div>


        <!-- Footer -->
        <jsp:include page="/WEB-INF/views/propietariosView/plantillas/footer.jsp"/>
    </div>


</div>

</body>
</html>
