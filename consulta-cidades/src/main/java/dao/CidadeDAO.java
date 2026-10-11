package dao;

import model.Cidade;
import model.Estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    public List<Cidade> listarCidade() {
        List<Cidade> cidades = new ArrayList<>();

        String sql = "select c.nome as cidade, e.nome as estado, e.sigla as sigla " +
                "from cidade c " +
                "inner join estado on e.id = c.id_estado";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setNome(rs.getString("estado"));
                estado.setSigla(rs.getString("sigla"));

                Cidade cidade = new Cidade();
                cidade.setNome(rs.getString("cidade"));
                cidade.setEstado(estado);

                cidades.add(cidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cidades;
    }
}