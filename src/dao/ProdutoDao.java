package dao;

import java.sql.SQLException;
import java.util.List;
import model.Produto;

public interface ProdutoDao {

    public void salvar(Produto produto) throws SQLException;

    public void editar(Produto produto) throws SQLException;

    public void excluir(Produto produto) throws SQLException;

    List<Produto> listar() throws SQLException;
}
