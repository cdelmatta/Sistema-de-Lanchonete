package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.CupomDao;
import java.sql.SQLException;
import java.util.List;
import model.Cupom;
import model.Pagamento;
import java.sql.*;
import java.util.ArrayList;

public class CupomImplements implements CupomDao {

    @Override
    public void salvar(Cupom cupom) throws SQLException {
        String sql = "INSERT INTO cupom (valor_cupom, codigo, validade, pagamento_id) VALUES (?, ?, ?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, cupom.getValor_cupom());
            ps.setString(2, cupom.getCodigo());
            ps.setDate(3, new java.sql.Date(cupom.getValidade().getTime()));
            ps.setLong(4, cupom.getPagamentos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Cupom cupom) throws SQLException {
        String sql = "UPDATE cupom SET valor_cupom = ?, codigo = ?, validade = ?, pagamento_id = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, cupom.getValor_cupom());
            ps.setString(2, cupom.getCodigo());
            ps.setDate(3, new java.sql.Date(cupom.getValidade().getTime()));
            ps.setLong(4, cupom.getPagamentos().getId());
            ps.setLong(5, cupom.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Cupom cupom) throws SQLException {
        String sql = "DELETE FROM cupom WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, cupom.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Cupom> listar() throws SQLException {
        String sql = "SELECT * FROM cupom";
        List<Cupom> cupons = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cupom c = new Cupom();
                c.setId(rs.getLong("id"));
                c.setValor_cupom(rs.getDouble("valor_cupom"));
                c.setCodigo(rs.getString("codigo"));
                c.setValidade(rs.getDate("validade"));

                Pagamento p = new Pagamento();
                p.setId(rs.getLong("pagamento_id"));
                c.setPagamentos(p);

                cupons.add(c);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return cupons;

    }

}
