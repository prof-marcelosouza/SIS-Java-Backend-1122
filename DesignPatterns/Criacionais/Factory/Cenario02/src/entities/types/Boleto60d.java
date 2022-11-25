package entities.types;

import entities.Boleto;

public class Boleto60d extends Boleto {

    public Boleto60d(double valor) {
        super(valor);
        juro = 0.1;
        desconto = 0.0;
        multa = 0.2;
    }

}
