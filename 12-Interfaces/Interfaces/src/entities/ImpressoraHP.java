package entities;

import interfaces.IJatoDeTinta;

import java.time.LocalDate;

public class ImpressoraHP extends Impressora implements IJatoDeTinta {

    public ImpressoraHP(Long id, String modelo, String tipoConexao, LocalDate dataFabricacao, Integer folhasDisponiveis) {
        super(id, modelo, tipoConexao, dataFabricacao, folhasDisponiveis);
    }

    @Override
    public void imprimirJatoDeTinta() {
        System.out.println("Impressora da HP com Jato de Tinta.");
    }
}
