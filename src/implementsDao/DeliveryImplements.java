package implementsDao;

import static bancoDados.Conexao.getConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.DeliveryDao;
import java.sql.SQLException;
import java.util.List;
import model.Delivery;
import model.Entrega;

public class DeliveryImplements implements DeliveryDao {

    @Override
    public void salvar(Delivery delivery) throws SQLException {
        String sql = "INSERT INTO delivery (chave_entrega, numero, complemento, entrega_id) VALUES (?, ?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, delivery.getChaveEntrega());
            ps.setInt(2, delivery.getNumero());
            ps.setString(3, delivery.getComplemento());
            ps.setLong(4, delivery.getEntregas().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Delivery delivery) throws SQLException {
        String sql = "UPDATE delivery SET chave_entrega = ?, numero = ?, complemento = ?, entrega_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, delivery.getChaveEntrega());
            ps.setInt(2, delivery.getNumero());
            ps.setString(3, delivery.getComplemento());
            ps.setLong(4, delivery.getEntregas().getId());
            ps.setLong(5, delivery.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Delivery delivery) throws SQLException {
        String sql = "DELETE FROM delivery WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, delivery.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Delivery> listar() throws SQLException {
        String sql = "SELECT * FROM delivery";
        List<Delivery> deliveries = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Delivery d = new Delivery();
                d.setId(rs.getLong("id"));
                d.setChaveEntrega(rs.getInt("chave_entrega"));
                d.setNumero(rs.getInt("numero"));
                d.setComplemento(rs.getString("complemento"));

                Entrega e = new Entrega();
                e.setId(rs.getLong("entrega_id"));
                d.setEntregas(e);

                deliveries.add(d);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return deliveries;
    }

}
