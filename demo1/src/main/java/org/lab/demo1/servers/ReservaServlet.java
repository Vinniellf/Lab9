package org.lab.demo1.servers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.lab.demo1.beans.reserva;
import org.lab.demo1.daos.autoDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "actor-servlet", value = "/ReservaServlet")
public class ReservaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        autoDAO autoDAO = new autoDAO();
        reserva r = new reserva();
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        int usuarioId = Integer.parseInt(request.getParameter("iduusuario"));
        int aseguradoraId = Integer.parseInt(request.getParameter("idaseguradora"));
        int autoId = Integer.parseInt(request.getParameter("autoId"));

        r.setAuto_idauto(autoId);
        r.setSeguro_idseguro(aseguradoraId);
        r.setUsuario_idusuario(usuarioId);
        r.setFecha_inicio(fechaInicio);
        r.setFecha_fin(fechaFin);

        response.sendRedirect("historialReservas");
    }

}