package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.TelefoneDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Telefone;
import model.Funcionario;
import model.Cliente;

public class TelefoneImplements implements TelefoneDao {

    @Override
    public void salvar(Telefone telefone) throws SQLException {
        String sql = "INSERT INTO telefone (ddd, numero, funcionario_id, cliente_id) VALUES (?, ?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, telefone.getDdd());
            ps.setString(2, telefone.getNumero());
            ps.setLong(3, telefone.getFuncionarios().getId());
            ps.setLong(4, telefone.getClientes().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Telefone telefone) throws SQLException {
        String sql = "UPDATE telefone SET ddd = ?, numero = ?, funcionario_id = ?, cliente_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, telefone.getDdd());
            ps.setString(2, telefone.getNumero());
            ps.setLong(3, telefone.getFuncionarios().getId());
            ps.setLong(4, telefone.getClientes().getId());
            ps.setLong(5, telefone.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Telefone telefone) throws SQLException {
        String sql = "DELETE FROM telefone WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, telefone.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Telefone> listar() throws SQLException {
        String sql = "SELECT t.*, f.id AS funcionario_id, c.id AS cliente_id FROM telefone t "
                + "LEFT JOIN funcionario f ON t.funcionario_id = f.id "
                + "LEFT JOIN cliente c ON t.cliente_id = c.id";
        List<Telefone> telefones = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Telefone t = new Telefone();
                t.setId(rs.getLong("id"));
                t.setDdd(rs.getInt("ddd"));
                t.setNumero(rs.getString("numero"));

                Funcionario f = new Funcionario();
                f.setId(rs.getLong("funcionario_id"));
                t.setFuncionarios(f);

                Cliente c = new Cliente();
                c.setId(rs.getLong("cliente_id"));
                t.setClientes(c);

                telefones.add(t);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return telefones;
    }

}
