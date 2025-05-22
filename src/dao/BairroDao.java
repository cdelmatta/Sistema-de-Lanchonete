package dao;

import model.Bairro;
import java.sql.SQLException;
import java.util.List;

public interface BairroDao {

    public void salvar(Bairro bairro) throws SQLException;

    public void editar(Bairro bairro) throws SQLException;

    public void excluir(Bairro bairro) throws SQLException;

    List<Bairro> listar() throws SQLException;
}
