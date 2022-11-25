package entities;

import entities.types.Boleto10d;
import entities.types.Boleto30d;
import entities.types.Boleto60d;

public class BoletoSimpleFactory {

    public Boleto criarBoleto(int vencimento, double valor) throws Exception {

        Boleto boleto = null;

        switch (vencimento) {
            case 10:
                boleto = new Boleto10d(valor);
                break;
            case 30:
                boleto = new Boleto30d(valor);
                break;
            case 60:
                boleto = new Boleto60d(valor);
                break;
            default:
                throw new Exception("Vencimento inválido. Tente outra vez.");
        }

        return boleto;
    }

}
