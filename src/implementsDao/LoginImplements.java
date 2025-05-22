package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.LoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Login;
import model.Funcionario;

public class LoginImplements implements LoginDao {

    @Override
    public void salvar(Login login) throws SQLException {
        String sql = "INSERT INTO login (senha, login_funcionario, funcionario_id) VALUES (?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, login.getSenha());
            ps.setString(2, login.getLogin_funcinario());
            ps.setLong(3, login.getFuncionarios().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Login login) throws SQLException {
        String sql = "UPDATE login SET senha = ?, login_funcionario = ?, funcionario_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, login.getSenha());
            ps.setString(2, login.getLogin_funcinario());
            ps.setLong(3, login.getFuncionarios().getId());
            ps.setLong(4, login.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Login login) throws SQLException {
        String sql = "DELETE FROM login WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, login.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }

    }

    @Override
    public List<Login> listar() throws SQLException {
        String sql = "SELECT * FROM login";
        List<Login> logins = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Login l = new Login();
                l.setId(rs.getLong("id"));
                l.setSenha(rs.getString("senha"));
                l.setLogin_funcinario(rs.getString("login_funcionario"));

                Funcionario f = new Funcionario();
                f.setId(rs.getLong("funcionario_id"));
                l.setFuncionarios(f);

                logins.add(l);
            }
            con.close();
            ps.close();
            rs.close();
        }

        return logins;
    }

}
