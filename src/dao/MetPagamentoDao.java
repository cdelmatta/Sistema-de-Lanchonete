package dao;

import java.sql.SQLException;
import java.util.List;
import model.MetPagamento;

public interface MetPagamentoDao {

    public void salvar(MetPagamento metPagamento) throws SQLException;

    public void editar(MetPagamento metPagamento) throws SQLException;

    public void excluir(MetPagamento metPagamento) throws SQLException;

    List<MetPagamento> listar() throws SQLException;
}
