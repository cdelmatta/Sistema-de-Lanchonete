package dao;

import java.sql.SQLException;
import java.util.List;
import model.IngredienteAdicional;

public interface IngredienteAdicionalDao {

    public void salvar(IngredienteAdicional ingredienteAdicional) throws SQLException;

    public void editar(IngredienteAdicional ingredienteAdicional) throws SQLException;

    public void excluir(IngredienteAdicional ingredienteAdicional) throws SQLException;

    List<IngredienteAdicional> listar() throws SQLException;
}
