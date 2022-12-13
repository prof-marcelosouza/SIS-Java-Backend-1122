package br.com.sisnema.musica.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tabela_festival")
public class Festival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataEvento;
    // Atenção ao atributo no BD = data_evento

    @ManyToMany
    @JoinTable(name = "tabela_festival_artista",
            joinColumns = @JoinColumn(name = "festival_id"),
            inverseJoinColumns = @JoinColumn(name = "artista_id"))
    private Set<Artista> artistas = new HashSet<>();

    public Festival() {
    }

    public Festival(Long id, String nome, String dataEvento) {
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

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
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