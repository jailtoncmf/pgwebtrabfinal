package com.prgwebtrabalho2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prgwebtrabalho2.model.Prato;
import com.prgwebtrabalho2.model.Conexao;

public class PratoDAO {
    private Connection connection;

    public PratoDAO() {
        this.connection = Conexao.getConexao();
    }

    public void adicionarPrato(Prato prato) {
        String sql = "INSERT INTO Prato (nome, ingredientes, tipo) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, prato.getNome());
            statement.setString(2, prato.getIngredientes());
            statement.setString(3, prato.getTipo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }

    public List<Prato> listarPratos() {
        List<Prato> pratos = new ArrayList<>();
        String sql = "SELECT * FROM Prato";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Prato prato = new Prato(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("ingredientes"),
                    resultSet.getString("tipo")
                );
                pratos.add(prato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
        return pratos;
    }

    public void atualizarPrato(Prato prato) {
        String sql = "UPDATE Prato SET nome=?, ingredientes=?, tipo=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, prato.getNome());
            statement.setString(2, prato.getIngredientes());
            statement.setString(3, prato.getTipo());
            statement.setInt(4, prato.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
    }

    public void deletarPrato(int id) {
        String sql = "DELETE FROM Prato WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Prato buscarPratoPorId(int id) {
        String sql = "SELECT * FROM Prato WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Prato prato = new Prato();
                    prato.setId(resultSet.getInt("id"));
                    prato.setNome(resultSet.getString("nome"));
                    prato.setIngredientes(resultSet.getString("ingredientes"));
                    prato.setTipo(resultSet.getString("tipo"));
                    return prato;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Tratar a exceção conforme necessário
        }
        return null; // Retorna null se não encontrar o prato com o ID especificado
    }
}