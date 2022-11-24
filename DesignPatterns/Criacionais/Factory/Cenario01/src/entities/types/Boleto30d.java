package entities.types;

import entities.Boleto;

public class Boleto30d extends Boleto {

    public Boleto30d(double valor) {
        super(valor);
        this.juro = 0.05;
        this.desconto = 0.05;
        this.multa = 0.1;
    }

}
