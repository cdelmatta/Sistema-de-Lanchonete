package dao;

import java.sql.SQLException;
import java.util.List;
import model.Reembolso;

public interface ReembolsoDao {

    public void salvar(Reembolso reembolso) throws SQLException;

    public void editar(Reembolso reembolso) throws SQLException;

    public void excluir(Reembolso reembolso) throws SQLException;

    List<Reembolso> listar() throws SQLException;
}
