public class Main {

    public static void main(String[] args) {

        // Estruturas condicionais
//        Short idade = 12;

        // IF Simples

//        if (idade > 17) { // False
//            System.out.println("Usuário apto para realizar os exames.");
//        }

        // IF Composto

//        if (idade >= 18) { // False
//            System.out.println("Usuário apto para realizar os exames.");
//        } else {
//            System.out.println("Usuário inapto para realizar o exame.");
//        }

        Double dependente = 189.59;
        Double salario = 0.0;

        // Leiam se o contribuinte tem dependentes e quantos eles são;
        // Calculem quanto o funcionário irá receber.

        if (salario > 0.0 && salario <= 1903.98) {
            System.out.println("Funcionário isento de IR em 2022.");
        } else if (salario >= 1903.99 && salario <= 2826.65) {
            System.out.println("Alíquota a pagar é de 7.5%.");
        } else if (salario >= 2826.66 && salario <= 3751.05) {
            System.out.println("Alíquota a pagar é de 15.0%.");
        } else if (salario >= 3751.06 && salario <= 4664.68) {
            System.out.println("Alíquota a pagar é de 22.5%.");
        } else {
            System.out.println("Alíquota a pagar é de 27.5%.");
        }

        // Deve-se mostrar o valor líquido que sobra do salário.

    }
}
/*
de 4.664,6           	27,50%	869,36
Valor de dependentes: 189,59

*/