package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Festival;

import java.io.Serializable;

public class FestivalDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String dataEvento;

    public FestivalDto() {
    }

    public FestivalDto(Long id, String nome, String dataEvento) {
        this.id = id;
        this.nome = nome;
        this.dataEvento = dataEvento;
    }

    public FestivalDto(Festival entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.dataEvento = entidade.getDataEvento();
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

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }
}
