<%@page import="java.util.List"%>
<%@page import="modelo.Categoria"%>

<%
List<Categoria> lista =
(List<Categoria>)
request.getAttribute("categorias");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Categorias</title>
</head>
<body>

<h2>Listado Categorias</h2>

<a href="nuevaCategoria.jsp">
    Nueva Categoria
</a>

<table border="1">

<tr>
    <th>ID</th>
    <th>Nombre</th>
    <th>Acciones</th>
</tr>

<%
for(Categoria c : lista){
%>

<tr>

<td><%=c.getId()%></td>

<td><%=c.getNombre()%></td>

<td>

<a href="CategoriaServlet?accion=editar&id=<%=c.getId()%>">

Editar

</a>

|

<a href="CategoriaServlet?accion=eliminar&id=<%=c.getId()%>">

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
