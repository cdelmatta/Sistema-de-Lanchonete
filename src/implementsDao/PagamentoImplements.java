package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.PagamentoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pagamento;
import model.Pedido;
import model.MetPagamento;
import model.Cupom;

public class PagamentoImplements implements PagamentoDao {

    @Override
    public void salvar(Pagamento pagamento) throws SQLException {
        String sql = "INSERT INTO pagamento (pedido_id, met_pagamento_id, cupom_id) VALUES (?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, pagamento.getPedidos().getId());
            ps.setLong(2, pagamento.getMetPagamentos().getId());
            ps.setLong(3, pagamento.getCupoms().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Pagamento pagamento) throws SQLException {
        String sql = "UPDATE pagamento SET pedido_id = ?, met_pagamento_id = ?, cupom_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, pagamento.getPedidos().getId());
            ps.setLong(2, pagamento.getMetPagamentos().getId());
            ps.setLong(3, pagamento.getCupoms().getId());
            ps.setLong(4, pagamento.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Pagamento pagamento) throws SQLException {
        String sql = "DELETE FROM pagamento WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, pagamento.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }

    }

    @Override
    public List<Pagamento> listar() throws SQLException {
        String sql = "SELECT * FROM pagamento";
        List<Pagamento> pagamentos = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pagamento p = new Pagamento();
                p.setId(rs.getLong("id"));

                Pedido pedido = new Pedido();
                pedido.setId(rs.getLong("pedido_id"));
                p.setPedidos(pedido);

                MetPagamento mp = new MetPagamento();
                mp.setId(rs.getLong("met_pagamento_id"));
                p.setMetPagamentos(mp);

                Cupom c = new Cupom();
                c.setId(rs.getLong("cupom_id"));
                p.setCupoms(c);

                pagamentos.add(p);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return pagamentos;
    }

}
