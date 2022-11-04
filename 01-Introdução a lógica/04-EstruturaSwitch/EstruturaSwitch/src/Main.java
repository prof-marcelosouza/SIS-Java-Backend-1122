import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double valorCompra;
        int perc;

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor da compra: ");
        valorCompra = sc.nextDouble();
        System.out.print("Digite a porcentagem de desconto: ");
        perc = sc.nextInt();

        switch (perc) {
            case 5:
                System.out.print("Desconto de 5% concedido.");
                break;
            case 15:
                System.out.print("Desconto de 15% concedido.");
                break;
            case 25:
                System.out.print("Desconto de 25% concedido.");
                break;
            default:
                System.out.print("Cliente sem desconto.");
        }

        sc.close();

    }
}