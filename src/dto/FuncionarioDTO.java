package dto;

import model.Funcionario;
import model.Login;
import model.Telefone;

public class FuncionarioDTO {
    public String dto_id_funcionario;
    public String dto_id_login;
    public String dto_cpf;
    public String dto_rg;
    public String dto_id_telefone;

    public Funcionario builder() {
        Funcionario funcionario = new Funcionario();
        
        if (dto_id_funcionario != null && !dto_id_funcionario.trim().isEmpty()) {
            try {
                funcionario.setId(Long.parseLong(dto_id_funcionario.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do funcionário inválido");
            }
        }

        if (dto_id_login == null || dto_id_login.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do login é obrigatório");
        }
        try {
            Login login = new Login();
            login.setId(Long.parseLong(dto_id_login.trim()));
            funcionario.setLogins(login);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do login inválido");
        }

        if (dto_cpf == null || !dto_cpf.trim().matches("\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}")) {
            throw new IllegalArgumentException("[ERRO] CPF inválido (formato: 000.000.000-00)");
        }
        funcionario.setCpf(dto_cpf.trim().replaceAll("[^0-9]", ""));

        if (dto_rg == null || dto_rg.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] RG é obrigatório");
        }
        funcionario.setRg(dto_rg.trim());

        if (dto_id_telefone == null || dto_id_telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do telefone é obrigatório");
        }
        try {
            Telefone telefone = new Telefone();
            telefone.setId(Long.parseLong(dto_id_telefone.trim()));
            funcionario.setTelefones(telefone);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do telefone inválido");
        }
        
        return funcionario;
    }
}
