import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Integer n1, n2, adic, sub, mult, div, resto;
        Double d1, d2, adic_d, sub_d, mult_d, div_d, resto_d;

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

//        System.out.print("Digite o valor de n1: ");
//        n1 = sc.nextInt();
//        System.out.print("Digite o valor de n2: ");
//        n2 = sc.nextInt();

        // Operações matemáticas com Integer
//        adic = n1 + n2;
//        sub = n1 - n2;
//        mult = n1 * n2;
//        div = n1 / n2;
//        resto = n1 % n2; // Calcula o resto da divisão
//
//        System.out.println("Resultado da adição de inteiros: " + adic);
//        System.out.println("Resultado da subtração de inteiros: " + sub);
//        System.out.println("Resultado da multiplicação de inteiros: " + mult);
//        System.out.println("Resultado da divisão de inteiros: " + div);
//        System.out.println("Resultado do resto da divisão de inteiros: " + resto);

        System.out.print("Digite o valor de d1: ");
        d1 = sc.nextDouble();
        System.out.print("Digite o valor de d2: ");
        d2 = sc.nextDouble();

        // Operações matemáticas com Double
        adic_d = d1 + d2;
        sub_d = d1 - d2;
        mult_d = d1 * d2;
        div_d = d1 / d2;

        System.out.println("Resultado da adição de pontos flutuantes: " + adic_d);
        System.out.println("Resultado da subtração de pontos flutuantes: " + sub_d);
        System.out.println("Resultado da multiplicação de pontos flutuantes: " + mult_d);
        System.out.println("Resultado da divisão de pontos flutuantes: " + div_d);
        System.out.printf("Resultado da divisão de pontos flutuantes: %.2f%n", div_d);
        System.out.print("Fim do programa!");

        sc.close(); // Destroi o objeto Scanner da memória
    }

}