package model;

public class IngredienteAdicional {

    private Long id;
    private String nome;
    private double valor;
    private IngredienteEscolha ingredienteEscolhas;

    public IngredienteAdicional() {
    }

    public IngredienteAdicional(Long id, String nome, double valor, IngredienteEscolha ingredienteEscolhas) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ingredienteEscolhas = ingredienteEscolhas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public IngredienteEscolha getIngredienteEscolhas() {
        return ingredienteEscolhas;
    }

    public void setIngredienteEscolhas(IngredienteEscolha ingredienteEscolhas) {
        this.ingredienteEscolhas = ingredienteEscolhas;
    }

}
