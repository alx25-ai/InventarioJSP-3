package dao;

import conexion.Conexion;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario validar(String usuario, String clave) {

        Usuario u = null;

        try {

            System.out.println("Usuario recibido: " + usuario);
            System.out.println("Clave recibida: " + clave);

            Connection cn = Conexion.getConexion();

            System.out.println("Conexion = " + cn);

            String sql =
                "SELECT * FROM usuarios";

            PreparedStatement ps =
                    cn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                System.out.println(
                    rs.getInt("id") + " - " +
                    rs.getString("usuario") + " - " +
                    rs.getString("clave")
                );
            }

            sql =
            "SELECT * FROM usuarios WHERE usuario=? AND clave=?";

            ps = cn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, clave);

            rs = ps.executeQuery();

            if(rs.next()){

                System.out.println("LOGIN ENCONTRADO");

                u = new Usuario();

                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setClave(rs.getString("clave"));

            }else{

                System.out.println("LOGIN NO ENCONTRADO");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return u;
    }
}