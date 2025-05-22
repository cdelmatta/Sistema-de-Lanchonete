package model;

public class Reembolso {

    private Long id;
    private String motivo;
    private Pedido pedidos;

    public Reembolso() {
    }

    public Reembolso(Long id, String motivo, Pedido pedidos) {
        this.id = id;
        this.motivo = motivo;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

}
