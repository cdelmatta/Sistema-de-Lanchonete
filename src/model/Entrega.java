package model;

public class Entrega {

    private Long id;
    private int tipoEntrega;
    private Cliente clientes;
    private Delivery deliverys;
    private Pedido pedidos;

    public Entrega() {
    }

    public Entrega(Long id, int tipoEntrega, Cliente clientes, Delivery deliverys, Pedido pedidos) {
        this.id = id;
        this.tipoEntrega = tipoEntrega;
        this.clientes = clientes;
        this.deliverys = deliverys;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(int tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public Delivery getDeliverys() {
        return deliverys;
    }

    public void setDeliverys(Delivery deliverys) {
        this.deliverys = deliverys;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

}
