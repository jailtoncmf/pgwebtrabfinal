package com.prgwebtrabalho2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.prgwebtrabalho2.model.Pedido;
import com.prgwebtrabalho2.model.Conexao;

public class PedidoDAO {
    private Connection connection;

    public PedidoDAO() {
        this.connection = Conexao.getConexao();
    }

    public void adicionarPedido(Pedido pedido) {
        String sql = "INSERT INTO Pedido (data, entrada, principal, sobremesa) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(pedido.getData().getTime()));
            statement.setInt(2, pedido.getEntrada());
            statement.setInt(3, pedido.getPrincipal());
            statement.setInt(4, pedido.getSobremesa());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }

    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Pedido pedido = new Pedido(
                    resultSet.getInt("id"),
                    resultSet.getDate("data"),
                    resultSet.getInt("entrada"),
                    resultSet.getInt("principal"),
                    resultSet.getInt("sobremesa")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
        return pedidos;
    }

    public void atualizarPedido(Pedido pedido) {
        String sql = "UPDATE Pedido SET data=?, entrada=?, principal=?, sobremesa=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(pedido.getData().getTime()));
            statement.setInt(2, pedido.getEntrada());
            statement.setInt(3, pedido.getPrincipal());
            statement.setInt(4, pedido.getSobremesa());
            statement.setInt(5, pedido.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }

    public void deletarPedido(int id) {
        String sql = "DELETE FROM Pedido WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }
}
