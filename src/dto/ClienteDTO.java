package dto;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Entrega;
import model.Pedido;
import model.Telefone;

public class ClienteDTO {
    
    public String idCliente;
    public String cNome;
    public String idTelefone;
    public List<String> idsEntregas;
    public List<String> idsPedidos;
    
    public Cliente builder() {
        Cliente cliente = new Cliente();
        
        if (idCliente != null && !idCliente.trim().isEmpty()) {
            try {
                cliente.setId(Long.parseLong(idCliente.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID do cliente invalido!");
            }
        }
        cliente.setNome(cNome);
        
        if (idTelefone != null && !idTelefone.trim().isEmpty()) {
            try {
                Telefone t = new Telefone();
                t.setId(Long.parseLong(idTelefone.trim()));
                cliente.setTelefones(t);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID do telefone invalido");
            }
        }
        
        if (idsPedidos != null) {
            List<Pedido> pedidos = new ArrayList<>();
            for (String idPedido : idsPedidos) {
                if (idPedido != null && !idPedido.trim().isEmpty()) {
                    try {
                        Pedido pedido = new Pedido();
                        pedido.setId(Long.parseLong(idPedido.trim()));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("ID de pedido invalido: " + idPedido);
                    }
                }
            }
           cliente.setPedidos(pedidos);
        }
        
        if (idsEntregas != null) {
            List<Entrega> entregas = new ArrayList<>();
            for (String idEntrega : idsEntregas) {
                if (idEntrega != null && !idEntrega.trim().isEmpty()) {
                    try {
                        Entrega entrega = new Entrega();
                        entrega.setId(Long.parseLong(idEntrega.trim()));
                        entregas.add(entrega);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("ID de entrega inválido: " + idEntrega);
                    }
                }
            }
            cliente.setEntregas(entregas);
        }
        
        return cliente;
        
    }
}
