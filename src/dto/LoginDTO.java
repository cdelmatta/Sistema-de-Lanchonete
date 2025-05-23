package dto;

import model.Login;
import model.Funcionario;

public class LoginDTO {
    public String dto_id_login;
    public String dto_senha;
    public String dto_login_funcionario;
    public String dto_id_funcionario;

    public Login builder() {
        Login login = new Login();
        
        if (dto_id_login != null && !dto_id_login.trim().isEmpty()) {
            try {
                login.setId(Long.parseLong(dto_id_login.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERRO] ID do login inválido");
            }
        }

        if (dto_senha == null || dto_senha.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] Senha é obrigatória");
        }
        login.setSenha(dto_senha.trim());

        if (dto_login_funcionario == null || dto_login_funcionario.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] Login do funcionário é obrigatório");
        }
        login.setLogin_funcinario(dto_login_funcionario.trim());

        if (dto_id_funcionario == null || dto_id_funcionario.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERRO] ID do funcionário é obrigatório");
        }
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(Long.parseLong(dto_id_funcionario.trim()));
            login.setFuncionarios(funcionario);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERRO] ID do funcionário inválido");
        }
        
        return login;
    }
}
