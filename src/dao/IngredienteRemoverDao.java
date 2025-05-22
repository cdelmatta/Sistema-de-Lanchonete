package dao;

import java.sql.SQLException;
import java.util.List;
import model.IngredienteRemover;


public interface IngredienteRemoverDao {

    public void salvar(IngredienteRemover ingredienteRemover) throws SQLException;

    public void editar(IngredienteRemover ingredienteRemover) throws SQLException;

    public void excluir(IngredienteRemover ingredienteRemover) throws SQLException;

    List<IngredienteRemover> listar() throws SQLException;
}
