package implementsDao;

import java.sql.SQLException;
import java.util.List;
import static bancoDados.Conexao.getConexao;
import dao.EntregaDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Entrega;
import model.Cliente;
import model.Delivery;
import model.Pedido;

public class EntregaImplements implements EntregaDao {

    @Override
    public void salvar(Entrega entrega) throws SQLException {
        String sql = "INSERT INTO entrega (tipo_entrega, cliente_id, delivery_id, pedido_id) VALUES (?, ?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, entrega.getTipoEntrega());
            ps.setLong(2, entrega.getClientes().getId());
            ps.setLong(3, entrega.getDeliverys().getId());
            ps.setLong(4, entrega.getPedidos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Entrega entrega) throws SQLException {
        String sql = "UPDATE entrega SET tipo_entrega = ?, cliente_id = ?, delivery_id = ?, pedido_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, entrega.getTipoEntrega());
            ps.setLong(2, entrega.getClientes().getId());
            ps.setLong(3, entrega.getDeliverys().getId());
            ps.setLong(4, entrega.getPedidos().getId());
            ps.setLong(5, entrega.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }

    }

    @Override
    public void excluir(Entrega entrega) throws SQLException {
        String sql = "DELETE FROM entrega WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, entrega.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Entrega> listar() throws SQLException {
        String sql = "SELECT * FROM entrega";
        List<Entrega> entregas = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Entrega e = new Entrega();
                e.setId(rs.getLong("id"));
                e.setTipoEntrega(rs.getInt("tipo_entrega"));

                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("cliente_id"));
                e.setClientes(cliente);

                Delivery delivery = new Delivery();
                delivery.setId(rs.getLong("delivery_id"));
                e.setDeliverys(delivery);

                Pedido pedido = new Pedido();
                pedido.setId(rs.getLong("pedido_id"));
                e.setPedidos(pedido);

                entregas.add(e);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return entregas;
    }

}
