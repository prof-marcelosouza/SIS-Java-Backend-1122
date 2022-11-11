package entities;

import java.time.Instant;
import java.util.Objects;

public class Produto {

    // Declaração de atributos
    // Devem ser acessados apenas dentro da classe (Encapsulamento)
    private Integer id;
    private String nome;
    private String desc;
    private Double valor;
    private Integer estoque;
    private Instant dataCadastro;

    // Construtores
    public Produto() {
    }

    // Aqui temos uma sobrecarga
    public Produto(Integer id, String nome, String desc) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
    }

    public Produto(Integer id, String nome, String desc, Double valor, Integer estoque, Instant dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.valor = valor;
        this.estoque = estoque;
        this.dataCadastro = dataCadastro;
    }

    // Métodos
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // Métodos customizados

    // Equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override // Significa que é uma SOBRESCRITA
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desc='" + desc + '\'' +
                ", valor=" + valor +
                ", estoque=" + estoque +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
