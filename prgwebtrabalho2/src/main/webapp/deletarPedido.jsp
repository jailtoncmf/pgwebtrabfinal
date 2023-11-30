<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.prgwebtrabalho2.model.Pedido" %>
<%@ page import="com.prgwebtrabalho2.dao.PedidoDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Excluir Pedidos</title>
</head>
<body>

    <h1>Excluir Pedidos</h1>

    <form action="DeletarPedidoServlet" method="post">
        <label for="idPedido">ID do Pedido a ser excluído:</label>
        <input type="text" id="idPedido" name="idPedido" required>
        <button type="submit">Excluir</button>
    </form>

    <hr>

    <h2>Listagem de Pedidos</h2>
    <ul>
        <% 
            PedidoDAO pedidoDAO = new PedidoDAO();
            List<Pedido> pedidos = pedidoDAO.listarPedidos();
            for (Pedido pedido : pedidos) {
        %>
            <li>
                ID: <%= pedido.getId() %><br>
                Data: <%= pedido.getData() %><br>
                Entrada: <%= pedido.getEntrada() %><br>
                Principal: <%= pedido.getPrincipal() %><br>
                Sobremesa: <%= pedido.getSobremesa() %><br>
                <!-- Adicione mais detalhes do pedido conforme necessário -->
            </li>
        <% } %>
    </ul>

</body>
</html>
