package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.ProdutoDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoImplements implements ProdutoDao {

    @Override
    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (nome, valor_unitario) VALUES (?, ?)";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getValor_unitario());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET nome = ?, valor_unitario = ? WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getValor_unitario());
            ps.setLong(3, produto.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Produto produto) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, produto.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Produto> listar() throws SQLException {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setValor_unitario(rs.getDouble("valor_unitario"));
                produtos.add(p);
            }
            con.close();
            ps.close();
            rs.close();
        }
        return produtos;
    }

}
