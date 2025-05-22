package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.IngredienteRemoverDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.IngredienteEscolha;
import model.IngredienteRemover;

public class IngredienteRemoverImplements implements IngredienteRemoverDao {

    @Override
    public void salvar(IngredienteRemover ingredienteRemover) throws SQLException {
        String sql = "INSERT INTO ingrediente_revomer (nome, ingrediente_escolha_id) VALUES (?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ingredienteRemover.getNome());
            ps.setLong(2, ingredienteRemover.getIngredienteEscolhas().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(IngredienteRemover ingredienteRemover) throws SQLException {
        String sql = "UPDATE ingrediente_revomer SET nome = ?, ingrediente_escolha_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ingredienteRemover.getNome());
            ps.setLong(2, ingredienteRemover.getIngredienteEscolhas().getId());
            ps.setLong(3, ingredienteRemover.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(IngredienteRemover ingredienteRemover) throws SQLException {
        String sql = "DELETE FROM ingrediente_revomer WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, ingredienteRemover.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<IngredienteRemover> listar() throws SQLException {
        String sql = "SELECT * FROM ingrediente_revomer";
        List<IngredienteRemover> removers = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                IngredienteRemover ir = new IngredienteRemover();
                ir.setId(rs.getLong("id"));
                ir.setNome(rs.getString("nome"));

                IngredienteEscolha ie = new IngredienteEscolha();
                ie.setId(rs.getLong("ingrediente_escolha_id"));
                ir.setIngredienteEscolhas(ie);

                removers.add(ir);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return removers;
    }

}
