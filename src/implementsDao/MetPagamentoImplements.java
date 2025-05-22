package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.MetPagamentoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MetPagamento;
import model.Pagamento;
import model.Cartao;
import model.Dinheiro;

public class MetPagamentoImplements implements MetPagamentoDao {

    @Override
    public void salvar(MetPagamento metPagamento) throws SQLException {
        String sql = "INSERT INTO met_pagamento (pix, pagamento_id, cartao_id, dinheiro_id) VALUES (?, ?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, metPagamento.getPix());
            ps.setLong(2, metPagamento.getPagamentos().getId());
            ps.setLong(3, metPagamento.getCartaos().getId());
            ps.setLong(4, metPagamento.getDinheiros().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(MetPagamento metPagamento) throws SQLException {
        String sql = "UPDATE met_pagamento SET pix = ?, pagamento_id = ?, cartao_id = ?, dinheiro_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, metPagamento.getPix());
            ps.setLong(2, metPagamento.getPagamentos().getId());
            ps.setLong(3, metPagamento.getCartaos().getId());
            ps.setLong(4, metPagamento.getDinheiros().getId());
            ps.setLong(5, metPagamento.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(MetPagamento metPagamento) throws SQLException {
        String sql = "DELETE FROM met_pagamento WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, metPagamento.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<MetPagamento> listar() throws SQLException {
        String sql = "SELECT * FROM met_pagamento";
        List<MetPagamento> metodos = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MetPagamento mp = new MetPagamento();
                mp.setId(rs.getLong("id"));
                mp.setPix(rs.getDouble("pix"));

                Pagamento p = new Pagamento();
                p.setId(rs.getLong("pagamento_id"));
                mp.setPagamentos(p);

                Cartao c = new Cartao();
                c.setId(rs.getLong("cartao_id"));
                mp.setCartaos(c);

                Dinheiro d = new Dinheiro();
                d.setId(rs.getLong("dinheiro_id"));
                mp.setDinheiros(d);

                metodos.add(mp);
            }
            con.close();
            ps.close();
            rs.close();
        }

        return metodos;
    }

}
