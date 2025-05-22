package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.CartaoDao;
import model.Cartao;
import model.MetPagamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaoImplements implements CartaoDao {

    @Override
    public void salvar(Cartao cartao) throws SQLException {
        String sql = "INSERT INTO cartao(numero_cartao,cvv,tipo,met_pagamento_id) VALUES(?,?,?,?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cartao.getNumero_cartao());
            ps.setInt(2, cartao.getCvv());
            ps.setInt(3, cartao.getTipo());
            ps.setLong(4, cartao.getMetPagamentos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Cartao cartao) throws SQLException {
        String sql = "UPDATE cartao SET numero_cartao = ?,cvv = ?, tipo = ?, met_pagamento_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cartao.getNumero_cartao());
            ps.setInt(2, cartao.getCvv());
            ps.setInt(3, cartao.getTipo());
            ps.setLong(4, cartao.getMetPagamentos().getId());
            ps.setLong(5, cartao.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Cartao cartao) throws SQLException {
        String sql = "DELETE FROM cartao WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, cartao.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Cartao> listar() throws SQLException {
        String sql = "SELECT * FROM cartao";
        List<Cartao> cartoes = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cartao c = new Cartao();
                c.setId(rs.getLong("id"));
                c.setNumero_cartao(rs.getString("numero_cartao"));
                c.setCvv(rs.getInt("cvv"));
                c.setTipo(rs.getInt("tipo"));

                MetPagamento mp = new MetPagamento();
                mp.setId(rs.getLong("met_pagamento_id"));
                c.setMetPagamentos(mp);

                cartoes.add(c);
            }
            con.close();
            ps.close();
            rs.close();
        }

        return cartoes;

    }

}
