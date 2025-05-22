package model;

import java.util.List;

public class Cliente {

    private Long id;
    private String nome;
    private Telefone telefones;
    private List<Entrega> entregas;
    private List<Pedido> pedidos;

    public Cliente() {
    }

    public Cliente(Long id, String nome, Telefone telefones, List<Entrega> entregas, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
        this.entregas = entregas;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getTelefones() {
        return telefones;
    }

    public void setTelefones(Telefone telefones) {
        this.telefones = telefones;
    }

    public List<Entrega> getEntregas() {
        return entregas;
    }

    public void setEntregas(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
