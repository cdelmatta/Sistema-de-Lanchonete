package model;

import java.util.List;

public class Carrinho {

    private Long id;
    private int quantidade;
    private Pedido pedidos;
    private IngredienteEscolha ingredienteEscolhas;
    private Produto produtos;

    public Carrinho() {
    }

    public Carrinho(Long id, int quantidade, Pedido pedidos, IngredienteEscolha ingredienteEscolhas, Produto produtos) {
        this.id = id;
        this.quantidade = quantidade;
        this.pedidos = pedidos;
        this.ingredienteEscolhas = ingredienteEscolhas;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

    public IngredienteEscolha getIngredienteEscolhas() {
        return ingredienteEscolhas;
    }

    public void setIngredienteEscolhas(IngredienteEscolha ingredienteEscolhas) {
        this.ingredienteEscolhas = ingredienteEscolhas;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

}
