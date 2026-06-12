package servlet;

import dao.ProductoDAO;
import modelo.Producto;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {

    ProductoDAO dao = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion =
                request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":

                List<Producto> lista =
                        dao.listar();

                request.setAttribute(
                        "productos",
                        lista);

                request.getRequestDispatcher(
                        "productos.jsp")
                        .forward(request, response);

                break;

            case "editar":

                int id =
                        Integer.parseInt(
                                request.getParameter("id"));

                Producto p =
                        dao.buscar(id);

                request.setAttribute(
                        "producto",
                        p);

                request.getRequestDispatcher(
                        "editarProducto.jsp")
                        .forward(request, response);

                break;

            case "eliminar":

                int idEliminar =
                        Integer.parseInt(
                                request.getParameter("id"));

                dao.eliminar(idEliminar);

                response.sendRedirect(
                        "ProductoServlet?accion=listar");

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion =
                request.getParameter("accion");

        switch (accion) {

            case "guardar":

                Producto p =
                        new Producto();

                p.setNombre(
                        request.getParameter("nombre"));

                p.setPrecio(
                        Double.parseDouble(
                                request.getParameter("precio")));

                p.setStock(
                        Integer.parseInt(
                                request.getParameter("stock")));

                p.setCategoriaId(
                        Integer.parseInt(
                                request.getParameter("categoriaId")));

                dao.agregar(p);

                break;

            case "actualizar":

                Producto prod =
                        new Producto();

                prod.setId(
                        Integer.parseInt(
                                request.getParameter("id")));

                prod.setNombre(
                        request.getParameter("nombre"));

                prod.setPrecio(
                        Double.parseDouble(
                                request.getParameter("precio")));

                prod.setStock(
                        Integer.parseInt(
                                request.getParameter("stock")));

                prod.setCategoriaId(
                        Integer.parseInt(
                                request.getParameter("categoriaId")));

                dao.actualizar(prod);

                break;
        }

        response.sendRedirect(
                "ProductoServlet?accion=listar");
    }
}