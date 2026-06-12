<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <style>

        body{
            font-family: Arial;
            background:#f4f4f4;
        }

        .contenedor{
            width:300px;
            margin:100px auto;
            background:white;
            padding:20px;
            border-radius:10px;
        }

        input{
            width:100%;
            margin-bottom:10px;
            padding:8px;
        }

    </style>

</head>
<body>

<div class="contenedor">

    <h2>Iniciar Sesion</h2>

    <form action="LoginServlet" method="post">

        Usuario:

        <input type="text"
               name="usuario"
               required>

        Clave:

        <input type="password"
               name="clave"
               required>

        <input type="submit"
               value="Ingresar">

    </form>

</div>

</body>
</html>