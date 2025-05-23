package dto;

import model.IngredienteRemover;
import model.IngredienteEscolha;

public class IngredienteRemoverDTO {
    public String dto_id_remover;
    public String dto_nome;
    public String dto_id_escolha;

    public IngredienteRemover builder() {
        IngredienteRemover remocao = new IngredienteRemover();
        
        if (dto_id_remover != null && !dto_id_remover.trim().isEmpty()) {
            try {
                remocao.setId(Long.parseLong(dto_id_remover.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID da remoção inválido");
            }
        }

        if (dto_nome == null || dto_nome.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] Nome do ingrediente é obrigatório");
        }
        remocao.setNome(dto_nome.trim());

        if (dto_id_escolha == null || dto_id_escolha.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID da escolha é obrigatório");
        }
        try {
            IngredienteEscolha escolha = new IngredienteEscolha();
            escolha.setId(Long.parseLong(dto_id_escolha.trim()));
            remocao.setIngredienteEscolhas(escolha);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID da escolha inválido");
        }
        
        return remocao;
    }
}
