package br.com.sisnema.musica.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tabela_estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Artista> artistas = new ArrayList<>();

    public Estado() {
    }

    public Estado(Long id, String nome) {
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

    public List<Artista> getArtistas() {
        return artistas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estado pais = (Estado) o;

        return Objects.equals(id, pais.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", artistas=" + artistas +
                '}';
    }
}
