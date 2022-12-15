package br.com.sisnema.musica.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tabela_festival")
public class Festival implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Instant dataEvento;
    // Atenção ao atributo no BD = data_evento

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tabela_festival_artista",
            joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "artista_id"))
    private Set<Artista> artistas = new HashSet<>();

    public Festival() {
    }

    public Festival(Long id, String nome, Instant dataEvento) {
        this.id = id;
        this.nome = nome;
        this.dataEvento = dataEvento;
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

    public Instant getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Instant dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Set<Artista> getArtistas() {
        return artistas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Festival festival = (Festival) o;

        return Objects.equals(id, festival.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Festival{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataEvento=" + dataEvento +
                '}';
    }
}
