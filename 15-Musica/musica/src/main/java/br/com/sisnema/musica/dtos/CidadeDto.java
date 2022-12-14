package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Cidade;

import java.io.Serializable;

public class CidadeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public CidadeDto() {
    }

    public CidadeDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CidadeDto(Cidade entidade) {
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
