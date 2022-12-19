package org.example.entities;

public class Conta {

    public static Double TAXADEDEPOSITO = 0.02;

    private Long id;
    private Double saldo;

    public Conta() {
    }

    public Conta(Long id, Double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    // No depósito se cobra uma taxa de 0,02%;
    public void depositar(Double valor) { // 100,00
        if (valor > 0) {
            valor = valor - (valor * TAXADEDEPOSITO); // 100 - 100 * 0.02
            this.saldo = this.saldo + valor; // + 98.00
        }
    }

    public void sacar(Double valor) {
        if (valor > saldo) {
            throw new IllegalArgumentException();
        }
        this.saldo = this.saldo - valor;
    }

    public Double sacarTodaConta() {
        double auxiliar = saldo;
        saldo = 0.0;
        return auxiliar;
    }
}
