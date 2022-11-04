import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Integer valor = 1;
//
//        while (valor <= 10) { // Enquanto for TRUE
//            System.out.println(valor);
//            valor++;
//        }

//        int numero = 0;
//
//        // Inicialização; condição; incremento/decremento
//        for (int i = 100; i >= numero; i--) {
//            System.out.println(i);
//        }

        // Declaração de Array
        double[] notas = {6.5, 9.4, 9.8, 6.3, 7.4}; // 0, 1, 2, 3 ,4
        System.out.println("Impressão por posição:");
        System.out.println(notas[0]);
        System.out.println(notas[1]);
        System.out.println(notas[2]);
        System.out.println(notas[3]);
        System.out.println(notas[4]);

        System.out.println("Impressão laço de repetição:");
        for (double x : notas) {
            System.out.println(x);
        }

        System.out.println("Fim do programa!");
    }

}