package model;

public class Delivery {

    private Long id;
    private int chaveEntrega;
    private int numero;
    private String complemento;
    private Entrega entregas;

    public Delivery() {
    }

    public Delivery(Long id, int chaveEntrega, int numero, String complemento, Entrega entregas) {
        this.id = id;
        this.chaveEntrega = chaveEntrega;
        this.numero = numero;
        this.complemento = complemento;
        this.entregas = entregas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getChaveEntrega() {
        return chaveEntrega;
    }

    public void setChaveEntrega(int chaveEntrega) {
        this.chaveEntrega = chaveEntrega;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Entrega getEntregas() {
        return entregas;
    }

    public void setEntregas(Entrega entregas) {
        this.entregas = entregas;
    }

}
