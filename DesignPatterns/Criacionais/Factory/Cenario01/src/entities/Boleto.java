package entities;

public abstract class Boleto {

    private double valor;
    protected double juro;
    protected double desconto;
    protected double multa;

    public Boleto(double valor) {
        this.valor = valor;
    }

    public double calcularJuro() {
        return this.valor * this.juro;
    }

    public double calcularDesconto() {
        return this.valor * this.desconto;
    }

    public double calcularMulta() {
        return this.valor * this.multa;
    }
}
