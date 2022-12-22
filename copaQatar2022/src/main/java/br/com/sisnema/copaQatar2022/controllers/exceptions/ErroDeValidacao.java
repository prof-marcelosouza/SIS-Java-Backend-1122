package br.com.sisnema.copaQatar2022.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErroDeValidacao extends ErroPadrao {
    private static final long serialVersionUID = 1L;

    // Uma lista para concatenar as mensagens de erro.
    private List<MensagemPorCampo> erros = new ArrayList<>();

    public List<MensagemPorCampo> getErros() {
        return erros;
    }

    public void AddErro(String nomeDoCampo, String mensagem) {
        erros.add(new MensagemPorCampo(nomeDoCampo, mensagem));
    }
}
