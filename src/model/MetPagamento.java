package model;

public class MetPagamento {

    private Long id;
    private double pix;
    private Pagamento pagamentos;
    private Cartao cartaos;
    private Dinheiro dinheiros;

    public MetPagamento() {
    }

    public MetPagamento(Long id, double pix, Pagamento pagamentos, Cartao cartaos, Dinheiro dinheiros) {
        this.id = id;
        this.pix = pix;
        this.pagamentos = pagamentos;
        this.cartaos = cartaos;
        this.dinheiros = dinheiros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPix() {
        return pix;
    }

    public void setPix(double pix) {
        this.pix = pix;
    }

    public Pagamento getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamento pagamentos) {
        this.pagamentos = pagamentos;
    }

    public Cartao getCartaos() {
        return cartaos;
    }

    public void setCartaos(Cartao cartaos) {
        this.cartaos = cartaos;
    }

    public Dinheiro getDinheiros() {
        return dinheiros;
    }

    public void setDinheiros(Dinheiro dinheiros) {
        this.dinheiros = dinheiros;
    }

}
