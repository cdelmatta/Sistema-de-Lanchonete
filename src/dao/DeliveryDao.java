
package dao;

import java.sql.SQLException;
import java.util.List;
import model.Delivery;

public interface DeliveryDao {
    public void salvar(Delivery delivery) throws SQLException;

    public void editar(Delivery delivery) throws SQLException;

    public void excluir(Delivery delivery) throws SQLException;

    List<Delivery> listar() throws SQLException;  
}
