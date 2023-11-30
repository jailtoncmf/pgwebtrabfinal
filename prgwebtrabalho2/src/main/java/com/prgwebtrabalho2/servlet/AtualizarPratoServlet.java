package com.prgwebtrabalho2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.prgwebtrabalho2.dao.PratoDAO;
import com.prgwebtrabalho2.model.Prato;

@WebServlet("/AtualizarPratoServlet")
public class AtualizarPratoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere o ID do prato a ser atualizado a partir dos parâmetros da URL
        int idPrato = Integer.parseInt(request.getParameter("id"));

        // Recupere as informações atuais do prato do banco de dados
        PratoDAO pratoDAO = new PratoDAO();
        Prato prato = pratoDAO.buscarPratoPorId(idPrato);

        // Adicione o prato ao request para ser exibido no formulário JSP
        request.setAttribute("prato", prato);

        // Encaminhe para a página JSP de atualização de prato
        request.getRequestDispatcher("atualizarPrato.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere os parâmetros do formulário
        int idPrato = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String ingredientes = request.getParameter("ingredientes");
        String tipo = request.getParameter("tipo");

        // Crie um objeto Prato com as informações atualizadas
        Prato pratoAtualizado = new Prato(idPrato, nome, ingredientes, tipo);

        // Atualize o prato no banco de dados
        PratoDAO pratoDAO = new PratoDAO();
        pratoDAO.atualizarPrato(pratoAtualizado);

        // Redirecione para a página de listagem de pratos ou outra página desejada
        response.sendRedirect("ListarPratosServlet");
    }
}