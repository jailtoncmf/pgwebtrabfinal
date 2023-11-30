<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Novo Prato</title>
</head>
<body>
    <h2>Adicionar Novo Prato</h2>

    <form action="AdicionarPratoServlet" method="post">
        <!-- Campos do formulário -->
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required><br>

        <label for="ingredientes">Ingredientes:</label>
        <textarea id="ingredientes" name="ingredientes" required></textarea><br>

        <label for="tipo">Tipo:</label>
        <input type="text" id="tipo" name="tipo" required><br>

        <!-- Botão de envio -->
        <input type="submit" value="Adicionar Prato">
    </form>
</body>
</html>
