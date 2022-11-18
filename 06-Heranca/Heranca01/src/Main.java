import entities.ContaPF;
import entities.ContaPJ;
import entities.ContaUni;

public class Main {

    public static void main(String[] args) {

        ContaPF pf1 = new ContaPF(1, 2255, 25410, "João Batista", 0.0, 200.0, "123.255.412-99");
        pf1.depositar(1000.0);
        System.out.println("Conta PF");
        System.out.println("ID: " + pf1.getId());
        System.out.println("Ag.: " + pf1.getAgencia());
        System.out.println("Número: " + pf1.getNumero());
        System.out.println("Titular: " + pf1.getTitular());
        System.out.println("Saldo: " + pf1.getSaldo());
        System.out.println("Limite: " + pf1.getLimite());
        System.out.println("CPF: " + pf1.getCpf());

        ContaPJ pj1 = new ContaPJ(2, 4125, 25888, "Lojas Macedo", 0.0, 1000.0, "11.254.569/0001-58");
        pj1.depositar(2000.0);
        System.out.println("Conta PJ");
        System.out.println("ID: " + pj1.getId());
        System.out.println("Ag.: " + pj1.getAgencia());
        System.out.println("Número: " + pj1.getNumero());
        System.out.println("Titular: " + pj1.getTitular());
        System.out.println("Saldo: " + pj1.getSaldo());
        System.out.println("Limite: " + pj1.getLimite());
        System.out.println("CNPJ: " + pj1.getCnpj());

        ContaUni uni1 = new ContaUni(3, 4785, 69854, "Marília Santos", 0.0, 450.0, "14558");
        uni1.depositar(300.0);
        System.out.println("Conta Uni");
        System.out.println("ID: " + uni1.getId());
        System.out.println("Ag.: " + uni1.getAgencia());
        System.out.println("Número: " + uni1.getNumero());
        System.out.println("Titular: " + uni1.getTitular());
        System.out.println("Saldo: " + uni1.getSaldo());
        System.out.println("Limite: " + uni1.getLimite());
        System.out.println("Matrícula: " + uni1.getMatricula());

    }

}