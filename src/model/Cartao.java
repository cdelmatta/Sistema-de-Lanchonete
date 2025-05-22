package model;

public class Cartao {

    private Long id;
    private String numero_cartao;
    private int cvv;
    private int tipo; //1 para credito e 2 para debito.
    private MetPagamento metPagamentos;

    public Cartao() {
    }

    public Cartao(Long id, String numero_cartao, int cvv, int tipo, MetPagamento metPagamentos) {
        this.id = id;
        this.numero_cartao = numero_cartao;
        this.cvv = cvv;
        this.tipo = tipo;
        this.metPagamentos = metPagamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero_cartao() {
        return numero_cartao;
    }

    public void setNumero_cartao(String numero_cartao) {
        this.numero_cartao = numero_cartao;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public MetPagamento getMetPagamentos() {
        return metPagamentos;
    }

    public void setMetPagamentos(MetPagamento metPagamentos) {
        this.metPagamentos = metPagamentos;
    }

}
