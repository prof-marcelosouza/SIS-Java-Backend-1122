package service;

import java.time.LocalDate;

public class ServicoVacinarProxy implements Vacinar {

    @Override
    public void vacinarPessoa(String rg, LocalDate dataVacina, String tipoVacina) {

        if (LocalDate.now().equals(dataVacina)) {
            ServicoVacinar servicoVacinar = new ServicoVacinar();
            servicoVacinar.vacinarPessoa(rg, dataVacina, tipoVacina);
            System.out.println("Cidadão(ã) liberado(a) para a vacinação.");
        } else {
            System.out.println("A data de hoje é anterior a data marcada.");
        }

    }

}
