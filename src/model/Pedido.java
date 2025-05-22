package model;

import java.util.Date;
import java.util.List;

public class Pedido {

    private Long id;
    private String hora_pedido;
    private int numero_pedido;
    private Date data_pedido;
    private Entrega entregas;
    private Cliente clientes;
    private StatusPedido statusPedidos;
    private Pagamento pagamentos;
    private List<Carrinho> carrinhos;
    private Reembolso reembolsos;

    public Pedido() {
    }

    public Pedido(Long id, String hora_pedido, int numero_pedido, Date data_pedido, Entrega entregas, Cliente clientes, StatusPedido statusPedidos, Pagamento pagamentos, List<Carrinho> carrinhos, Reembolso reembolsos) {
        this.id = id;
        this.hora_pedido = hora_pedido;
        this.numero_pedido = numero_pedido;
        this.data_pedido = data_pedido;
        this.entregas = entregas;
        this.clientes = clientes;
        this.statusPedidos = statusPedidos;
        this.pagamentos = pagamentos;
        this.carrinhos = carrinhos;
        this.reembolsos = reembolsos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHora_pedido() {
        return hora_pedido;
    }

    public void setHora_pedido(String hora_pedido) {
        this.hora_pedido = hora_pedido;
    }

    public int getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(int numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Date getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Date data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Entrega getEntregas() {
        return entregas;
    }

    public void setEntregas(Entrega entregas) {
        this.entregas = entregas;
    }

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public StatusPedido getStatusPedidos() {
        return statusPedidos;
    }

    public void setStatusPedidos(StatusPedido statusPedidos) {
        this.statusPedidos = statusPedidos;
    }

    public Pagamento getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamento pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public Reembolso getReembolsos() {
        return reembolsos;
    }

    public void setReembolsos(Reembolso reembolsos) {
        this.reembolsos = reembolsos;
    }

}
