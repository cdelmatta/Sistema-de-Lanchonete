package dto;

import model.Delivery;
import model.Entrega;

public class DeliveryDTO {
    public String idDelivery;
    public String chavEntreg;
    public String numer;
    public String complement;
    public String idEntrega;

    public Delivery builder() {
        Delivery delivery = new Delivery();
        
        if (idDelivery != null && !idDelivery.trim().isEmpty()) {
            try {
                delivery.setId(Long.parseLong(idDelivery.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("ID do delivery inválido");
            }
        }

        if (chavEntreg == null || chavEntreg.trim().isEmpty()) {
            throw new IllegalArgumentException("Chave de entrega é obrigatória");
        }
        try {
            delivery.setChaveEntrega(Integer.parseInt(chavEntreg.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Chave de entrega deve ser numérica");
        }

        if (numer == null || numer.trim().isEmpty()) {
            throw new IllegalArgumentException("Número é obrigatório");
        }
        try {
            delivery.setNumero(Integer.parseInt(numer.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Número deve ser um valor inteiro");
        }

        delivery.setComplemento(complement != null ? complement.trim() : null);

        if (idEntrega == null || idEntrega.trim().isEmpty()) {
            throw new IllegalArgumentException("ID da entrega é obrigatório");
        }
        try {
            Entrega entrega = new Entrega();
            entrega.setId(Long.parseLong(idEntrega.trim()));
            delivery.setEntregas(entrega);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID da entrega inválido");
        }
        
        return delivery;
    }
}
