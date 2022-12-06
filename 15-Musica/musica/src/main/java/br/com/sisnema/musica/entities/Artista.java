package br.com.sisnema.musica.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity // Cria uma tabela via Spring Data
@Table(name = "tabela_artista") // Renomeia Artista para tabela_artista
public class Artista {

    @Id // Campo definido como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremento
    private Long id;
    private String nome;
    private boolean banda;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    // Esse artista verde tem que ser igual ao atributo roxo do outro lado
    @OneToMany(mappedBy = "artista")
    private List<Album> albuns = new ArrayList<>();

    public Artista() {
    }

    public Artista(Long id, String nome, boolean banda, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.banda = banda;
        this.pais = pais;
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

    public boolean isBanda() {
        return banda;
    }

    public void setBanda(boolean banda) {
        this.banda = banda;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artista artista = (Artista) o;

        return Objects.equals(id, artista.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", banda=" + banda +
                ", pais=" + pais +
                ", albuns=" + albuns +
                '}';
    }
}
