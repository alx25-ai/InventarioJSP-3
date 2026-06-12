package dao;

import conexion.Conexion;
import modelo.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public boolean agregar(Categoria c){

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "INSERT INTO categorias(nombre) VALUES(?)";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setString(1,c.getNombre());

            return ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();
        }

        return false;
    }

    public List<Categoria> listar(){

        List<Categoria> lista =
                new ArrayList<>();

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "SELECT * FROM categorias";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Categoria c = new Categoria();

                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));

                lista.add(c);
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return lista;
    }

    public Categoria buscar(int id){

        Categoria c = null;

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "SELECT * FROM categorias WHERE id=?";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                c = new Categoria();

                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return c;
    }

    public boolean actualizar(Categoria c){

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "UPDATE categorias SET nombre=? WHERE id=?";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setString(1,c.getNombre());
            ps.setInt(2,c.getId());

            return ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();
        }

        return false;
    }

    public boolean eliminar(int id){

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "DELETE FROM categorias WHERE id=?";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setInt(1,id);

            return ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();
        }

        return false;
    }
}
