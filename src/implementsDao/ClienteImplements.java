package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.ClienteDao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Telefone;

public class ClienteImplements implements ClienteDao {

    @Override
    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, telefone_id) VALUES (?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            if (cliente.getTelefones() != null) {
                ps.setLong(2, cliente.getTelefones().getId());
            } else {
                ps.setNull(2, java.sql.Types.BIGINT);
            }
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, telefone_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            if (cliente.getTelefones() != null) {
                ps.setLong(2, cliente.getTelefones().getId());
            } else {
                ps.setNull(2, java.sql.Types.BIGINT);
            }
            ps.setLong(3, cliente.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, cliente.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Cliente> listar() throws SQLException {
        String sql = "SELECT c.*, t.numero AS telefone_numero FROM cliente c "
                + "LEFT JOIN telefone t ON c.telefone_id = t.id";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getLong("id"));
                c.setNome(rs.getString("nome"));

                if (rs.getLong("telefone_id") > 0) {
                    Telefone t = new Telefone();
                    t.setId(rs.getLong("telefone_id"));
                    t.setNumero(rs.getString("telefone_numero"));
                    c.setTelefones(t);
                }

            }
            con.close();
            ps.close();
            rs.close();
        }

        return clientes;
    }

}
