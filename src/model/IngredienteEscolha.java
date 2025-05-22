package model;

import java.util.List;

public class IngredienteEscolha {

    private Long id;
    private List<Carrinho> carrinhos;
    private List<IngredienteRemover> ingredienteRevomers;
    private List<IngredienteAdicional> ingredienteAdicionals;

    public IngredienteEscolha() {
    }

    public IngredienteEscolha(Long id, List<Carrinho> carrinhos, List<IngredienteRemover> ingredienteRevomers, List<IngredienteAdicional> ingredienteAdicionals) {
        this.id = id;
        this.carrinhos = carrinhos;
        this.ingredienteRevomers = ingredienteRevomers;
        this.ingredienteAdicionals = ingredienteAdicionals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

    public void setCarrinhos(List<Carrinho> carrinhos) {
        this.carrinhos = carrinhos;
    }

    public List<IngredienteRemover> getIngredienteRevomers() {
        return ingredienteRevomers;
    }

    public void setIngredienteRevomers(List<IngredienteRemover> ingredienteRevomers) {
        this.ingredienteRevomers = ingredienteRevomers;
    }

    public List<IngredienteAdicional> getIngredienteAdicionals() {
        return ingredienteAdicionals;
    }

    public void setIngredienteAdicionals(List<IngredienteAdicional> ingredienteAdicionals) {
        this.ingredienteAdicionals = ingredienteAdicionals;
    }

}
