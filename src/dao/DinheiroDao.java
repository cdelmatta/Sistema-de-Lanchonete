package dao;

import java.sql.SQLException;
import java.util.List;
import model.Dinheiro;

public interface DinheiroDao {

    public void salvar(Dinheiro dinheiro) throws SQLException;

    public void editar(Dinheiro dinheiro) throws SQLException;

    public void excluir(Dinheiro dinheiro) throws SQLException;

    List<Dinheiro> listar() throws SQLException;
}
