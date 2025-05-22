package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.EnderecoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.Bairro;
import model.TaxaEntrega;

public class EnderecoImplements implements EnderecoDao {

    @Override
    public void salvar(Endereco endereco) throws SQLException {
        String sql = "INSERT INTO endereco (rua, cep, distancia, bairro_id, taxa_entrega_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getCep());
            ps.setInt(3, endereco.getDistancia());
            ps.setLong(4, endereco.getBairros().getId());
            ps.setLong(5, endereco.getTaxaEntregas().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Endereco endereco) throws SQLException {
        String sql = "UPDATE endereco SET rua = ?, cep = ?, distancia = ?, bairro_id = ?, taxa_entrega_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getCep());
            ps.setInt(3, endereco.getDistancia());
            ps.setLong(4, endereco.getBairros().getId());
            ps.setLong(5, endereco.getTaxaEntregas().getId());
            ps.setLong(6, endereco.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Endereco endereco) throws SQLException {
        String sql = "DELETE FROM endereco WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, endereco.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Endereco> listar() throws SQLException {
        String sql = "SELECT * FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Endereco e = new Endereco();
                e.setId(rs.getLong("id"));
                e.setRua(rs.getString("rua"));
                e.setCep(rs.getString("cep"));
                e.setDistancia(rs.getInt("distancia"));

                Bairro b = new Bairro();
                b.setId(rs.getLong("bairro_id"));
                e.setBairros(b);

                TaxaEntrega te = new TaxaEntrega();
                te.setId(rs.getLong("taxa_entrega_id"));
                e.setTaxaEntregas(te);

                enderecos.add(e);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return enderecos;
    }

}
