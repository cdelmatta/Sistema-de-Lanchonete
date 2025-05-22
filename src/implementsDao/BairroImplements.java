package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.BairroDao;
import java.sql.SQLException;
import java.util.List;
import model.Bairro;
import java.sql.*;
import java.util.ArrayList;
import model.Endereco;

public class BairroImplements implements BairroDao {

    @Override
    public void salvar(Bairro bairro) throws SQLException {
        String sql = "INSERT INTO bairro(bairro,endereco_id) VALUES (? , ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bairro.getBairro());
            ps.setLong(2, bairro.getEnderecos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Bairro bairro) throws SQLException {
        String sql = "UPDATE bairro SET = ?, endereco_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bairro.getBairro());
            ps.setLong(2, bairro.getEnderecos().getId());
            ps.setLong(3, bairro.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Bairro bairro) throws SQLException {
        String sql = "DELETE FROM bairro WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, bairro.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Bairro> listar() throws SQLException {
        String sql = "SELECT * FROM bairro";
        List<Bairro> bairros = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Bairro b = new Bairro();
                b.setId(rs.getLong("id"));
                b.setBairro(rs.getString("bairro"));

                Endereco endereco = new Endereco();
                endereco.setId(rs.getLong("endereco_id"));
                b.setEnderecos(endereco);

                bairros.add(b);
            }
            con.close();
            ps.close();
            rs.close();
        }

        return bairros;
    }

}
