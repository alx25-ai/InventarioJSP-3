package servlet;

import dao.CategoriaDAO;
import modelo.Categoria;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {

    CategoriaDAO dao = new CategoriaDAO();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":

                List<Categoria> lista =
                        dao.listar();

                request.setAttribute(
                        "categorias",
                        lista
                );

                request.getRequestDispatcher(
                        "categorias.jsp")
                        .forward(request, response);

                break;

            case "editar":

                int id =
                        Integer.parseInt(
                                request.getParameter("id"));

                Categoria c =
                        dao.buscar(id);

                request.setAttribute(
                        "categoria",
                        c
                );

                request.getRequestDispatcher(
                        "editarCategoria.jsp")
                        .forward(request, response);

                break;

            case "eliminar":

                int idEliminar =
                        Integer.parseInt(
                                request.getParameter("id"));

                dao.eliminar(idEliminar);

                response.sendRedirect(
                        "CategoriaServlet?accion=listar");

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

                Categoria c =
                        new Categoria();

                c.setNombre(
                        request.getParameter("nombre"));

                dao.agregar(c);

                break;

            case "actualizar":

                Categoria cat =
                        new Categoria();

                cat.setId(
                        Integer.parseInt(
                                request.getParameter("id")));

                cat.setNombre(
                        request.getParameter("nombre"));

                dao.actualizar(cat);

                break;
        }

        response.sendRedirect(
                "CategoriaServlet?accion=listar");
    }
}
