package implementsDao;

import static bancoDados.Conexao.getConexao;
import dao.CarrinhoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Carrinho;
import model.Pedido;
import model.IngredienteEscolha;
import model.Produto;

public class CarrinhoImplements implements CarrinhoDao {

    @Override
    public void Salvar(Carrinho carrinho) throws SQLException {
        String sql = ("INSERT INTO carrinho (quantidade, pedido_id,ingredienteEscolha_id,produto_id) VALUES (?, ?, ?,?)");
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, carrinho.getQuantidade());
            ps.setLong(2, carrinho.getPedidos().getId());
            ps.setLong(3, carrinho.getIngredienteEscolhas().getId());
            ps.setLong(4, carrinho.getProdutos().getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void editar(Carrinho carrinho) throws SQLException {
        String sql = ("UPDATE carrinho SET quantidade = ?, pedido_id = ?, ingredienteEscolha_id = ?, produto_id = ? WHERE id = ?");
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, carrinho.getQuantidade());
            ps.setLong(2, carrinho.getPedidos().getId());
            ps.setLong(3, carrinho.getIngredienteEscolhas().getId());
            ps.setLong(4, carrinho.getProdutos().getId());
            ps.setLong(5, carrinho.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public void excluir(Carrinho carrinho) throws SQLException {
        String sql = (" DELETE FROM carrinho WHERE id = ?");
        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, carrinho.getId());
            ps.executeUpdate();
            con.close();
            ps.close();
        }
    }

    @Override
    public List<Carrinho> Listar() throws SQLException {
        String sql = ("SELECT * FROM carrinho");
        List<Carrinho> carrinhos = new ArrayList<>();

        try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Carrinho c = new Carrinho();
                c.setId(rs.getLong("id"));
                c.setQuantidade(rs.getInt("quantidade"));

                Pedido p = new Pedido();
                p.setId(rs.getLong("pedido_id"));
                c.setPedidos(p);

                IngredienteEscolha i = new IngredienteEscolha();
                i.setId(rs.getLong("ingrediente_escolha_id"));
                c.setIngredienteEscolhas(i);

                Produto pr = new Produto();
                pr.setId(rs.getLong("produto_id"));
                c.setProdutos(pr);

                carrinhos.add(c);

            }
            con.close();
            ps.close();
            rs.close();
        }

        return carrinhos;

    }

}
