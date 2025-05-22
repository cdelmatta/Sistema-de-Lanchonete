package dao;

import java.sql.SQLException;
import java.util.List;
import model.Cartao;

public interface CartaoDao {

    public void salvar(Cartao cartao) throws SQLException;

    public void editar(Cartao cartao) throws SQLException;

    public void excluir(Cartao cartao) throws SQLException;

    List<Cartao> listar() throws SQLException;
}
