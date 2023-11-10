<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Carro - Propietario</title>
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
                <h1 class="display-4 fw-bold text-body-emphasis">Nuevo Vehiculo</h1>
                <div class="col-lg-6 mx-auto">
                    <p class="lead mb-4">Hola de nuevo, te recordamos que la honestidad y los detalles marcan la
                        diferencia! Creemos en la importancia de la información precisa. Al publicar tu vehículo,
                        asegúrate de proporcionar detalles exactos y relevantes. La veracidad de tu anuncio no solo
                        construye confianza, sino que también garantiza que tu vehículo llegue a la audiencia
                        adecuada. Sé detallista, destaca las características únicas y deja que tu vehículo brille.
                        Cuantos más detalles ofrezcas, más fácil será para el publico encontrar lo que están buscando.
                        ¡Prepárate para destacar y conectar con la comunidad automotriz de manera auténtica</p>
                </div>
            </div>

            <div class="container col-12 my-2">
                <form>
                    <div class="row">
                        <div class="col-12 col-md-8">
                            <div class="mb-3">
                                <label for="inputMarca" class="form-label">Marca del Vehiculo</label>
                                <input type="text" class="form-control" id="inputMarca"
                                       placeholder="Toyota / Nissan / Honda">
                            </div>
                            <div class="mb-3">
                                <label for="inputModelo" class="form-label">Modelo del Vehiculo</label>
                                <input type="text" class="form-control" id="inputModelo"
                                       placeholder="Yaris / Centra / Civic">
                            </div>
                            <div class="mb-3">
                                <label for="inputAño" class="form-label">Año del Vehiculo</label>
                                <input type="text" class="form-control" id="inputAño" placeholder="2010" pattern="\d{4}"
                                       maxlength="4" required>
                            </div>
                            <div class="mb-3">
                                <label for="inputTipoAuto" class="form-label">Tipo del Vehiculo</label>
                                <select id="inputTipoAuto" class="form-select" title="Seleccione el tipo correcto"
                                        required>
                                    <option value="Sedan">Sedan</option>
                                    <option value="Hatchback">Hatchback</option>
                                    <option value="Coupe">Coupe</option>
                                    <option value="Camioneta">Camioneta</option>
                                    <option value="Pick Up">Pick Up</option>
                                    <option value="SUV">SUV</option>
                                    <option value="Urban">Urban</option>
                                    <option value="Otro">Otro</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="inputColor" class="form-label">Color del Vehiculo</label>
                                <input type="text" class="form-control" id="inputColor" placeholder="Rojo" required>
                            </div>
                            <div class="mb-3">
                                <label for="inputPlaca" class="form-label">Placa del Vehiculo</label>
                                <input type="text" class="form-control" id="inputPlaca" required>
                            </div>
                            <div class="mb-3">
                                <label for="inputMotor" class="form-label">Motor del Vehiculo</label>
                                <input type="text" class="form-control" id="inputMotor" required>
                            </div>
                            <div class="mb-3">
                                <label for="inputConsumo" class="form-label">Consumo/km del Vehiculo</label>
                                <input type="text" class="form-control" id="inputConsumo" required>
                            </div>
                        </div>

                        <div class="col-12 col-md-4">
                            <div class="mb-3">
                                <label for="inputImagenes" class="form-label">Seleccionar imágenes</label>
                                <input type="file" class="form-control" id="inputImagenes" multiple accept="image/*">
                            </div>

                            <div id="listaImagenes" class="mt-3 carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <!-- Aquí se mostrarán las imágenes cargadas -->
                                </div>
                                <button class="carousel-control-prev" type="button" data-bs-target="#listaImagenes"
                                        data-bs-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Anterior</span>
                                </button>
                                <button class="carousel-control-next" type="button" data-bs-target="#listaImagenes"
                                        data-bs-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="visually-hidden">Siguiente</span>
                                </button>
                            </div>
                        </div>
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
<script>
    document.getElementById('inputImagenes').addEventListener('change', handleFileSelect);

    function handleFileSelect(event) {
        const fileList = event.target.files;
        const listaImagenes = document.querySelector('#listaImagenes .carousel-inner');

        // Limpiar la lista de imágenes
        listaImagenes.innerHTML = '';

        // Agregar cada imagen al carrusel
        for (let i = 0; i < fileList.length; i++) {
            const item = document.createElement('div');
            item.classList.add('carousel-item');

            const img = document.createElement('img');
            img.src = URL.createObjectURL(fileList[i]);
            img.classList.add('d-block', 'w-100');
            item.appendChild(img);

            listaImagenes.appendChild(item);
        }

        // Establecer el primer elemento como activo
        if (fileList.length > 0) {
            listaImagenes.firstChild.classList.add('active');
        }
    }
</script>

</body>
</html>
