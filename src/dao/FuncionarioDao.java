package dao;

import java.sql.SQLException;
import java.util.List;
import model.Funcionario;

public interface FuncionarioDao {

    public void salvar(Funcionario funcionario) throws SQLException;

    public void editar(Funcionario funcionario) throws SQLException;

    public void excluir(Funcionario funcionario) throws SQLException;

    List<Funcionario> listar() throws SQLException;
}
