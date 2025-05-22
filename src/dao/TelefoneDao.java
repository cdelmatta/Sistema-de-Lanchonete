package dao;

import java.sql.SQLException;
import java.util.List;
import model.Telefone;

public interface TelefoneDao {

    public void salvar(Telefone telefone) throws SQLException;

    public void editar(Telefone telefone) throws SQLException;

    public void excluir(Telefone telefone) throws SQLException;

    List<Telefone> listar() throws SQLException;
}
