package org.lab.demo1.servers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.lab.demo1.beans.reserva;
import org.lab.demo1.beans.usuario;
import org.lab.demo1.daos.autoDAO;
import org.lab.demo1.daos.usuarioDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet(name = "la-servlet", value = "/ServletLogin")

public class ServletLogin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "loginform" : request.getParameter("action");

        RequestDispatcher view;
        switch (action) {
            case "loginform":
                view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
                break;
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usuarioDAO usuarioDAO = new usuarioDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        usuario u =  usuarioDAO.ValidarUsuario(username, password);
        if(u != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSession", u);
            response.sendRedirect("AutoServlet");
        } else{
            response.sendRedirect("ServletLogin?action=error");
        }

    }
}
