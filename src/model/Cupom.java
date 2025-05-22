package model;

import java.util.Date;

public class Cupom {

    private Long id;
    private double valor_cupom;
    private String codigo;
    private Date validade;
    private Pagamento pagamentos;

    public Cupom() {
    }

    public Cupom(Long id, double valor_cupom, String codigo, Date validade, Pagamento pagamentos) {
        this.id = id;
        this.valor_cupom = valor_cupom;
        this.codigo = codigo;
        this.validade = validade;
        this.pagamentos = pagamentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor_cupom() {
        return valor_cupom;
    }

    public void setValor_cupom(double valor_cupom) {
        this.valor_cupom = valor_cupom;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Pagamento getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Pagamento pagamentos) {
        this.pagamentos = pagamentos;
    }

}
