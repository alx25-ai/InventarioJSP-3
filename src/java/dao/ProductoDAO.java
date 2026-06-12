package dao;

import conexion.Conexion;
import modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public boolean agregar(Producto p){

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "INSERT INTO productos(nombre,precio,stock,categoria_id) "
          + "VALUES(?,?,?,?)";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setString(1,p.getNombre());
            ps.setDouble(2,p.getPrecio());
            ps.setInt(3,p.getStock());
            ps.setInt(4,p.getCategoriaId());

            return ps.executeUpdate()>0;

        }catch(Exception e){

            e.printStackTrace();
        }

        return false;
    }

    public List<Producto> listar(){

        List<Producto> lista =
                new ArrayList<>();

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "SELECT * FROM productos";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Producto p = new Producto();

                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCategoriaId(
                        rs.getInt("categoria_id"));

                lista.add(p);
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return lista;
    }

    public Producto buscar(int id){

        Producto p = null;

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "SELECT * FROM productos WHERE id=?";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                p = new Producto();

                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setCategoriaId(
                        rs.getInt("categoria_id"));
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return p;
    }

    public boolean actualizar(Producto p){

        try{

            Connection cn = Conexion.getConexion();

            String sql =
            "UPDATE productos SET "
          + "nombre=?,precio=?,stock=?,categoria_id=? "
          + "WHERE id=?";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ps.setString(1,p.getNombre());
            ps.setDouble(2,p.getPrecio());
            ps.setInt(3,p.getStock());
            ps.setInt(4,p.getCategoriaId());
            ps.setInt(5,p.getId());

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
            "DELETE FROM productos WHERE id=?";

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