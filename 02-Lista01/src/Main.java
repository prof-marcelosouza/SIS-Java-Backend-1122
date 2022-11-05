import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /* 1.1.1
        Construa um algoritmo que receba 1 (um) número inteiro e informe se ele é par
        ou ímpar no console.*/

//        int num;
//        System.out.print("Digite um número inteiro: ");
//        num = sc.nextInt();
//
//        if (num % 2 == 0) {
//            System.out.println("O número " + num + " é par!");
//        }
//
//        if (num % 2 != 0) {
//            System.out.println("O número " + num + " é ímpar!");
//        }
        /* 1.1.2
        Construa um algoritmo que receba 3 (três) números inteiros e informe qual é o
        maior número.
        */

//        int n1, n2, n3;
//
//        System.out.println("Digite três números diferentes! ");
//        System.out.print("Digite o número 1: ");
//        n1 = sc.nextInt();
//        System.out.print("Digite o número 2: ");
//        n2 = sc.nextInt();
//        System.out.print("Digite o número 3: ");
//        n3 = sc.nextInt();
//
//        if (n1 > n2 && n1 > n3) {
//            System.out.print("O número " + n1 + " é o maior!");
//        } else if (n2 > n1 && n2 > n3) {
//            System.out.print("O número " + n2 + " é o maior!");
//        } else {
//            System.out.print("O número " + n3 + " é o maior!");
//        }

        /* 1.1.3
        Construa um algoritmo que receba 6 (seis) notas, do tipo double, entre o
        intervalo de 0.0 – 10.0 e logo após calcule a média aritmética. Ao final o
        programa deve imprimir na tela o status do aluno com base nas seguintes
        regras de avaliação:
        0.0 – 2.99 Aluno reprovado por nota;
        3.0 – 5.99 Aluno em recuperação;
        6.0 – 10.0 Aluno aprovado por nota.
        */

//        double n1, n2, n3, n4, n5, n6, media;
//
//        System.out.print("Digite a primeira nota: ");
//        n1 = sc.nextDouble();
//        System.out.print("Digite a segunda nota: ");
//        n2 = sc.nextDouble();
//        System.out.print("Digite a terceira nota: ");
//        n3 = sc.nextDouble();
//        System.out.print("Digite a quarta nota: ");
//        n4 = sc.nextDouble();
//        System.out.print("Digite a quinta nota: ");
//        n5 = sc.nextDouble();
//        System.out.print("Digite a sexta nota: ");
//        n6 = sc.nextDouble();
//
//        media = (n1 + n2 + n3 + n4 + n5 + n6) / 6;
//        System.out.printf("Média do aluno %.2f", media);
//
//        if (media < 3.0) {
//            System.out.print(". Aluno reprovado por nota.");
//        } else if (media >= 6.0) {
//            System.out.print(". Aluno aprovado por nota.");
//        } else {
//            System.out.print(". Aluno em recuperação.");
//        }

        /* 1.2.1
        Construa um algoritmo que receba um número inteiro no intervalo de 1 – 7 e
        imprima na tela o respectivo dia da semana na seguindo a tabela abaixo:
        Caso seja digitado um valor fora do intervalo informar a mensagem: “Número
        inválido”.
        */

//        int num;
//
//        System.out.print("Digite o número referente ao dia da semana: ");
//        num = sc.nextInt();
//
//        switch (num) {
//            case 1:
//                System.out.print("Hoje é Domingo.");
//                break;
//            case 2:
//                System.out.print("Hoje é Segunda-feira.");
//                break;
//            case 3:
//                System.out.print("Hoje é Terça-feira.");
//                break;
//            case 4:
//                System.out.print("Hoje é Quarta-feira.");
//                break;
//            case 5:
//                System.out.print("Hoje é Quinta-feira.");
//                break;
//            case 6:
//                System.out.print("Hoje é Sexta-feira.");
//                break;
//            case 7:
//                System.out.print("Hoje é sábado.");
//                break;
//            default:
//                System.out.print("Número inválido.");
//        }

        /* 1.3.1
        Construa um algoritmo que conte de zero até 50 e imprima somente os números
        ímpares.
        */

//        int numero = 0;
//
//        while (numero < 51) {
//            if (numero % 2 != 0) {
//                System.out.println(numero);
//            }
//            numero++;
//        }

        /* 1.4.1
        Construa um algoritmo que leia os salários de 15 funcionários e ao fim mostre a
        média salarial dos mesmos.
        */

        double salario, mediaSalarial, acumulador = 0.0; // padrão camelcase

        for (int i = 1; i <= 15; i++) {
            System.out.print("Digite o " + i + "º salário: "); // Atl + 0186
            salario = sc.nextDouble();
            acumulador += salario; // acumulador = acumulador + salario;
        }

        mediaSalarial = acumulador / 15;
        System.out.printf("A média dos salários dos funcionários é de: %.2f", mediaSalarial);

        sc.close();
    }
}