package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Estado;

public class EstadoDto {

    private Long id;
    private String nome;

    public EstadoDto() {
    }

    public EstadoDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public EstadoDto(Estado entidade) {
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
