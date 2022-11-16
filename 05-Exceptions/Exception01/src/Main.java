import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num1, num2, div;

        try {
            System.out.print("Digite o número 01: ");
            num1 = sc.nextInt();
            System.out.print("Digite o número 02: ");
            num2 = sc.nextInt();
            div = num1 / num2;
            System.out.print("Resultado: " + div);
        }
        catch (ArithmeticException e1) {
            System.err.println("Erro na divisão. Você não pode dividir por zero!");
        }
        catch (InputMismatchException e2) {
            System.err.println("Erro na entrada de dados!");
        }
        finally { // Facultativo
            System.out.println("Programa finalizado com sucesso!");
            sc.close();
        }

    }

}