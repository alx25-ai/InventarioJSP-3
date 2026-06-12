<%@page import="modelo.Producto"%>

<%
Producto p =
(Producto)request.getAttribute("producto");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Producto</title>
</head>
<body>

<h2>Editar Producto</h2>

<form action="ProductoServlet"
      method="post">

<input type="hidden"
       name="accion"
       value="actualizar">

<input type="hidden"
       name="id"
       value="<%=p.getId()%>">

Nombre:

<input type="text"
       name="nombre"
       value="<%=p.getNombre()%>">

<br><br>

Precio:

<input type="number"
       step="0.01"
       name="precio"
       value="<%=p.getPrecio()%>">

<br><br>

Stock:

<input type="number"
       name="stock"
       value="<%=p.getStock()%>">

<br><br>

Categoria ID:

<input type="number"
       name="categoriaId"
       value="<%=p.getCategoriaId()%>">

<br><br>

<input type="submit"
       value="Actualizar">

</form>

</body>
</html>
