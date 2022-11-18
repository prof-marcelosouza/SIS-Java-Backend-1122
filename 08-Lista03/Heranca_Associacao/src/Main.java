import entities.*;

public class Main {

    public static void main(String[] args) {

        Endereco endereco1 = new Endereco(1, "Montenegro", "254", "Osório", "RS");

        Marketing mk1 = new Marketing(2, "Carlos", "Macedo", 213556984, endereco1, "Vendas");
        mk1.trabalhar();
        System.out.println("ID: " + mk1.getId());
        System.out.println("Nome: " + mk1.getNome());
        System.out.println("Sobrenome: " + mk1.getSobrenome());
        System.out.println("CPF: " + mk1.getCpf());
        System.out.println("Endereco: " + mk1.getEndereco());
        System.out.println("Área: " + mk1.getArea());

        Producao prod1 = new Producao(3, "Paula", "Simone", 213554874, endereco1, 5);
        prod1.trabalhar();
        System.out.println("ID: " + prod1.getId());
        System.out.println("Nome: " + prod1.getNome());
        System.out.println("Sobrenome: " + prod1.getSobrenome());
        System.out.println("CPF: " + prod1.getCpf());
        System.out.println("Endereco: " + prod1.getEndereco());
        System.out.println("Tempo de experiência: " + prod1.getTempoExperiencia());

        RecursosHumanos rh1 = new RecursosHumanos(4, "Antonia", "Martins", 255654123, endereco1, 12);
        rh1.trabalhar();
        System.out.println("ID: " + rh1.getId());
        System.out.println("Nome: " + rh1.getNome());
        System.out.println("Sobrenome: " + rh1.getSobrenome());
        System.out.println("CPF: " + rh1.getCpf());
        System.out.println("Endereco: " + rh1.getEndereco());
        System.out.println("Meta alcançada: " + rh1.getMetaAlcancada());

    }
}