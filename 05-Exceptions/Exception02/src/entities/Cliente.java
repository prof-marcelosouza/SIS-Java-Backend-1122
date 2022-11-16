package entities;

import exceptions.ClienteException;

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
    public void depositar(Double valor) throws ClienteException {
        if (valor <= 0.0) {
            throw new ClienteException("Valor inválido para depósito!");
        } else {
            saldoEmConta = saldoEmConta + valor;
        }
    }

    public void comprar(Double valor) throws ClienteException {
        if (saldoEmConta + limite < valor) {
            throw new ClienteException("Saldo insuficiente!");
        } else {
            saldoEmConta = saldoEmConta - valor;
        }
    }

    public void contrairDivida(Double valor) throws ClienteException {
        if (valor <= 0.0) {
            throw new ClienteException("Valor inválido!");
        } else {
            divida = divida + valor;
            System.out.println("Você contratou uma dívida de R$" + divida);
        }
    }

    public void pagarDivida(Double valor) throws ClienteException {
        
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
