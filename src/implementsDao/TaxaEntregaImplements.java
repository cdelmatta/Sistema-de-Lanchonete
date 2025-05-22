package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.TaxaEntregaDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.TaxaEntrega;

public class TaxaEntregaImplements implements TaxaEntregaDao {

    @Override
    public void salvar(TaxaEntrega taxaEntrega) throws SQLException {
        String sql = "INSERT INTO taxa_entrega (endereco_id) VALUES (?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, taxaEntrega.getEnderecos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(TaxaEntrega taxaEntrega) throws SQLException {
        String sql = "UPDATE taxa_entrega SET endereco_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, taxaEntrega.getEnderecos().getId());
            ps.setLong(2, taxaEntrega.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(TaxaEntrega taxaEntrega) throws SQLException {
        String sql = "DELETE FROM taxa_entrega WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, taxaEntrega.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<TaxaEntrega> listar() throws SQLException {
        String sql = "SELECT * FROM taxa_entrega";
        List<TaxaEntrega> taxas = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TaxaEntrega te = new TaxaEntrega();
                te.setId(rs.getLong("id"));

                Endereco e = new Endereco();
                e.setId(rs.getLong("endereco_id"));
                te.setEnderecos(e);

                taxas.add(te);
            }
            con.close();
            ps.close();
            rs.close();
        }

        return taxas;
    }

}
