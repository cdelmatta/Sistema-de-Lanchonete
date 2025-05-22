package model;

public class Endereco {

    private Long id;
    private String rua;
    private String cep;
    private int distancia;
    private Bairro bairros;
    private TaxaEntrega taxaEntregas;

    public Endereco() {
    }

    public Endereco(Long id, String rua, String cep, int distancia, Bairro bairros, TaxaEntrega taxaEntregas) {
        this.id = id;
        this.rua = rua;
        this.cep = cep;
        this.distancia = distancia;
        this.bairros = bairros;
        this.taxaEntregas = taxaEntregas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Bairro getBairros() {
        return bairros;
    }

    public void setBairros(Bairro bairros) {
        this.bairros = bairros;
    }

    public TaxaEntrega getTaxaEntregas() {
        return taxaEntregas;
    }

    public void setTaxaEntregas(TaxaEntrega taxaEntregas) {
        this.taxaEntregas = taxaEntregas;
    }

}
