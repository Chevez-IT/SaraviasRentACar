<%-- ... --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Mensajes</title>
    <style>
        body {
            background-image: url("${pageContext.request.contextPath}/resources/background.jpg");
        }
        .message-container {
            width: 70%;
            margin: 10px auto;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .emisor {
            text-align: right;
            color: white;
            background: linear-gradient(to bottom, darkgoldenrod, goldenrod);
        }

        .receptor {
            text-align: left;
            color: white;
            background: linear-gradient(to bottom, blue, rebeccapurple);
        }

        .mensaje-list {
            display: flex;
            flex-direction: column;
        }

        .mensaje-form {
            margin-top: 20px;
            text-align: center;
        }

        .mensaje-form {
            margin-top: 20px;
            text-align: center;
        }

        .mensaje-form textarea {
            width: 50%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            resize: none;
        }

        .mensaje-form input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .mensaje-form input[type="submit"]:hover {
            background-color: #0056b3;
        }

    </style>
</head>
<body>
<h1>Lista de Mensajes</h1>
<div class="mensaje-list">
    <c:forEach items="${mensajes}" var="mensaje">
        <div class="message-container ${mensaje.usuariosByEmisorMensaje.usuarioId == emisor ? 'emisor' : 'receptor'}">
            <p>${mensaje.usuariosByEmisorMensaje.usuarioId == emisor ? emisor : receptor}</p>
            <p>${mensaje.mensaje}</p>
            <p>${mensaje.fechaCreacion}</p>
            <p>${mensaje.estadoMensaje}</p>
        </div>
    </c:forEach>
</div>
<div class="mensaje-form">
    <form action="<c:url value='/Administrador/createMensaje' />" method="post">
        <input type="hidden" name="emisor" value="${emisor}" />
        <input type="hidden" name="receptor" value="${receptor}" />
        <textarea name="mensaje" rows="3" cols="40"></textarea>
        <br>
        <input type="submit" value="Enviar Mensaje">
    </form>
</div>

<script>
    // Hacer que la página se desplace hacia abajo cuando se carga
    window.onload = function() {
        window.scrollTo(0, document.body.scrollHeight);
    };
</script>
</body>
</html>