package dto;

import model.MetPagamento;
import model.Pagamento;
import model.Cartao;
import model.Dinheiro;

public class MetPagamentoDTO {
    public String dto_id;
    public String dto_pix;
    public String dto_pagamentos_id;
    public String dto_cartaos_id;
    public String dto_dinheiros_id;

    public MetPagamento builder() {
        MetPagamento metPagamento = new MetPagamento();
        
        if (dto_id != null && !dto_id.trim().isEmpty()) {
            try {
                metPagamento.setId(Long.parseLong(dto_id.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do método de pagamento inválido");
            }
        }

        if (dto_pix != null && !dto_pix.trim().isEmpty()) {
            try {
                metPagamento.setPix(Double.parseDouble(dto_pix.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] Valor do PIX inválido");
            }
        }

        if (dto_pagamentos_id != null && !dto_pagamentos_id.trim().isEmpty()) {
            try {
                Pagamento pagamento = new Pagamento();
                pagamento.setId(Long.parseLong(dto_pagamentos_id.trim()));
                metPagamento.setPagamentos(pagamento);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do pagamento inválido");
            }
        }

        if (dto_cartaos_id != null && !dto_cartaos_id.trim().isEmpty()) {
            try {
                Cartao cartao = new Cartao();
                cartao.setId(Long.parseLong(dto_cartaos_id.trim()));
                metPagamento.setCartaos(cartao);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do cartão inválido");
            }
        }

        if (dto_dinheiros_id != null && !dto_dinheiros_id.trim().isEmpty()) {
            try {
                Dinheiro dinheiro = new Dinheiro();
                dinheiro.setId(Long.parseLong(dto_dinheiros_id.trim()));
                metPagamento.setDinheiros(dinheiro);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do dinheiro inválido");
            }
        }

        if (metPagamento.getPix() == 0.0 
            && metPagamento.getPagamentos() == null 
            && metPagamento.getCartaos() == null 
            && metPagamento.getDinheiros() == null) {
            throw new IllegalArgumentException("[ERRO] Pelo menos um método de pagamento deve ser informado");
        }

        return metPagamento;
    }
}
