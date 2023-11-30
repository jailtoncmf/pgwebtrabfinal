package com.prgwebtrabalho2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prgwebtrabalho2.dao.PratoDAO;

@WebServlet("/DeletarPratoServlet")
public class DeletarPratoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere o ID do prato a ser excluído do formulário
        int idPrato = Integer.parseInt(request.getParameter("idPrato"));

        // Lógica para excluir o prato no banco de dados
        PratoDAO pratoDAO = new PratoDAO();
        pratoDAO.deletarPrato(idPrato);

        // Redirecione de volta para a página deletarPrato.jsp
        response.sendRedirect("deletarPrato.jsp");
    }
}



