package repositories;

import entities.Confederacao;
import exceptions.DBException;
import infra.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConfederacaoRepository {
    private static final DBConnection DB_CONNECTION = new DBConnection();

    public ConfederacaoRepository() {
    }

    public List<Confederacao> findAll() {
        //editar query
        String query = "SELECT id, nome, email FROM usuarios ORDER BY id";
        try (
                Connection connection = DB_CONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()
        ) {
            List<Confederacao> confederacoes = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                Confederacao confederacao = new Confederacao(id, nome, email);
                confederacoes.add(Confederacao);
            }

            return confederacoes;
        } catch (SQLException e) {
            throw new DBException("Erro ao buscar: " + e.getMessage());
        }
    }

    public void insert(Confederacao confederacao) {
        String query = "INSERT INTO confederacao (nome, email) VALUES (?, ?)";
        try (
                Connection connection = DB_CONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, confederacao.getNome());
            statement.setString(2, confederacao.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao inserir: " + e.getMessage());
        }
    }

    public void update(Confederacao confederacao) {
        String query = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
        try (
                Connection connection = DB_CONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setString(1, confederacao.getNome());
            statement.setString(2, confederacao.getEmail());
            statement.setInt(3, confederacao.getId());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new DBException("Nenhuma confederacao foi atualizada. Verifique se o ID é válido.");
            }
        } catch (SQLException e) {
            throw new DBException("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void delete(int confederacao_id) {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (
                Connection connection = DB_CONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, confederacao_id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                throw new DBException("Nenhuma confederacao foi deletada. Verifique se o ID é válido.");
            }
        } catch (SQLException e) {
            throw new DBException("Erro ao deletar: " + e.getMessage());
        }
    }
}
