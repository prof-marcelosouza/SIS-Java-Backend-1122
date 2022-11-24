import entities.Pedido;
import entities.PedidoBazar;
import entities.PedidoEletro;
import entities.fretes.FreteComum;
import entities.fretes.FreteExpresso;
import entities.fretes.FretePJ;
import entities.fretes.FretePrime;

public class Main {

    public static void main(String[] args) throws Exception {

        FreteComum freteComum = new FreteComum();
        FreteExpresso freteExpresso = new FreteExpresso();
        FretePrime fretePrime = new FretePrime();
        FretePJ fretePJ = new FretePJ();

        Pedido pe = new PedidoEletro(1000.0, "DVD");
        System.out.println("Pedido do setor de Eletro:");
        pe.setTipoFrete(freteComum);
        System.out.println("Frete comum: R$" + pe.calcularFrete());

        Pedido pe2 = new PedidoEletro(1000.0, "DVD");
        pe2.setTipoFrete(freteExpresso);
        System.out.println("Frete expresso: R$" + pe2.calcularFrete());

        Pedido pe3 = new PedidoEletro(1000.0, "DVD");
        pe3.setTipoFrete(fretePrime);
        System.out.println("Frete Prime: R$" + pe3.calcularFrete());

        Pedido pe4 = new PedidoEletro(1000.0, "DVD");
        pe4.setTipoFrete(fretePJ);
        System.out.println("Frete PJ: R$" + pe4.calcularFrete());

    }
}