package br.com.sisnema.copaQatar2022.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tabela_partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant diaHora;

    public Partida() {
    }

    public Partida(Long id, Instant diaHora) {
        this.id = id;
        this.diaHora = diaHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(Instant diaHora) {
        this.diaHora = diaHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partida partida = (Partida) o;

        return Objects.equals(id, partida.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", diaHora=" + diaHora +
                '}';
    }
}
