package dao;

import java.sql.SQLException;
import java.util.List;
import model.TaxaEntrega;

public interface TaxaEntregaDao {

    public void salvar(TaxaEntrega taxaEntrega) throws SQLException;

    public void editar(TaxaEntrega taxaEntrega) throws SQLException;

    public void excluir(TaxaEntrega taxaEntrega) throws SQLException;

    List<TaxaEntrega> listar() throws SQLException;

}
