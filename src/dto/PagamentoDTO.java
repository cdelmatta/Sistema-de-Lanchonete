package dto;

import model.Pagamento;
import model.Pedido;
import model.MetPagamento;
import model.Cupom;

public class PagamentoDTO {
    public String dto_id;
    public String dto_pedidos_id;
    public String dto_metPagamentos_id;
    public String dto_cupoms_id;

    public Pagamento builder() {
        Pagamento pagamento = new Pagamento();

        if (dto_id != null && !dto_id.trim().isEmpty()) {
            try {
                pagamento.setId(Long.parseLong(dto_id.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do pagamento inválido");
            }
        }
        
        if (dto_pedidos_id == null || dto_pedidos_id.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do pedido é obrigatório");
        }
        try {
            Pedido pedido = new Pedido();
            pedido.setId(Long.parseLong(dto_pedidos_id.trim()));
            pagamento.setPedidos(pedido);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do pedido inválido");
        }

        if (dto_metPagamentos_id == null || dto_metPagamentos_id.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do método de pagamento é obrigatório");
        }
        try {
            MetPagamento metPagamento = new MetPagamento();
            metPagamento.setId(Long.parseLong(dto_metPagamentos_id.trim()));
            pagamento.setMetPagamentos(metPagamento);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do método de pagamento inválido");
        }

        if (dto_cupoms_id != null && !dto_cupoms_id.trim().isEmpty()) {
            try {
                Cupom cupom = new Cupom();
                cupom.setId(Long.parseLong(dto_cupoms_id.trim()));
                pagamento.setCupoms(cupom);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do cupom inválido");
            }
        }

        return pagamento;
    }
}
