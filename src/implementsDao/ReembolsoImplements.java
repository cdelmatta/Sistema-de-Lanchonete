package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.ReembolsoDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Reembolso;
import model.Pedido;

public class ReembolsoImplements implements ReembolsoDao {

    @Override
    public void salvar(Reembolso reembolso) throws SQLException {
        String sql = "INSERT INTO reembolso (motivo, pedido_id) VALUES (?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, reembolso.getMotivo());
            ps.setLong(2, reembolso.getPedidos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Reembolso reembolso) throws SQLException {
        String sql = "UPDATE reembolso SET motivo = ?, pedido_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, reembolso.getMotivo());
            ps.setLong(2, reembolso.getPedidos().getId());
            ps.setLong(3, reembolso.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Reembolso reembolso) throws SQLException {
        String sql = "DELETE FROM reembolso WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, reembolso.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Reembolso> listar() throws SQLException {
        String sql = "SELECT * FROM reembolso";
        List<Reembolso> reembolsos = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reembolso r = new Reembolso();
                r.setId(rs.getLong("id"));
                r.setMotivo(rs.getString("motivo"));

                Pedido p = new Pedido();
                p.setId(rs.getLong("pedido_id"));
                r.setPedidos(p);

                reembolsos.add(r);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return reembolsos;
    }

}
