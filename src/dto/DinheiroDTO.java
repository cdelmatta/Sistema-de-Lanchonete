package dto;

import model.Dinheiro;
import model.MetPagamento;

public class DinheiroDTO {
    public String idDinheiro;
    public String valorEntregado;
    public String idMetPagamento;

    public Dinheiro builder() {
        Dinheiro dinheiro = new Dinheiro();
        
        if (idDinheiro != null && !idDinheiro.trim().isEmpty()) {
            try {
                dinheiro.setId(Long.parseLong(idDinheiro.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID do dinheiro inválido");
            }
        }

        if (valorEntregado == null || valorEntregado.trim().isEmpty()) {
            throw new IllegalArgumentException("Valor entregue é obrigatório");
        }
        try {
            dinheiro.setValor_entregado(Double.parseDouble(valorEntregado.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor entregue deve ser um número válido");
        }

        if (idMetPagamento == null || idMetPagamento.trim().isEmpty()) {
            throw new IllegalArgumentException("ID do método de pagamento é obrigatório");
        }
        try {
            MetPagamento mp = new MetPagamento();
            mp.setId(Long.parseLong(idMetPagamento.trim()));
            dinheiro.setMetPagamentos(mp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID do método de pagamento inválido");
        }
        
        return dinheiro;
    }
}
