<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.prgwebtrabalho2.model.Prato" %>
<%@ page import="com.prgwebtrabalho2.dao.PratoDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
    <h1>Menu</h1>
    <ul>
        <% PratoDAO pratoDAO = new PratoDAO();
           List<Prato> pratos = pratoDAO.listarPratos();
           for (Prato prato : pratos) { %>
               <li><%= prato.getNome() %></li>
        <% } %>
    </ul>
</body>
</html>

