<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Categoria"%>

<%
Categoria c = (Categoria) request.getAttribute("categoria");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Categoria</title>
</head>
<body>

<h2>Editar Categoria</h2>

<form action="CategoriaServlet" method="post">

    <input type="hidden"
           name="accion"
           value="actualizar">

    <input type="hidden"
           name="id"
           value="<%= c.getId()%>">

    Nombre:

    <input type="text"
           name="nombre"
           value="<%= c.getNombre()%>"
           required>

    <br><br>

    <input type="submit"
           value="Actualizar">

</form>

<br>

<a href="CategoriaServlet?accion=listar">
    Volver
</a>

</body>
</html>