package dao;

import java.sql.SQLException;
import java.util.List;
import model.StatusPedido;

public interface StatusPedidoDao {

    public void salvar(StatusPedido statusPedido) throws SQLException;

    public void editar(StatusPedido statusPedido) throws SQLException;

    public void excluir(StatusPedido statusPedido) throws SQLException;

    List<StatusPedido> listar() throws SQLException;
}
