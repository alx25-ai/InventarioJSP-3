<!DOCTYPE html>
<html>
<head>
    <title>Nuevo Producto</title>
</head>
<body>

<h2>Registrar Producto</h2>

<form action="ProductoServlet"
      method="post">

<input type="hidden"
       name="accion"
       value="guardar">

Nombre:

<input type="text"
       name="nombre">

<br><br>

Precio:

<input type="number"
       step="0.01"
       name="precio">

<br><br>

Stock:

<input type="number"
       name="stock">

<br><br>

Categoria ID:

<input type="number"
       name="categoriaId">

<br><br>

<input type="submit"
       value="Guardar">

</form>

</body>
</html>
