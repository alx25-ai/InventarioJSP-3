<%@page import="java.util.List"%>
<%@page import="modelo.Producto"%>

<%
List<Producto> lista =
(List<Producto>)
request.getAttribute("productos");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Productos</title>
</head>
<body>

<h2>Listado Productos</h2>

<a href="nuevoProducto.jsp">

Nuevo Producto

</a>

<table border="1">

<tr>

<th>ID</th>
<th>Nombre</th>
<th>Precio</th>
<th>Stock</th>
<th>Categoria</th>
<th>Acciones</th>

</tr>

<%
for(Producto p : lista){
%>

<tr>

<td><%=p.getId()%></td>

<td><%=p.getNombre()%></td>

<td><%=p.getPrecio()%></td>

<td><%=p.getStock()%></td>

<td><%=p.getCategoriaId()%></td>

<td>

<a href="ProductoServlet?accion=editar&id=<%=p.getId()%>">

Editar

</a>

|

<a href="ProductoServlet?accion=eliminar&id=<%=p.getId()%>">

Eliminar

</a>

</td>

</tr>

<%
}
%>

</table>

<br>

<a href="menu.jsp">
Menu
</a>

</body>
</html>
