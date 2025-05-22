package model;

import java.util.List;

public class Funcionario {

    private Long id;
    private Login logins;
    private String cpf;
    private String rg;
    private Telefone telefones;

    public Funcionario() {
    }

    public Funcionario(Long id, Login logins, String cpf, String rg, Telefone telefones) {
        this.id = id;
        this.logins = logins;
        this.cpf = cpf;
        this.rg = rg;
        this.telefones = telefones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Login getLogins() {
        return logins;
    }

    public void setLogins(Login logins) {
        this.logins = logins;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Telefone getTelefones() {
        return telefones;
    }

    public void setTelefones(Telefone telefones) {
        this.telefones = telefones;
    }

}
