package dao;

import java.sql.SQLException;
import java.util.List;
import model.IngredienteEscolha;

public interface IngredienteEscolhaDao {

    public void salvar(IngredienteEscolha ingredienteEscolha) throws SQLException;

    public void editar(IngredienteEscolha ingredienteEscolha) throws SQLException;

    public void excluir(IngredienteEscolha ingredienteEscolha) throws SQLException;

    List<IngredienteEscolha> listar() throws SQLException;
}
