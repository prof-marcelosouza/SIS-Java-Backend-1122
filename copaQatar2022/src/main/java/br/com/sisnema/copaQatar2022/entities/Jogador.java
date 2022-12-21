package br.com.sisnema.copaQatar2022.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tabela_jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double peso;
    private Double altura;
    private Double salario;

    @ManyToOne
    @JoinColumn(name = "posicao_id")
    private Posicao posicao;

    @ManyToOne
    @JoinColumn(name = "selecao_id")
    private Selecao selecao;

    public Jogador() {
    }

    public Jogador(Long id, String nome, Double peso, Double altura, Double salario) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.salario = salario;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogador jogador = (Jogador) o;

        return Objects.equals(id, jogador.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", salario=" + salario +
                '}';
    }
}
