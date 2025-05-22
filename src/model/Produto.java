package model;

import java.util.List;

public class Produto {

    private Long id;
    private String nome;
    private double valor_unitario;
    List<Carrinho> carrinhos;

    public Produto() {
    }

    public Produto(Long id, String nome, double valor_unitario, List<Carrinho> carrinhos) {
        this.id = id;
        this.nome = nome;
        this.valor_unitario = valor_unitario;
        this.carrinhos = carrinhos;
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

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

}
