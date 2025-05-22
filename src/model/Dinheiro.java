package model;

public class Dinheiro {

    private Long id;
    private double valor_entregado;
    private MetPagamento metPagamentos;

    public Dinheiro() {
    }

    public Dinheiro(Long id, double valor_entregado, MetPagamento metPagamentos) {
        this.id = id;
        this.valor_entregado = valor_entregado;
        this.metPagamentos = metPagamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor_entregado() {
        return valor_entregado;
    }

    public void setValor_entregado(double valor_entregado) {
        this.valor_entregado = valor_entregado;
    }

    public MetPagamento getMetPagamentos() {
        return metPagamentos;
    }

    public void setMetPagamentos(MetPagamento metPagamentos) {
        this.metPagamentos = metPagamentos;
    }

}
