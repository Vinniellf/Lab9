<%--
  Created by IntelliJ IDEA.
  User: CARLOS
  Date: 17/06/2024
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.lab.demo1.dtos.metricaDto" %>
<%@page import="java.util.ArrayList" %>
<jsp:useBean id="metricas" type="java.util.ArrayList<org.lab.demo1.dtos.metricaDto>" scope="request"/>
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

<table border = "1">
    <thead>
    <tr>
        <th>#</th>
        <th>Empresa Aseguradora</th>
        <th>Cantidad de Autos Alquilados</th>
        <th>Suma de Tarifas Pagadas</th>
        <th>Suma Total Pagada</th>
    </tr>
    </thead>
    <%
        int i = 1;
        for (metricaDto a : metricas) {
    %>
    <tr>
        <td><%= i%></td>
        <td><%= a.getAseguradora()%></td>
        <td><%= a.getCantidadAutos()%></td>
        <td><%= a.getSumaTarifas()%></td>
        <td><%= a.getSumaTotalPagada()%></td>
    </tr>
    <%
            i++;
        }
    %>
</table>


</body>
</html>
