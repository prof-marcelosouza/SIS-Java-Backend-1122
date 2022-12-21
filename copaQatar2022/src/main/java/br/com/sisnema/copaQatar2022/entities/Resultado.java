package br.com.sisnema.copaQatar2022.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tabela_resultado")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer placar1;
    private Integer placar2;

    public Resultado() {
    }

    public Resultado(Long id, Integer placar1, Integer placar2) {
        this.id = id;
        this.placar1 = placar1;
        this.placar2 = placar2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlacar1() {
        return placar1;
    }

    public void setPlacar1(Integer placar1) {
        this.placar1 = placar1;
    }

    public Integer getPlacar2() {
        return placar2;
    }

    public void setPlacar2(Integer placar2) {
        this.placar2 = placar2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resultado resultado = (Resultado) o;

        return Objects.equals(id, resultado.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "id=" + id +
                ", placar1=" + placar1 +
                ", placar2=" + placar2 +
                '}';
    }
}
