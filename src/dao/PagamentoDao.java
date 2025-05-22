package dao;

import java.sql.SQLException;
import java.util.List;
import model.Pagamento;

public interface PagamentoDao {

    public void salvar(Pagamento pagamento) throws SQLException;

    public void editar(Pagamento pagamento) throws SQLException;

    public void excluir(Pagamento pagamento) throws SQLException;

    List<Pagamento> listar() throws SQLException;
}
