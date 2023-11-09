<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Saravia's Rent a Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body class="text-center">
<jsp:include page="/WEB-INF/views/webView/menu.jsp"/>

<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="${pageContext.request.contextPath}/resources/images/c1.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/resources/images/c2.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/resources/images/c3.jpg" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>
<br>
    <div class="container align-content-center text-center">
        <div class="row text-center">
            <div class="col">
                <div class="col-6">
                    <div class="card" style="width: 18rem;">
                        <img src="${pageContext.request.contextPath}/resources/images/1.jpg" class="card-img-top" alt="..." style="height: 220px;">
                        <div class="card-body">
                            <h5 class="card-title">Toyota Prado 2017</h5>
                            <p class="card-text">$80.00</p>
                            <a href="#" class="btn btn-primary">Alquilar ahora</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="col-6">
                    <div class="card" style="width: 18rem;">
                        <img src="${pageContext.request.contextPath}/resources/images/2.jpg" class="card-img-top" alt="..." style="height: 220px;">
                        <div class="card-body">
                            <h5 class="card-title">Nissan Rouge 2016</h5>
                            <p class="card-text">$45.00</p>
                            <a href="#" class="btn btn-primary">Alquilar ahora</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="col-6">
                    <div class="card" style="width: 18rem;">
                        <img src="${pageContext.request.contextPath}/resources/images/3.jpg" class="card-img-top" alt="..." style="height: 220px;">
                        <div class="card-body">
                            <h5 class="card-title">Kia Sedona 2016</h5>
                            <p class="card-text">$49.00</p>
                            <a href="#" class="btn btn-primary">Alquilar ahora</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<br>
        <div class="row text-center">
            <div class="col">
                <div class="col-6">
                    <div class="card" style="width: 18rem;">
                        <img src="${pageContext.request.contextPath}/resources/images/4.jpg" class="card-img-top" alt="..." style="height: 220px;">
                        <div class="card-body">
                            <h5 class="card-title">Kia Sorento 2016</h5>
                            <p class="card-text">$59.00</p>
                            <a href="#" class="btn btn-primary">Alquilar ahora</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="col-6">
                    <div class="card" style="width: 18rem;">
                        <img src="${pageContext.request.contextPath}/resources/images/5.jpg" class="card-img-top" alt="..." style="height: 220px;">
                        <div class="card-body">
                            <h5 class="card-title">Kia Sorento 2016</h5>
                            <p class="card-text">$59.00</p>
                            <a href="#" class="btn btn-primary">Alquilar ahora</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col">
                <div class="col-6">
                    <div class="card" style="width: 18rem;">
                        <img src="${pageContext.request.contextPath}/resources/images/6.jpg" class="card-img-top" alt="..." style="height: 220px;">
                        <div class="card-body">
                            <h5 class="card-title">Kia Soul 2014</h5>
                            <p class="card-text">$29.00</p>
                            <a href="#" class="btn btn-primary">Alquilar ahora</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<br>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
<jsp:include page="/WEB-INF/views/webView/pie.jsp"/>
</html>
