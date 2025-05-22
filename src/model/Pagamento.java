package model;

public class Pagamento {

    private Long id;
    private Pedido pedidos;
    private MetPagamento metPagamentos;
    private Cupom cupoms;

    public Pagamento() {
    }

    public Pagamento(Long id, Pedido pedidos, MetPagamento metPagamentos, Cupom cupoms) {
        this.id = id;
        this.pedidos = pedidos;
        this.metPagamentos = metPagamentos;
        this.cupoms = cupoms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

    public MetPagamento getMetPagamentos() {
        return metPagamentos;
    }

    public void setMetPagamentos(MetPagamento metPagamentos) {
        this.metPagamentos = metPagamentos;
    }

    public Cupom getCupoms() {
        return cupoms;
    }

    public void setCupoms(Cupom cupoms) {
        this.cupoms = cupoms;
    }

}
