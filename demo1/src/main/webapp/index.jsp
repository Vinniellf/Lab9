<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: #f5f5f5;
        }
        .form-signin {
            width: 100%;
            max-width: 330px;
            padding: 15px;
            margin: auto;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="text"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
        .btn-primary {
            background-color: #33CCFF;
            border: none;
        }
        .btn-primary:hover {
            background-color: #1ea1e9;
        }
    </style>
    <title>Ingreso al Sistema</title>
</head>
<body>
<form class="form-signin" method="post" action="<%=request.getContextPath()%>/ServletLogin">
    <h1 class="h3 mb-3 font-weight-normal">Ingreso al Sistema</h1>
    <input type="text" name="username" class="form-control" placeholder="Correo" required autofocus>
    <input type="password" name="password" class="form-control" placeholder="Password" required>
    <% if (request.getParameter("info") != null) { %>
    <div class="text-danger mb-2">Error en Usuario o Contraseña</div>
    <% } %>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>
</form>
</body>
</html>
