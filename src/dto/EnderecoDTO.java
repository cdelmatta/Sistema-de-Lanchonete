package dto;

import model.Endereco;
import model.Bairro;
import model.TaxaEntrega;

public class EnderecoDTO {
    public String dto_id_endereco;
    public String dto_rua;
    public String dto_cep;
    public String dto_distancia;
    public String dto_id_bairro;
    public String dto_id_taxa_entrega;

    public Endereco builder() {
        Endereco endereco = new Endereco();
        
        if (dto_id_endereco != null && !dto_id_endereco.trim().isEmpty()) {
            try {
                endereco.setId(Long.parseLong(dto_id_endereco.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do endereço inválido");
            }
        }

        if (dto_rua == null || dto_rua.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] Rua é obrigatória");
        }
        endereco.setRua(dto_rua.trim());

        if (dto_cep == null || !dto_cep.trim().matches("\\d{5}-?\\d{3}")) {
            throw new IllegalArgumentException("[ERRO] CEP inválido (formato: 00000-000)");
        }
        endereco.setCep(dto_cep.trim().replace("-", ""));

        if (dto_distancia == null || dto_distancia.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] Distância é obrigatória");
        }
        try {
            int distancia = Integer.parseInt(dto_distancia.trim());
            if (distancia < 0) throw new IllegalArgumentException("[ERRO] Distância não pode ser negativa");
            endereco.setDistancia(distancia);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] Distância deve ser um número inteiro");
        }

        if (dto_id_bairro == null || dto_id_bairro.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do bairro é obrigatório");
        }
        try {
            Bairro bairro = new Bairro();
            bairro.setId(Long.parseLong(dto_id_bairro.trim()));
            endereco.setBairros(bairro);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do bairro inválido");
        }

        if (dto_id_taxa_entrega == null || dto_id_taxa_entrega.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID da taxa de entrega é obrigatório");
        }
        try {
            TaxaEntrega taxa = new TaxaEntrega();
            taxa.setId(Long.parseLong(dto_id_taxa_entrega.trim()));
            endereco.setTaxaEntregas(taxa);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID da taxa de entrega inválido");
        }
        
        return endereco;
    }
}
