package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Funcao;

import java.io.Serializable;

public class FuncaoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String autoridade;

    public FuncaoDto() {
    }

    public FuncaoDto(Long id, String autoridade) {
        this.id = id;
        this.autoridade = autoridade;
    }

    public FuncaoDto(Funcao entidade) {
        this.id = entidade.getId();
        this.autoridade = entidade.getAutoridade();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutoridade() {
        return autoridade;
    }

    public void setAutoridade(String autoridade) {
        this.autoridade = autoridade;
    }
}
