package model;

public class TaxaEntrega {

    private Long id;
    private Endereco enderecos;

    public TaxaEntrega() {
    }

    public TaxaEntrega(Long id, Endereco enderecos) {
        this.id = id;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos = enderecos;
    }

}
