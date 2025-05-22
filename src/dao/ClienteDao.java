package dao;

import model.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {

    public void salvar(Cliente cliente) throws SQLException;

    public void editar(Cliente cliente) throws SQLException;

    public void excluir(Cliente cliente) throws SQLException;

    List<Cliente> listar() throws SQLException;
}
