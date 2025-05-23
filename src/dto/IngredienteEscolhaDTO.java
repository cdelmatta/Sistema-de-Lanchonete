package dto;

import model.IngredienteEscolha;
import model.Carrinho;
import model.IngredienteRemover;
import model.IngredienteAdicional;
import java.util.ArrayList;
import java.util.List;

public class IngredienteEscolhaDTO {
    public String dto_id_escolha;
    public List<String> dto_ids_carrinhos;
    public List<String> dto_ids_remover;
    public List<String> dto_ids_adicionais;

    public IngredienteEscolha builder() {
        IngredienteEscolha escolha = new IngredienteEscolha();
        
        if (dto_id_escolha != null && !dto_id_escolha.trim().isEmpty()) {
            try {
                escolha.setId(Long.parseLong(dto_id_escolha.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID da escolha inválido");
            }
        }

        if (dto_ids_carrinhos != null) {
            List<Carrinho> carrinhos = new ArrayList<>();
            for (String idCarrinho : dto_ids_carrinhos) {
                if (idCarrinho != null && !idCarrinho.trim().isEmpty()) {
                    try {
                        Carrinho c = new Carrinho();
                        c.setId(Long.parseLong(idCarrinho.trim()));
                        carrinhos.add(c);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("[ERRO] ID de carrinho inválido: " + idCarrinho);
                    }
                }
            }
            escolha.setCarrinhos(carrinhos);
        } else {
            escolha.setCarrinhos(new ArrayList<>());
        }

        if (dto_ids_remover != null) {
            List<IngredienteRemover> remocoes = new ArrayList<>();
            for (String idRemover : dto_ids_remover) {
                if (idRemover != null && !idRemover.trim().isEmpty()) {
                    try {
                        IngredienteRemover ir = new IngredienteRemover();
                        ir.setId(Long.parseLong(idRemover.trim()));
                        remocoes.add(ir);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("[ERRO] ID de remoção inválido: " + idRemover);
                    }
                }
            }
            escolha.setIngredienteRevomers(remocoes);
        } else {
            escolha.setIngredienteRevomers(new ArrayList<>());
        }
    
        if (dto_ids_adicionais != null) {
            List<IngredienteAdicional> adicionais = new ArrayList<>();
            for (String idAdicional : dto_ids_adicionais) {
                if (idAdicional != null && !idAdicional.trim().isEmpty()) {
                    try {
                        IngredienteAdicional ia = new IngredienteAdicional();
                        ia.setId(Long.parseLong(idAdicional.trim()));
                        adicionais.add(ia);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("[ERRO] ID de adicional inválido: " + idAdicional);
                    }
                }
            }
            escolha.setIngredienteAdicionals(adicionais);
        } else {
            escolha.setIngredienteAdicionals(new ArrayList<>());
        }
        
        return escolha;
    }
}
