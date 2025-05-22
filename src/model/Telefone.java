package model;

import java.util.List;

public class Telefone {

    private Long id;
    private int ddd;
    private String numero;
    private Funcionario funcionarios;
    private Cliente clientes;

    public Telefone() {
    }

    public Telefone(Long id, int ddd, String numero, Funcionario funcionarios, Cliente clientes) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
        this.funcionarios = funcionarios;
        this.clientes = clientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Funcionario getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

}
