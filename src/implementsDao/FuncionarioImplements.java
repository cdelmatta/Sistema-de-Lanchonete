package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.FuncionarioDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.Login;
import model.Telefone;

public class FuncionarioImplements implements FuncionarioDao {

    @Override
    public void salvar(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (login_id, cpf, rg, telefone_id) VALUES (?, ?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, funcionario.getLogins().getId());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getRg());
            ps.setLong(4, funcionario.getTelefones().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET login_id = ?, cpf = ?, rg = ?, telefone_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, funcionario.getLogins().getId());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getRg());
            ps.setLong(4, funcionario.getTelefones().getId());
            ps.setLong(5, funcionario.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Funcionario funcionario) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, funcionario.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Funcionario> listar() throws SQLException {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> funcionarios = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getLong("id"));
                f.setCpf(rs.getString("cpf"));
                f.setRg(rs.getString("rg"));

                Login l = new Login();
                l.setId(rs.getLong("login_id"));
                f.setLogins(l);

                Telefone t = new Telefone();
                t.setId(rs.getLong("telefone_id"));
                f.setTelefones(t);

                funcionarios.add(f);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return funcionarios;
    }

}
