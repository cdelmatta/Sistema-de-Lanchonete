package dto;

import model.Cartao;
import model.MetPagamento;

public class CartaoDTO {

    public String idCartao;
    public String numeroCartao;
    public String codigvv;
    public String tipoCartao;
    public String idMetodoPagamento;

    public Cartao builder() {
        Cartao c = new Cartao();

        c.setId(idCartao == null || idCartao.trim().isEmpty() ? 0L : parseId(idCartao));

        if (numeroCartao == null || !numeroCartao.matches("\\d{16}")) {
            throw new IllegalArgumentException("Numero do cartão deve conter 16 digitos numericos!");
        }
        c.setNumero_cartao(numeroCartao.trim());

        if (codigvv == null || !codigvv.matches("\\d{3}")) {
            throw new IllegalArgumentException("CVV invalido(deve conter 3 digitos numericos)");
        }
        c.setCvv(Integer.parseInt(codigvv.trim()));

        try {
            int tipo = Integer.parseInt(tipoCartao.trim());
            if (tipo < 1 || tipo > 2) {
                throw new IllegalArgumentException("Tipo de cartao invalido (1-para credito ou 2-debito)");
            }
            c.setTipo(tipo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Tipo de cartão deve ser numero!");
        }

        if (idMetodoPagamento != null && !idMetodoPagamento.trim().isEmpty())
            try {
            MetPagamento mp = new MetPagamento();
            mp.setId(Long.parseLong(idMetodoPagamento.trim()));
            c.setMetPagamentos(mp);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID do metodo de pagamento e invalido");
        }
        return c;
    }

    private Long parseId(String id) {
        try {
            return Long.parseLong(id.trim());
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
