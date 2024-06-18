package org.lab.demo1.daos;

import org.lab.demo1.beans.usuario;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class usuarioDAO extends baseDAO{
    public usuario ValidarUsuario (String user, String pass){
        usuario us = null;
        String sql = "select *from credenciales_usuario where correo=? and contraseña_encriptada=SHA2(?,256)";

        try(Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id =  rs.getInt("idusuario");
                us = this.obtenerUsuario(id);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return us;
    }

    public usuario obtenerUsuario(int id){
        usuario us1 = null;
        String sql1 = "select *from usuario where idusuario=?";
        try(Connection conn1 = this.getConnection();
            PreparedStatement stmt1 = conn1.prepareStatement(sql1)){
            stmt1.setInt(1, id);
            ResultSet rs1 = stmt1.executeQuery();
            while(rs1.next()){
                us1 = new usuario();
                us1.setId(rs1.getInt(1));
                us1.setNombres(rs1.getString(2));
                us1.setApellidos(rs1.getString(3));
                us1.setTelefono(rs1.getInt(4));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return us1;
    }
}
