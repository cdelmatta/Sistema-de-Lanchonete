package model;

public class Bairro {

    private Long id;
    private String bairro;
    private Endereco enderecos;

    public Bairro() {
    }

    public Bairro(String bairro, Endereco enderecos) {
        this.bairro = bairro;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Endereco getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos = enderecos;
    }

}
