<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Novo Pedido</title>
</head>
<body>
    <h2>Novo Pedido</h2>
    <form action="AdicionarPedidoServlet" method="post">
        Data: <input type="date" name="data" required><br>
        Entrada: <input type="number" name="entrada" required><br>
        Principal: <input type="number" name="principal" required><br>
        Sobremesa: <input type="number" name="sobremesa" required><br>
        <input type="submit" value="Adicionar Pedido">
    </form>
</body>
</html>
