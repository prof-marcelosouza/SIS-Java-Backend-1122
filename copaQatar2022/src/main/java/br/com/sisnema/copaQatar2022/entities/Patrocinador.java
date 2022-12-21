package br.com.sisnema.copaQatar2022.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tabela_patrocinador")
public class Patrocinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tabela_patrocinador_jogador",
            joinColumns = @JoinColumn(name = "patrocinador_id"),
            inverseJoinColumns = @JoinColumn(name = "jogador_id"))
    private Set<Jogador> jogadores = new HashSet<>();

    public Patrocinador() {
    }

    public Patrocinador(Long id, String nome) {
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

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patrocinador that = (Patrocinador) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Patrocinador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
