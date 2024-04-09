package repositories;

import entities.Time;
import exceptions.DBException;
import infra.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeRepository {
    private static final DBConnection DB_CONNECTION = new DBConnection();

    public TimeRepository() {
    }

    public List<Time> findAll() {
        //editar query
        String query = "SELECT nome, acro, nivel, estado, pontos_liga, gols_marcados, gols_sofridos, vitorias, empates, derrotas, saldo FROM Time ORDER BY id";
        
        try (
                Connection connection = DB_CONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()
        ) {
            List<Time> times = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String acronimo = resultSet.getString("acronimo");
                int nivel = resultSet.getInt("nivel");
                String estado = resultSet.getString("estado");
                int pontos_liga = resultSet.getInt("pontos_liga");
                int gols_marcados = resultSet.getInt("gols_marcados");
                int gols_sofridos = resultSet.getInt("gols_sofridos");
                int vitorias = resultSet.getInt("vitorias");
                int empates = resultSet.getInt("empates");
                int derrotas = resultSet.getInt("derrotas");
                int saldo = resultSet.getInt("saldo");

                //criar construtor
                Time time = new Time(id, nome, acronimo, nivel, estado, pontos_liga, gols_marcados, gols_sofridos, vitorias, empates, derrotas, saldo);
                times.add(time);
            }

            return times;
        } catch (SQLException e) {
            throw new DBException("Erro ao buscar: " + e.getMessage());
        }
    }

    public void insert(Time time) {
        String query = "INSERT INTO Time(nome, acro, nivel, estado, pontos_liga, gols_marcados, gols_sofridos, vitorias, empates, derrotas, saldo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                Connection connection = DB_CONNECTION.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            ps.setString(1, time.getNome());
            ps.setString(2, time.getAcronimo());
            ps.setInt(3, time.getNivel());
            ps.setString(4, time.getEstado());
            ps.setInt(5, time.getPontosLiga());
            ps.setInt(6, time.getGolsMarcados());
            ps.setInt(7, time.getGolsMarcados());
            ps.setInt(8, time.getVitorias());
            ps.setInt(9, time.getEmpates());
            ps.setInt(10, time.getDerrotas());
            ps.setInt(11, time.getSaldoDeGols());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Erro ao inserir: " + e.getMessage());
        }
    }

    public void update(Time time) {
        String query = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
        try (
                Connection connection = DB_CONNECTION.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)
        ) {
            ps.setString(1, time.getNome());
            ps.setString(2, time.getAcronimo());
            ps.setInt(3, time.getNivel());
            ps.setString(4, time.getEstado());
            ps.setInt(5, time.getPontosLiga());
            ps.setInt(6, time.getGolsMarcados());
            ps.setInt(7, time.getGolsMarcados());
            ps.setInt(8, time.getVitorias());
            ps.setInt(9, time.getEmpates());
            ps.setInt(10, time.getDerrotas());
            ps.setInt(11, time.getSaldoDeGols());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated == 0) {
                throw new DBException("Nenhuma Time foi atualizada. Verifique se o ID é válido.");
            }
        } catch (SQLException e) {
            throw new DBException("Erro ao atualizar: " + e.getMessage());
        }
    }

    public void delete(int Time_id) {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try (
                Connection connection = DB_CONNECTION.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, Time_id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0) {
                throw new DBException("Nenhuma Time foi deletada. Verifique se o ID é válido.");
            }
        } catch (SQLException e) {
            throw new DBException("Erro ao deletar: " + e.getMessage());
        }
    }
}

