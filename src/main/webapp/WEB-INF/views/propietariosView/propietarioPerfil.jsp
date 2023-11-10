<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Perfil - Propietario</title>
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

            <div class="px-4 pt-5 my-5 text-center">
                <h1 class="display-4 fw-bold text-body-emphasis">#nombres</h1>
                <div class="col-lg-6 mx-auto">
                    <p class="lead mb-4">¡Mantén tu perfil actualizado para una experiencia óptima! Actualizar tu
                        información es clave para conectarte rápidamente con oportunidades y recibir el mejor servicio
                        posible. Al tener tus detalles más recientes, nuestros expertos pueden ponerte en contacto de
                        manera más rápida y eficiente. No solo facilita la comunicación, sino que también nos permite
                        ofrecerte asistencia personalizada. ¡No subestimes el poder de la información actualizada! Haz
                        que tu perfil refleje lo mejor de ti y permite que podamos estar ahí para apoyarte de la mejor
                        manera posible.</p>
                </div>
            </div>

            <div class="b-example-divider" style="width: 100%;height: 3rem;background-color: rgba(0, 0, 0, .1);border: solid rgba(0, 0, 0, .15);border-width: 1px 0;box-shadow: inset 0 0.5em 1.5em rgba(0, 0, 0, .1), inset 0 0.125em 0.5em rgba(0, 0, 0, .15);"></div>

            <div class="px-3 pt-3 my-2 text-center">
                <h1 class="display-4 fw-bold text-body-emphasis">Mi Perfil</h1>
                <hr class="border border-dark border-2 opacity-50">
            </div>

            <div class="container text-center">
                <div class="row">
                    <div class="col-12 col-md-5">
                        <form>
                            <div class="card shadow">
                                <h5 class="card-header">Mi Imagen</h5>
                                <div class="card-body">
                                    <img src="" class="img-fluid rounded-circle" style="width: 80%;"
                                         alt="Imagen Redonda">
                                    <br>
                                    <div class="mb-3">
                                        <input class="form-control" type="file" id="formFile"
                                               placeholder="Nueva Imagen">
                                    </div>
                                </div>
                                <div class="card-footer d-flex gap-3 justify-content-center">
                                    <button class="btn btn-outline-primary btn-lg">Actualizar imagen</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-12 col-md-7">
                        <form>
                            <div class="card shadow">
                                <h5 class="card-header">Mi informacion</h5>
                                <div class="card-body">
                                    <div class="mb-3">
                                        <label for="inputUsuario" class="form-label">Nombre de Usuario</label>
                                        <input type="text" class="form-control" id="inputUsuario"
                                               placeholder="Example input placeholder">
                                    </div>
                                    <div class="row">
                                        <div class="col mb-3">
                                            <label for="inputNombres" class="form-label">Nombres</label>
                                            <input type="text" class="form-control" id="inputNombres"
                                                   placeholder="Nombres">
                                        </div>
                                        <div class="col mb-3">
                                            <label for="inputApellidos" class="form-label">Apellidos</label>
                                            <input type="text" class="form-control" id="inputApellidos"
                                                   placeholder="Apellidos">
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="inputDui" class="form-label">DUI:</label>
                                        <input type="text" class="form-control" id="inputDui" placeholder="09127321-2">
                                    </div>
                                    <div class="mb-3">
                                        <label for="inputCorreo" class="form-label">Correo</label>
                                        <input type="text" class="form-control" id="inputCorreo"
                                               placeholder="fulano@gmail.com">
                                    </div>
                                    <div class="mb-3">
                                        <label for="inputTelefono" class="form-label">Telefono</label>
                                        <input type="text" class="form-control" id="inputTelefono"
                                               placeholder="1234-1234">
                                    </div>
                                    <div class="mb-3">
                                        <label for="inputDireccion" class="form-label">Direccion/Ubicacion</label>
                                        <textarea class="form-control" id="inputDireccion" rows="3"></textarea>
                                    </div>
                                </div>
                                <div class="card-footer d-flex gap-3 justify-content-center">
                                    <button class="btn btn-outline-primary">Actualizar Informacion</button>
                                    <button class="btn btn-outline-secondary">Cambiar contraseña</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>


            <!-- Footer -->
            <div id="Footer" class="col-12 mt-5">
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