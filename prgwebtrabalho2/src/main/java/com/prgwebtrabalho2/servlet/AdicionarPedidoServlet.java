package com.prgwebtrabalho2.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prgwebtrabalho2.dao.PedidoDAO;
import com.prgwebtrabalho2.model.Pedido;

@WebServlet("/AdicionarPedidoServlet")
public class AdicionarPedidoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Recupere os parâmetros do formulário
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date data = dateFormat.parse(request.getParameter("data"));
            int entrada = Integer.parseInt(request.getParameter("entrada"));
            int principal = Integer.parseInt(request.getParameter("principal"));
            int sobremesa = Integer.parseInt(request.getParameter("sobremesa"));

            // Crie um objeto Pedido com os parâmetros
            Pedido novoPedido = new Pedido(0, data, entrada, principal, sobremesa); // O ID será gerado automaticamente pelo banco de dados

            // Chame o método para adicionar o pedido ao banco de dados
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.adicionarPedido(novoPedido);

            // Redirecione para a página de listagem de pedidos ou outra página desejada
            response.sendRedirect("ListarPedidosServlet");
        } catch (ParseException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }
}