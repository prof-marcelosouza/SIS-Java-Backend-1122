import entities.Pessoa;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Airton Senna", "5241369987", "214.545.898-95", LocalDate.of(1975, Month.AUGUST, 5), "AB", "senna@gmail.com", "(51) 3366-6652", "(51) 99950-6633");

        System.out.println(p1);

        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNomeCompleto("Nigel Mansel");
        p2.setRg("2145789633");
        p2.setCpf("214.254.899-95");
        p2.setDataNascimento(LocalDate.of(1968, Month.NOVEMBER, 17));
        p2.setTipoSanguineo("B");
        p2.setEmail("mansel@gmail.com");
        p2.setFoneFixo("55 3225-5522");
        p2.setFoneCel("55 99885-2210");

        System.out.println("Impressão do P2:");
        System.out.println("Id: " + p2.getId());
        System.out.println("Nome completo: " + p2.getNomeCompleto());
        System.out.println("RG: " + p2.getRg());
        System.out.println("CPF: " + p2.getCpf());
        System.out.println("Data de nascimento: " + p2.getDataNascimento());
        System.out.println("Tipo sanguíneo: " + p2.getTipoSanguineo());
        System.out.println("E-mail: " + p2.getEmail());
        System.out.println("Fone fixo: " + p2.getFoneFixo());
        System.out.println("Fone celular: " + p2.getFoneCel());

    }
}