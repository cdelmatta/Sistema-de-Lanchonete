package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.IngredienteAdicionalDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.IngredienteAdicional;
import model.IngredienteEscolha;

public class IngredientesAdicionalImplements implements IngredienteAdicionalDao {

    @Override
    public void salvar(IngredienteAdicional ingredienteAdicional) throws SQLException {
        String sql = "INSERT INTO ingrediente_adicional (nome, valor, ingrediente_escolha_id) VALUES (?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ingredienteAdicional.getNome());
            ps.setDouble(2, ingredienteAdicional.getValor());
            ps.setLong(3, ingredienteAdicional.getIngredienteEscolhas().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(IngredienteAdicional ingredienteAdicional) throws SQLException {
        String sql = "UPDATE ingrediente_adicional SET nome = ?, valor = ?, ingrediente_escolha_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ingredienteAdicional.getNome());
            ps.setDouble(2, ingredienteAdicional.getValor());
            ps.setLong(3, ingredienteAdicional.getIngredienteEscolhas().getId());
            ps.setLong(4, ingredienteAdicional.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(IngredienteAdicional ingredienteAdicional) throws SQLException {
        String sql = "DELETE FROM ingrediente_adicional WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, ingredienteAdicional.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<IngredienteAdicional> listar() throws SQLException {
        String sql = "SELECT * FROM ingrediente_adicional";
        List<IngredienteAdicional> ingredientes = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                IngredienteAdicional ia = new IngredienteAdicional();
                ia.setId(rs.getLong("id"));
                ia.setNome(rs.getString("nome"));
                ia.setValor(rs.getDouble("valor"));

                IngredienteEscolha ie = new IngredienteEscolha();
                ie.setId(rs.getLong("ingrediente_escolha_id"));
                ia.setIngredienteEscolhas(ie);

                ingredientes.add(ia);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return ingredientes;
    }

}
