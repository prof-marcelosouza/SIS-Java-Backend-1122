package entities.types;

import entities.Boleto;

public class Boleto10d extends Boleto {

    public Boleto10d(double valor) {
        super(valor);
        juro = 0.02;
        desconto = 0.1;
        multa = 0.05;
    }

}
