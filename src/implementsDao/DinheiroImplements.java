package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.DinheiroDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Dinheiro;
import model.MetPagamento;

public class DinheiroImplements implements DinheiroDao {

    @Override
    public void salvar(Dinheiro dinheiro) throws SQLException {
        String sql = "INSERT INTO dinheiro (valor_entregado, met_pagamento_id) VALUES (?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, dinheiro.getValor_entregado());
            ps.setLong(2, dinheiro.getMetPagamentos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Dinheiro dinheiro) throws SQLException {
        String sql = "UPDATE dinheiro SET valor_entregado = ?, met_pagamento_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, dinheiro.getValor_entregado());
            ps.setLong(2, dinheiro.getMetPagamentos().getId());
            ps.setLong(3, dinheiro.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Dinheiro dinheiro) throws SQLException {
        String sql = "DELETE FROM dinheiro WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, dinheiro.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Dinheiro> listar() throws SQLException {
        String sql = "SELECT * FROM dinheiro";
        List<Dinheiro> dinheiros = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Dinheiro d = new Dinheiro();
                d.setId(rs.getLong("id"));
                d.setValor_entregado(rs.getDouble("valor_entregado"));

                MetPagamento mp = new MetPagamento();
                mp.setId(rs.getLong("met_pagamento_id"));
                d.setMetPagamentos(mp);

                dinheiros.add(d);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return dinheiros;
    }

}
