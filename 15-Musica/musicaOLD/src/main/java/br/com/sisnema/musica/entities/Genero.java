package br.com.sisnema.musica.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // Cria uma tabela via Spring Data
@Table(name = "tabela_genero") // Renomeia Genero para tabela_genero
public class Genero implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id // Campo definido como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremento
    private Long id;
    private String nome;

    // Esse gênero verde tem que ser igual ao atributo roxo do outro lado
    @OneToMany(mappedBy = "genero")
    private List<Album> albuns = new ArrayList<>();

    @OneToMany(mappedBy = "genero")
    private List<Artista> artistas = new ArrayList<>();

    public Genero() {
    }

    public Genero(Long id) {
        this.id = id;
    }

    public Genero(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Album> getAlbuns() {
        return albuns;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genero genero = (Genero) o;

        return Objects.equals(id, genero.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
