import entities.Pedido;
import entities.PedidoBazar;
import entities.PedidoEletro;

public class Main {

    public static void main(String[] args) throws Exception {

        // Conceito de Polimorfismo
        Pedido pe = new PedidoEletro(1000.0, "DVD");
        System.out.println("Pedido do setor de Eletro:");
        System.out.println("Frete comum: R$" + pe.calcFreteComum());
        System.out.println("Frete expresso: R$" + pe.calcFreteExpresso());

        Pedido pb = new PedidoBazar(1000.0, "Faqueiro");
        System.out.println("Pedido do setor de Bazar:");
        System.out.println("Frete comum: R$" + pb.calcFreteComum());
        System.out.println("Frete expresso: R$" + pb.calcFreteExpresso());

    }
}