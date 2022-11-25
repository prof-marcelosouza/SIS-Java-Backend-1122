package entities;

import entities.types.Boleto10d;
import entities.types.Boleto30d;
import entities.types.Boleto60d;

public class Banco {

    // Para acessar o método criarBoleto
    private BoletoSimpleFactory boletoSimpleFactory;

    public Banco(BoletoSimpleFactory boletoSimpleFactory) {
        this.boletoSimpleFactory = boletoSimpleFactory;
    }

    public Boleto gerarBoleto(int venc, double valor) throws Exception {

        Boleto boleto = this.boletoSimpleFactory.criarBoleto(venc, valor);

        System.out.println("Valor do boleto gerado: " + valor);
        System.out.println("Valor do juro: " + boleto.calcularJuro());
        System.out.println("Valor do desconto: " + boleto.calcularDesconto());
        System.out.println("Valor da multa: " + boleto.calcularMulta());
        System.out.println("-------------------------------------------------");

        return boleto;
    }

}
