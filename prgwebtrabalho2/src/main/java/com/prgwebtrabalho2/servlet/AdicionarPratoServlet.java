package com.prgwebtrabalho2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.prgwebtrabalho2.dao.PratoDAO;
import com.prgwebtrabalho2.model.Prato;

@WebServlet("/AdicionarPratoServlet")
public class AdicionarPratoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere os parâmetros do formulário
        String nome = request.getParameter("nome");
        String ingredientes = request.getParameter("ingredientes");
        String tipo = request.getParameter("tipo");

        // Crie um objeto Prato com os parâmetros
        Prato novoPrato = new Prato(0, nome, ingredientes, tipo); // O ID será gerado automaticamente pelo banco de dados

        // Chame o método para adicionar o prato ao banco de dados
        PratoDAO pratoDAO = new PratoDAO();
        pratoDAO.adicionarPrato(novoPrato);

        // Redirecione para a página de listagem de pratos ou outra página desejada
        response.sendRedirect("ListarPratosServlet");
    }
}