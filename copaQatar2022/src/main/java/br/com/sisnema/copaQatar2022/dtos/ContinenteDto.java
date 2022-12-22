package br.com.sisnema.copaQatar2022.dtos;

import br.com.sisnema.copaQatar2022.entities.Continente;

import java.io.Serializable;

public class ContinenteDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public ContinenteDto() {
    }

    public ContinenteDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ContinenteDto(Continente entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
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
}
