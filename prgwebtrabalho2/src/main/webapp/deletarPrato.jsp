<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.prgwebtrabalho2.model.Prato" %>
<%@ page import="com.prgwebtrabalho2.dao.PratoDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deletar Prato</title>
</head>
<body>

    <h1>Deletar Prato</h1>

    <form action="DeletarPratoServlet" method="post">
        <label for="idPrato">ID do Prato a ser excluído:</label>
        <input type="text" id="idPrato" name="idPrato" required>
        <button type="submit">Excluir</button>
    </form>

    <hr>

    <h2>Listagem de Pratos</h2>
    <ul>
        <% 
            PratoDAO pratoDAO = new PratoDAO();
            List<Prato> pratos = pratoDAO.listarPratos();
            for (Prato prato : pratos) {
        %>
            <li>
                ID: <%= prato.getId() %><br>
                Nome: <%= prato.getNome() %><br>
                Ingredientes: <%= prato.getIngredientes() %><br>
                Tipo: <%= prato.getTipo() %><br>
                <!-- Adicione mais detalhes do prato conforme necessário -->
            </li>
        <% } %>
    </ul>

</body>
</html>
