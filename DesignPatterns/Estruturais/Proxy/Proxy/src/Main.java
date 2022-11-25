import entities.Pessoa;
import service.ServicoVacinarProxy;
import service.Vacinar;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate diaDaVacinaAnterior = LocalDate.now().minusDays(10);
        //System.out.println(diaDaVacinaAnterior);
        LocalDate diaVacina = LocalDate.now();

        Pessoa p1 = new Pessoa("Paola", "Marques", "2145875544", diaVacina, "Comirnaty (Pfizer/Wyeth)");

        Pessoa p2 = new Pessoa("Jonas", "Santos", "3225635545", diaDaVacinaAnterior, "Coronavac (Butantan)");

        Vacinar vacinar = new ServicoVacinarProxy();
        vacinar.vacinarPessoa(p1.getRg(), p1.getDataVacina(), p1.getNomeVacina());
        System.out.println(p1.toString());
        System.out.println("");

        Vacinar vacinar2 = new ServicoVacinarProxy();
        vacinar2.vacinarPessoa(p2.getRg(), p2.getDataVacina(), p2.getNomeVacina());
        System.out.println(p2.toString());
    }
}