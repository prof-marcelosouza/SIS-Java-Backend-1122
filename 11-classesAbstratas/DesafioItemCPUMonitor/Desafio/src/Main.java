import entities.CPU;
import entities.Monitor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Integer op = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("1 - Criar CPU:");
        System.out.print("Digite o código: ");
        int cod = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite a descrição: ");
        String desc = sc.nextLine();
        System.out.print("Digite o valor: ");
        double val = sc.nextDouble();
        System.out.print("Digite a quantidade: ");
        int quant = sc.nextInt();
        System.out.print("Digite a disponibilidade (true or false): ");
        boolean disp = sc.nextBoolean();
        System.out.print("Digite a marca: ");
        String marca = sc.nextLine();
        sc.nextLine();
        System.out.print("Digite o fornecedor: ");
        String fornecedor = sc.nextLine();
        System.out.print("Digite o processador: ");
        String processador = sc.nextLine();
        System.out.print("Digite a memória: ");
        String memoria = sc.nextLine();

        CPU cpu1 = new CPU(cod, desc, val, quant, disp, marca, fornecedor, processador, memoria);

        System.out.println("2 - Consultar CPU:");
        System.out.println(cpu1.toString());

        System.out.println("3 - Ver Disponibilidade de CPU:");
        System.out.println("Produto disponível: " + cpu1.isDisponibilidade());

        System.out.println("4 - Mostrar valor da CPU com desconto:");
        System.out.println("Valor com desconto: " + cpu1.calcularValorDesconto());

//        System.out.println("5 - Criar Monitor:");
//
//        System.out.println("6 - Consultar Monitor:");
//
//        System.out.println("7 - Ver Disponibilidade de Monitor:");
//        System.out.println("8 - Mostrar valor do Monitor com desconto:");

        sc.close();
        }

}