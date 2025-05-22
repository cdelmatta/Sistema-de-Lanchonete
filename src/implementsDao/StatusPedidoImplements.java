package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.StatusPedidoDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.StatusPedido;

public class StatusPedidoImplements implements StatusPedidoDao {

    @Override
    public void salvar(StatusPedido statusPedido) throws SQLException {
        String sql = "INSERT INTO status_pedido (progresso) VALUES (?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, statusPedido.getProgresso());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(StatusPedido statusPedido) throws SQLException {
        String sql = "UPDATE status_pedido SET progresso = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, statusPedido.getProgresso());
            ps.setLong(2, statusPedido.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(StatusPedido statusPedido) throws SQLException {
        String sql = "DELETE FROM status_pedido WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, statusPedido.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<StatusPedido> listar() throws SQLException {
        String sql = "SELECT * FROM status_pedido";
        List<StatusPedido> status = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                StatusPedido sp = new StatusPedido();
                sp.setId(rs.getLong("id"));
                sp.setProgresso(rs.getString("progresso"));
                status.add(sp);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return status;
    }

}
