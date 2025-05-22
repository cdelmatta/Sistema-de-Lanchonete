package model;

import java.util.List;

public class IngredienteRemover {

    private Long id;
    private String nome;
    private IngredienteEscolha ingredienteEscolhas;

    public IngredienteRemover() {
    }

    public IngredienteRemover(Long id, String nome, IngredienteEscolha ingredienteEscolhas) {
        this.id = id;
        this.nome = nome;
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

    public IngredienteEscolha getIngredienteEscolhas() {
        return ingredienteEscolhas;
    }

    public void setIngredienteEscolhas(IngredienteEscolha ingredienteEscolhas) {
        this.ingredienteEscolhas = ingredienteEscolhas;
    }

}
