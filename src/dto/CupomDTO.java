package dto;

import model.Cupom;
import model.Pagamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CupomDTO {
    public String idCupom;
    public String valorCupom;
    public String codig;
    public String valid;
    public String idPagamento;

    public Cupom builder() {
        Cupom cupom = new Cupom();
        
        if (idCupom != null && !idCupom.trim().isEmpty()) {
            try {
                cupom.setId(Long.parseLong(idCupom.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID do cupom inválido");
            }
        }

        if (valorCupom == null || valorCupom.trim().isEmpty()) {
            throw new IllegalArgumentException("Valor do cupom é obrigatório");
        }
        try {
            cupom.setValor_cupom(Double.parseDouble(valorCupom.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor do cupom deve ser numérico");
        }
        
        if (codig == null || codig.trim().isEmpty()) {
            throw new IllegalArgumentException("Código do cupom é obrigatório");
        }
        cupom.setCodigo(codig.trim());


        if (valid != null && !valid.trim().isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                sdf.setLenient(false);
                Date data = sdf.parse(valid.trim());
                cupom.setValidade(data);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Data inválida (formato correto: yyyy-MM-dd)");
            }
        }

        if (idPagamento != null && !idPagamento.trim().isEmpty()) {
            try {
                Pagamento pagamento = new Pagamento();
                pagamento.setId(Long.parseLong(idPagamento.trim()));
                cupom.setPagamentos(pagamento);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID de pagamento inválido");
            }
        }
        
        return cupom;
    }
}