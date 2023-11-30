<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Atualizar Prato</title>
</head>
<body>
    <h2>Atualizar Prato</h2>

    <form action="AtualizarPratoServlet" method="post">
        ID do Prato a ser Atualizado: <input type="text" name="id" required><br>
        
        Nome: <input type="text" name="nome" required><br>
        Ingredientes: <input type="text" name="ingredientes" required><br>
        Tipo: <input type="text" name="tipo" required><br>
        
        <input type="submit" value="Atualizar Prato">
    </form>
</body>
</html>
