package entities;

import java.util.Objects;

public class Cliente {

    private String nome;
    private String sobrenome;
    private String rg;
    private Double saldoEmConta;
    private Double limite;
    private Double divida;

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String rg, Double saldoEmConta, Double limite, Double divida) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.saldoEmConta = saldoEmConta;
        this.limite = limite;
        this.divida = divida;
    }

    public Cliente(String nome, String sobrenome, String rg, Double limite) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.saldoEmConta = 0.0;
        this.limite = limite;
        this.divida = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Double getSaldoEmConta() {
        return saldoEmConta;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getDivida() {
        return divida;
    }

    public void setDivida(Double divida) {
        this.divida = divida;
    }

    // Métodos customizados
    public void depositar(Double valor) {
        saldoEmConta = saldoEmConta + valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", rg='" + rg + '\'' +
                ", saldoEmConta=" + saldoEmConta +
                ", limite=" + limite +
                ", divida=" + divida +
                '}';
    }
}
