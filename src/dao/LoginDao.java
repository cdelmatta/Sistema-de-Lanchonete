package dao;

import java.sql.SQLException;
import java.util.List;
import model.Login;

public interface LoginDao {

    public void salvar(Login login) throws SQLException;

    public void editar(Login login) throws SQLException;

    public void excluir(Login login) throws SQLException;

    List<Login> listar() throws SQLException;
}
