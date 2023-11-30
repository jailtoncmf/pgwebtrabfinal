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

@WebServlet("/AtualizarPedidoServlet")
public class AtualizarPedidoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupere os parâmetros do formulário
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        String novaDataStr = request.getParameter("novaData");
        int novaEntrada = Integer.parseInt(request.getParameter("novaEntrada"));
        int novoPrincipal = Integer.parseInt(request.getParameter("novoPrincipal"));
        int novaSobremesa = Integer.parseInt(request.getParameter("novaSobremesa"));
        // Recupere outros campos conforme necessário

        // Converta a String da data para java.util.Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date novaData = null;
        try {
            novaData = dateFormat.parse(novaDataStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Lide com a exceção conforme necessário
        }

        // Lógica para atualizar o pedido no banco de dados
        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido pedido = new Pedido(idPedido, novaData, novaEntrada, novoPrincipal, novaSobremesa /* outros campos */);
        pedidoDAO.atualizarPedido(pedido);

        // Redirecione para a página atualizarPedido.jsp ou outra página desejada
        response.sendRedirect("atualizarPedido.jsp");
    }
}


