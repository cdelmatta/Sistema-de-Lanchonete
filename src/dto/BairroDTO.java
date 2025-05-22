package dto;

import model.Bairro;
import model.Endereco;

public class BairroDTO {

    public String NomeBairro;
    public String idBairro;
    public String idEndereco;

    public Bairro builder() {
        Bairro b = new Bairro();

        b.setId(idBairro == null || idBairro.trim().isEmpty() ? 0L : parseId(idBairro));
        b.setBairro(NomeBairro);
        if (idEndereco != null && !idEndereco.trim().isEmpty()) {
            Endereco endereco = new Endereco();
            endereco.setId(parseId(idEndereco));
            b.setEnderecos(endereco);
        }

        return b;

    }

    private Long parseId(String id) {
        try {
            return Long.parseLong(id.trim());
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

}
