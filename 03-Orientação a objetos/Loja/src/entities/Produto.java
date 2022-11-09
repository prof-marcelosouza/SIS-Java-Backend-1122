package entities;

import java.time.Instant;

public class Produto {

    // Declaração de atributos
    public Integer id;
    public String nome;
    public String desc;
    public Double valor;
    public Integer estoque;
    public Instant dataCadastro;

    // Construtores
    public Produto(){
    }

    // Métodos
    @Override
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
