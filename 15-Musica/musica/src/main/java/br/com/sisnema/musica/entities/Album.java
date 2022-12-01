package br.com.sisnema.musica.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity // Cria uma tabela via Spring Data
@Table(name = "tabela_album") // Renomeia Artista para tabela_artista
public class Album {

    @Id // Campo definido como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremento
    private Long id;
    private String titulo;
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    public Album() {
    }

    public Album(Long id, String titulo, Integer ano) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        return Objects.equals(id, album.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                '}';
    }
}
