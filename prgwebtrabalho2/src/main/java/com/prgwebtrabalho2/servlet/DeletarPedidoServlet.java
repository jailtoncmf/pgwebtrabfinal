package com.prgwebtrabalho2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prgwebtrabalho2.dao.PedidoDAO;

@WebServlet("/DeletarPedidoServlet")
public class DeletarPedidoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere o ID do pedido a ser excluído do formulário
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));

        // Lógica para excluir o pedido no banco de dados
        PedidoDAO pedidoDAO = new PedidoDAO();
        pedidoDAO.deletarPedido(idPedido);

        // Redirecione de volta para a página excluirPedidos.jsp
        response.sendRedirect("deletarPedido.jsp");
    }
}