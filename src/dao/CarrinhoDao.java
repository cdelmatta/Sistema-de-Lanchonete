package dao;

import java.sql.SQLException;
import java.util.List;
import model.Carrinho;

public interface CarrinhoDao {

    public void Salvar(Carrinho carrinho) throws SQLException;

    public void editar(Carrinho carrinho) throws SQLException;

    public void excluir(Carrinho carrinho) throws SQLException;
    
    List<Carrinho> Listar() throws SQLException;

}
