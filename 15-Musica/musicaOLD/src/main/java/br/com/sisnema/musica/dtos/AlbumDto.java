package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Album;

import java.io.Serializable;

public class AlbumDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;
    private Integer ano;
    private Long artista_id;
    private Long genero_id;

    public AlbumDto() {
    }

    public AlbumDto(Long id, String titulo, Integer ano, Long artista_id, Long genero_id) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.artista_id = artista_id;
        this.genero_id = genero_id;
    }

    public AlbumDto(Album entidade) {
        this.id = entidade.getId();
        this.titulo = entidade.getTitulo();
        this.ano = entidade.getAno();
        this.artista_id = entidade.getArtista().getId();
        this.genero_id = entidade.getGenero().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Long getArtista_id() {
        return artista_id;
    }

    public void setArtista_id(Long artista_id) {
        this.artista_id = artista_id;
    }

    public Long getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(Long genero_id) {
        this.genero_id = genero_id;
    }
}
