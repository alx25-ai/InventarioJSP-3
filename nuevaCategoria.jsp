<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Nueva Categoria</title>
</head>
<body>

<h2>Registrar Categoria</h2>

<form action="CategoriaServlet"
      method="post">

    <input type="hidden"
           name="accion"
           value="guardar">

    Nombre:

    <input type="text"
           name="nombre"
           required>

    <br><br>

    <input type="submit"
           value="Guardar">

</form>

<br>

<a href="CategoriaServlet?accion=listar">

    Volver

</a>

</body>
</html>
