package dao;

import java.sql.SQLException;
import java.util.List;

import model.Entrega;

public interface EntregaDao {

    public void salvar(Entrega entrega) throws SQLException;

    public void editar(Entrega entrega) throws SQLException;

    public void excluir(Entrega entrega) throws SQLException;

    List<Entrega> listar() throws SQLException;
}
