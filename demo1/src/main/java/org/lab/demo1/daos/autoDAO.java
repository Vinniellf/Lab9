package org.lab.demo1.daos;

import org.lab.demo1.beans.reserva;
import org.lab.demo1.dtos.autoDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class autoDAO extends baseDAO{
    public List<autoDto> obtenerAutos() {
        List<autoDto> autos = new ArrayList<>();
        String sql = "SELECT a.idauto, a.modelo, a.color, a.kilometraje, a.costo_por_dia, s.distrito " +
                "FROM auto a JOIN sede s ON a.sede_idsede = s.idsede";

        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                autoDto auto = new autoDto();
                auto.setId(rs.getInt("idauto"));
                auto.setModelo(rs.getString("modelo"));
                auto.setColor(rs.getString("color"));
                auto.setKilometraje(rs.getInt("kilometraje"));
                auto.setCosto_por_dia(rs.getDouble("costo_por_dia"));
                auto.setDistrito(rs.getString("distrito"));
                autos.add(auto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autos;
    }

    public void insertarReserva (reserva reserva) {
        String sql = "INSERT INTO renta_auto (auto_idauto, usuario_idusuario, seguro_idseguro, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reserva.getAuto_idauto());
            pstmt.setInt(2, reserva.getSeguro_idseguro());
            pstmt.setInt(3, reserva.getSeguro_idseguro());
            pstmt.setString(4, reserva.getFecha_inicio());
            pstmt.setString(5, reserva.getFecha_fin());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
