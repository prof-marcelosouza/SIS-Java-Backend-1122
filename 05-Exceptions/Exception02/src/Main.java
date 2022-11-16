import entities.Cliente;
import exceptions.ClienteException;

public class Main {

    public static void main(String[] args) {

        Cliente c1 = new Cliente("Michele", "Pinheiro", "2541256988", 0.0);

        try {
            System.out.println("Saldo inicial: " + c1.getSaldoEmConta());
            c1.depositar(500.0);
            System.out.println("Saldo parcial: " + c1.getSaldoEmConta());
            c1.depositar(1000.0);
            System.out.println("Saldo final: " + c1.getSaldoEmConta());
            c1.comprar(500.0);
            System.out.println("Saldo após compra: " + c1.getSaldoEmConta());
            c1.contrairDivida(3500.0);
            c1.pagarDivida(3500.0);
        }
        catch (ClienteException cli) {
            System.err.println(cli);
        }
        finally {
            System.out.println("\nPrograma finalizado.");
        }

    }

}