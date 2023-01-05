package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Pais;

import java.io.Serializable;

public class PaisDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    public PaisDto() {
    }

    public PaisDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public PaisDto(Pais entidade) {
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

    @Override
    public String toString() {
        return "PaisDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
