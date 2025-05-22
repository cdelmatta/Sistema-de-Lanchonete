package dto;

import model.Carrinho;
import model.Pedido;
import model.IngredienteEscolha;
import model.Produto;

public class CarrinhoDTO {

    public String idCarrinho;
    public String qtd;
    public String idPedido;
    public String idIngredienteEscolha;
    public String idProduto;

    public Carrinho builder() {
        Carrinho c = new Carrinho();

        c.setId(idCarrinho == null || idCarrinho.trim().isEmpty() ? 0L : parseId(idCarrinho));

        try {
            c.setQuantidade(Integer.parseInt(qtd.trim()));
        } catch (NumberFormatException | NullPointerException e) {
            c.setQuantidade(0);
        }

        if (idPedido != null && !idPedido.trim().isEmpty()) {
            Pedido p = new Pedido();
            p.setId(Long.parseLong(idPedido.trim()));
            c.setPedidos(p);
        }

        if (idIngredienteEscolha != null && !idIngredienteEscolha.trim().isEmpty()) {
            IngredienteEscolha ie = new IngredienteEscolha();
            ie.setId(Long.parseLong(idIngredienteEscolha.trim()));
            c.setIngredienteEscolhas(ie);
        }

        if (idProduto != null && !idProduto.trim().isEmpty()) {
            Produto p = new Produto();
            p.setId(Long.parseLong(idProduto.trim()));
            c.setProdutos(p);
        }

        return c;
    }

    private Long parseId(String id) {
        try {
            return Long.parseLong(id.trim());
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
