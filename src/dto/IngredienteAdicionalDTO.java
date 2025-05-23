package dto;

import model.IngredienteAdicional;
import model.IngredienteEscolha;

public class IngredienteAdicionalDTO {
    public String dto_id_ingrediente;
    public String dto_nome;
    public String dto_valor;
    public String dto_id_escolha;

    public IngredienteAdicional builder() {
        IngredienteAdicional ingrediente = new IngredienteAdicional();
        
        if (dto_id_ingrediente != null && !dto_id_ingrediente.trim().isEmpty()) {
            try {
                ingrediente.setId(Long.parseLong(dto_id_ingrediente.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do ingrediente inválido");
            }
        }

        if (dto_nome == null || dto_nome.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] Nome do ingrediente é obrigatório");
        }
        ingrediente.setNome(dto_nome.trim());

        if (dto_valor == null || dto_valor.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] Valor do ingrediente é obrigatório");
        }
        try {
            double valor = Double.parseDouble(dto_valor.trim());
            if (valor < 0) {
                throw new IllegalArgumentException("[ERRO] Valor não pode ser negativo");
            }
            ingrediente.setValor(valor);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] Valor deve ser um número válido");
        }

        if (dto_id_escolha == null || dto_id_escolha.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID da escolha de ingrediente é obrigatório");
        }
        try {
            IngredienteEscolha escolha = new IngredienteEscolha();
            escolha.setId(Long.parseLong(dto_id_escolha.trim()));
            ingrediente.setIngredienteEscolhas(escolha);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID da escolha de ingrediente inválido");
        }
        
        return ingrediente;
    }
}
