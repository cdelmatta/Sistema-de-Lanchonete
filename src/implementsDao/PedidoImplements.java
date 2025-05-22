package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.PedidoDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;
import model.Entrega;
import model.Cliente;
import model.StatusPedido;
import model.Pagamento;
import model.Reembolso;

public class PedidoImplements implements PedidoDao {

    @Override
    public void salvar(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedido (hora_pedido, numero_pedido, data_pedido, entrega_id, cliente_id, status_pedido_id, pagamento_id, reembolso_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pedido.getHora_pedido());
            ps.setInt(2, pedido.getNumero_pedido());
            ps.setDate(3, new java.sql.Date(pedido.getData_pedido().getTime()));
            ps.setLong(4, pedido.getEntregas().getId());
            ps.setLong(5, pedido.getClientes().getId());
            ps.setLong(6, pedido.getStatusPedidos().getId());
            ps.setLong(7, pedido.getPagamentos().getId());
            ps.setLong(8, pedido.getReembolsos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Pedido pedido) throws SQLException {
        String sql = "UPDATE pedido SET hora_pedido = ?, numero_pedido = ?, data_pedido = ?, entrega_id = ?, cliente_id = ?, status_pedido_id = ?, pagamento_id = ?, reembolso_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pedido.getHora_pedido());
            ps.setInt(2, pedido.getNumero_pedido());
            ps.setDate(3, new java.sql.Date(pedido.getData_pedido().getTime()));
            ps.setLong(4, pedido.getEntregas().getId());
            ps.setLong(5, pedido.getClientes().getId());
            ps.setLong(6, pedido.getStatusPedidos().getId());
            ps.setLong(7, pedido.getPagamentos().getId());
            ps.setLong(8, pedido.getReembolsos().getId());
            ps.setLong(9, pedido.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Pedido pedido) throws SQLException {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, pedido.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Pedido> listar() throws SQLException {
        String sql = "SELECT * FROM pedido";
        List<Pedido> pedidos = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setId(rs.getLong("id"));
                p.setHora_pedido(rs.getString("hora_pedido"));
                p.setNumero_pedido(rs.getInt("numero_pedido"));
                p.setData_pedido(rs.getDate("data_pedido"));

                Entrega e = new Entrega();
                e.setId(rs.getLong("entrega_id"));
                p.setEntregas(e);

                Cliente c = new Cliente();
                c.setId(rs.getLong("cliente_id"));
                p.setClientes(c);

                StatusPedido sp = new StatusPedido();
                sp.setId(rs.getLong("status_pedido_id"));
                p.setStatusPedidos(sp);

                Pagamento pg = new Pagamento();
                pg.setId(rs.getLong("pagamento_id"));
                p.setPagamentos(pg);

                Reembolso r = new Reembolso();
                r.setId(rs.getLong("reembolso_id"));
                p.setReembolsos(r);

                pedidos.add(p);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return pedidos;
    }

}
