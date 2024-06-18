<%--
  Created by IntelliJ IDEA.
  User: CARLOS
  Date: 17/06/2024
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="home">TelitoCar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/AutoServlet">Autos Disponibles</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="historialReservas">Historial de Reservas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=request.getContextPath()%>/MetricaServlet">Métricas</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <c:if test="${not empty sessionScope.usuarioId}">
                <li class="nav-item">
                    <a class="nav-link" href="logout">Cerrar Sesión</a>
                </li>
            </c:if>
            <c:if test="${empty sessionScope.usuarioId}">
                <li class="nav-item">
                    <a class="nav-link" href="login">Iniciar Sesión</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>


<form action="reservarAuto" method="post">
    <label for="fechaInicio">Fecha de Inicio:</label>
    <input type="date" id="fechaInicio" name="fechaInicio" required>

    <label for="fechaFin">Fecha Fin:</label>
    <input type="date" id="fechaFin" name="fechaFin" required>

    <label for="distrito">Distrito:</label>
    <select id="distrito" name="distrito">
        <c:forEach var="distrito" items="${distritos}">
            <option value="${distrito.id}">${distrito.nombre}</option>
        </c:forEach>
    </select>

    <label for="aseguradora">Aseguradora:</label>
    <select id="aseguradora" name="aseguradora">
        <c:forEach var="aseguradora" items="${aseguradoras}">
            <option value="${aseguradora.id}">${aseguradora.nombre} | Tarifa: S/. ${aseguradora.tarifa}</option>
        </c:forEach>
    </select>

    <button type="submit">Guardar Reserva</button>
</form>


</body>
</html>
