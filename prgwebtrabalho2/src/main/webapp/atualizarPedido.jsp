<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.prgwebtrabalho2.model.Pedido" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Pedido</title>
</head>
<body>

    <h1>Atualizar Pedido</h1>

    <form action="AtualizarPedidoServlet" method="post">
        <label for="idPedido">ID do Pedido a ser atualizado:</label>
        <input type="text" id="idPedido" name="idPedido" required>
        <br>
        <label for="novaData">Nova Data:</label>
        <input type="text" id="novaData" name="novaData" required>
        <br>
        <label for="novaEntrada">Nova Entrada:</label>
        <input type="text" id="novaEntrada" name="novaEntrada" required>
        <br>
        <label for="novoPrincipal">Novo Principal:</label>
        <input type="text" id="novoPrincipal" name="novoPrincipal" required>
        <br>
        <label for="novaSobremesa">Nova Sobremesa:</label>
        <input type="text" id="novaSobremesa" name="novaSobremesa" required>
        <br>
        <br>
        <button type="submit">Atualizar</button>
    </form>

</body>
</html>
