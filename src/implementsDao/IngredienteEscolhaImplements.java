package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.IngredienteEscolhaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.IngredienteEscolha;

public class IngredienteEscolhaImplements implements IngredienteEscolhaDao {

    @Override
    public void salvar(IngredienteEscolha ingredienteEscolha) throws SQLException {
        String sql = "INSERT INTO ingrediente_escolha () VALUES ()";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(IngredienteEscolha ingredienteEscolha) throws SQLException {
        String sql = "UPDATE ingrediente_escolha SET ... WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, ingredienteEscolha.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(IngredienteEscolha ingredienteEscolha) throws SQLException {
        String sql = "DELETE FROM ingrediente_escolha WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, ingredienteEscolha.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<IngredienteEscolha> listar() throws SQLException {
        String sql = "SELECT * FROM ingrediente_escolha";
        List<IngredienteEscolha> escolhas = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                IngredienteEscolha ie = new IngredienteEscolha();
                ie.setId(rs.getLong("id"));
                escolhas.add(ie);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return escolhas;
    }

}
