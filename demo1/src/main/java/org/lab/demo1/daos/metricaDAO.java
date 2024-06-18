package org.lab.demo1.daos;

import org.lab.demo1.dtos.metricaDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class metricaDAO extends baseDAO{
    public List<metricaDto> obtenerMetricasPorUsuario(int usuarioId) {
        List<metricaDto> metricas = new ArrayList<>();
        String sql = "SELECT s.empresa_aseguradora AS aseguradora, COUNT(r.id_renta) AS cantidad_autos, SUM(s.tarifa) AS suma_tarifas, \n" +
                "                SUM(s.tarifa + a.costo_por_dia) AS suma_total_pagada \n" +
                "                FROM renta_auto r JOIN seguro s ON r.seguro_idseguro = s.idseguro\n" +
                "                JOIN auto a ON r.auto_idauto = a.idauto\n" +
                "                WHERE r.usuario_idusuario = ? GROUP BY s.empresa_aseguradora ORDER BY suma_total_pagada DESC";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                metricaDto metrica = new metricaDto();
                metrica.setAseguradora(rs.getString("aseguradora"));
                metrica.setCantidadAutos(rs.getInt("cantidad_autos"));
                metrica.setSumaTarifas(rs.getDouble("suma_tarifas"));
                metrica.setSumaTotalPagada(rs.getDouble("suma_total_pagada"));
                metricas.add(metrica);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return metricas;
    }

}
