package com.prgwebtrabalho2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.prgwebtrabalho2.dao.PratoDAO;
import com.prgwebtrabalho2.model.Prato;
import com.prgwebtrabalho2.model.Conexao;

@WebServlet("/ListarPratosServlet")
public class ListarPratosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chame o método para obter a lista de pratos do banco de dados
        PratoDAO pratoDAO = new PratoDAO();
        List<Prato> pratos = pratoDAO.listarPratos();

        // Adicione a lista de pratos ao request para ser exibida na página JSP (ou outro método de visualização)
        request.setAttribute("pratos", pratos);

        // Encaminhe para a página JSP (substitua "listarPratos.jsp" pelo nome correto da sua página)
        request.getRequestDispatcher("menu.jsp").forward(request, response);
        
    }

}