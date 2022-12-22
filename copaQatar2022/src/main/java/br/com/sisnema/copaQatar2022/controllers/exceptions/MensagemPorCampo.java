package br.com.sisnema.copaQatar2022.controllers.exceptions;

import java.io.Serializable;

public class MensagemPorCampo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nomeDoCampo;
    private String mensagem;

    public MensagemPorCampo() {
    }

    public MensagemPorCampo(String nomeDoCampo, String mensagem) {
        this.nomeDoCampo = nomeDoCampo;
        this.mensagem = mensagem;
    }

    public String getNomeDoCampo() {
        return nomeDoCampo;
    }

    public void setNomeDoCampo(String nomeDoCampo) {
        this.nomeDoCampo = nomeDoCampo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
