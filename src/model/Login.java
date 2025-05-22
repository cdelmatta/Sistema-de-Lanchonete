package model;

public class Login {

    private Long id;
    private String senha;
    private String login_funcinario;
    private Funcionario funcionarios;

    public Login() {
    }

    public Login(Long id, String senha, String login_funcinario, Funcionario funcionarios) {
        this.id = id;
        this.senha = senha;
        this.login_funcinario = login_funcinario;
        this.funcionarios = funcionarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin_funcinario() {
        return login_funcinario;
    }

    public void setLogin_funcinario(String login_funcinario) {
        this.login_funcinario = login_funcinario;
    }

    public Funcionario getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionarios) {
        this.funcionarios = funcionarios;
    }

}
