package entities;

import java.util.Objects;

public abstract class Pedido {

    private Double valor;
    private Frete tipoFrete;

    public Pedido() {
    }

    public Pedido(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    // Métodos customizados
    public void setTipoFrete(Frete tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    public double calcularFrete() {
        return this.tipoFrete.calcular(this.valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        return Objects.equals(valor, pedido.valor);
    }

    @Override
    public int hashCode() {
        return valor != null ? valor.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "valor=" + valor +
                '}';
    }
}
