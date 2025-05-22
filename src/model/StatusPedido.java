package model;

public class StatusPedido {

    private Long id;
    private String progresso;
    private Pedido pedidos;

    public StatusPedido() {
    }

    public StatusPedido(Long id, String progresso, Pedido pedidos) {
        this.id = id;
        this.progresso = progresso;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProgresso() {
        return progresso;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

}
