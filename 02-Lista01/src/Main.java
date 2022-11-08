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

//        double salario, mediaSalarial, acumulador = 0.0; // padrão camelcase
//
//        for (int i = 1; i <= 15; i++) {
//            System.out.print("Digite o " + i + "º salário: "); // Atl + 0186
//            salario = sc.nextDouble();
//            acumulador += salario; // acumulador = acumulador + salario;
//        }
//
//        mediaSalarial = acumulador / 15;
//        System.out.printf("A média dos salários dos funcionários é de: %.2f", mediaSalarial);

        /* 1.5.1
        Construa um algoritmo que contenha um array com todas as alíquotas do
        Imposto de Renda de Pessoa Física, são elas {0.0, 7.5, 15.0, 22.5, 27.5}.
        Logo após os imprima no console.
        */

//        double[] aliquotas = {0.0, 7.5, 15.0, 22.5, 27.5}; // 0 1 2 3 4
//
//        for (double aliq : aliquotas) {
//            System.out.println(aliq + "%");
//        }

        /* 1.6.1
        Construa um algoritmo que receba um salário bruto de um funcionário e envie
        para uma função que calcule em qual alíquota de Imposto de Renda de Pessoa Física
        o mesmo estará enquadrado com base nos dados abaixo:

        até R$ 1.903,98 – Isento
        de R$ 1.903,99 a R$ 2.826,65 – 7,5%
        de R$ 2.826,66 a R$ 3.751,05 – 15.0%
        de R$ 3.751,06 a R$ 4.664,68 – 22,5%
        acima de R$ 4.664,68 – 27,5%
        */

//        double salario; // Escopo global
//
//        System.out.print("Digite o salário bruto do funcionário: ");
//        salario = sc.nextDouble(); // 3000.0

        // Função ou método
//        calculaImposto(salario);
        // O parâmetro salario é enviado para a função

        /* 1.7.1
        Construa um algoritmo que possua um array de 5 (cinco posições). Logo após
        adicione as seguintes marcas: {“Ford”, “Chevrolet”, “Volkswagen”, “Fiat”, “Renault”}.

        Depois busque dentro do vetor todas as palavras (pelas suas posições) e conte
        quantas letras tem cada uma delas. Ao final imprima na tela qual delas possui a
        maior quantidade de letras e quantas elas são.
        */

        String[] marcas = new String[5];
        marcas[0] = "Ford";
        marcas[1] = "Chevrolet";
        marcas[2] = "Volkswagen";
        marcas[3] = "Fiat";
        marcas[4] = "Renault";

        int maior = 0, indice = 0;

        for (int i = 0; i <= 4; i++) {
            int qtdeLetras = marcas[i].length(); // 4 9 10 4 7
            //System.out.println(qtdeLetras);
            if (qtdeLetras > maior) {
                maior = qtdeLetras; // 10
                indice = i; // 2
            }
        }

        System.out.println("A marca com a maior quantidade de letras é a "
                            + marcas[indice] + ".");
        System.out.println("Ela possui " + maior + " letras.");

        sc.close();
    }

    public static void calculaImposto(double sal) { // Escopo local
        if (sal <= 1903.98) {
            System.out.println("O contribuinte está isento de IR.");
            System.out.println("Será descontado 6% de vale-transporte deste trabalhador.");
        } else if (sal <= 2826.65) {
            System.out.println("Aplicar a alíquota de 7.5%.");
        } else if (sal <= 3751.05) {
            System.out.println("Aplicar a alíquota de 15.0%.");
        } else if (sal <= 4664.68) {
            System.out.println("Aplicar a alíquota de 22.5%.");
        } else {
            System.out.println("Aplicar a alíquota de 27.5%.");
        }
    }

}