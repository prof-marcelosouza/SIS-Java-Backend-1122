package br.com.sisnema.copaQatar2022.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tabela_posicao")
public class Posicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @OneToMany(mappedBy = "posicao")
    private List<Jogador> jogadores = new ArrayList<>();

    public Posicao() {
    }

    public Posicao(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Posicao posicao = (Posicao) o;

        return Objects.equals(id, posicao.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Posicao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
