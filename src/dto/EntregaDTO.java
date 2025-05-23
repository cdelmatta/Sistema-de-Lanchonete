package dto;

import model.Entrega;
import model.Cliente;
import model.Delivery;
import model.Pedido;

public class EntregaDTO {
    public String dto_id_entrega;
    public String dto_tipo_entrega;
    public String dto_id_cliente;
    public String dto_id_delivery;
    public String dto_id_pedido;

    public Entrega builder() {
        Entrega entrega = new Entrega();
        
        if (dto_id_entrega != null && !dto_id_entrega.trim().isEmpty()) {
            try {
                entrega.setId(Long.parseLong(dto_id_entrega.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID da entrega inválido");
            }
        }

        if (dto_tipo_entrega == null || dto_tipo_entrega.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] Tipo de entrega é obrigatório");
        }
        try {
            int tipo = Integer.parseInt(dto_tipo_entrega.trim());
            if (tipo != 1 && tipo != 2) { // <-- Alterado para aceitar apenas 1 ou 2
                throw new IllegalArgumentException("[ERRO] Tipo de entrega inválido (1-Padrão, 2-Expressa)");
            }
            entrega.setTipoEntrega(tipo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] Tipo de entrega deve ser 1 ou 2");
        }

        if (dto_id_cliente == null || dto_id_cliente.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do cliente é obrigatório");
        }
        try {
            Cliente cliente = new Cliente();
            cliente.setId(Long.parseLong(dto_id_cliente.trim()));
            entrega.setClientes(cliente);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do cliente inválido");
        }

        if (dto_id_delivery == null || dto_id_delivery.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do delivery é obrigatório");
        }
        try {
            Delivery delivery = new Delivery();
            delivery.setId(Long.parseLong(dto_id_delivery.trim()));
            entrega.setDeliverys(delivery);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do delivery inválido");
        }

        if (dto_id_pedido == null || dto_id_pedido.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do pedido é obrigatório");
        }
        try {
            Pedido pedido = new Pedido();
            pedido.setId(Long.parseLong(dto_id_pedido.trim()));
            entrega.setPedidos(pedido);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do pedido inválido");
        }
        
        return entrega;
    }
}
