<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Título de la página</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body class="container-fluid">
<main>

    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Alquileres Disponibles</h1>
                <p class="lead text-muted">Busca lo que necesitas y no dudes en ofertar, puede que no solo seas tu
                    el que necesita</p>
            </div>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">

            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <c:forEach items="${alquileresInfo}" var="alquileres">
                    <div class="col">
                        <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-inner">
                                <!-- Aquí colocarás tus imágenes del carrusel -->
                                <c:forEach var="imagenes" items="${alquileres.imagenes}">
                                    <div class="carousel-item active">
                                        <img alt="imagen aleatoria"
                                             src="${imagenes.imgVehiculo}">
                                    </div>
                                </c:forEach>
                                <!-- Agrega más imágenes según sea necesario -->
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>

                        <div class="card shadow-sm">
                            <!-- Contenido del cuerpo de la tarjeta -->
                            <div class="card-body">
                                <div class="row">
                                    <div class="col text-primary">
                                            ${alquileres.alquiler.tituloArquiler}
                                    </div>
                                    <div class="col text-danger">
                                            $${alquileres.alquiler.precioArquiler}
                                    </div>
                                </div>
                                <p class="card-text">${alquileres.alquiler.descripcionArquiler}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Ofertar</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">¿Sigue
                                            Disponible?</button>
                                    </div>
                                    <small class="text-muted">Disponible</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>


    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Ventas Disponibles</h1>
                <p class="lead text-muted">Busca lo que necesitas y no dudes en ofertar, puede que no solo seas tu
                    el que necesita</p>
            </div>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">

            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <c:forEach items="${ventasInfo}" var="ventas">
                    <div class="col">
                        <div id="carouselExample2" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-inner">
                                <!-- Aquí colocarás tus imágenes del carrusel -->
                                <c:forEach var="imagenes" items="${ventas.imagenes}">
                                    <div class="carousel-item active">
                                        <img alt="imagen aleatoria"
                                             src="${imagenes.imgVehiculo}">
                                    </div>
                                </c:forEach>
                                <!-- Agrega más imágenes según sea necesario -->
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample2"
                                    data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>

                        <div class="card shadow-sm">
                            <!-- Contenido del cuerpo de la tarjeta -->
                            <div class="card-body">
                                <div class="row">
                                    <div class="col text-primary">
                                            ${ventas.ventas.tituloVenta}
                                    </div>
                                    <div class="col text-danger">
                                        $${ventas.ventas.precioVenta}
                                    </div>
                                </div>
                                <p class="card-text">${ventas.ventas.descripcionVenta}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">Ofertar</button>
                                        <button type="button" class="btn btn-sm btn-outline-secondary">¿Sigue
                                            Disponible?</button>
                                    </div>
                                    <small class="text-muted">Disponible</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
    </div>

</main>
</body>
</html>
