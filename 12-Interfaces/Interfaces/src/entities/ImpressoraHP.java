package entities;

import interfaces.InterfaceJatoDeTinta;

import java.time.LocalDate;

public class ImpressoraHP extends Impressora implements InterfaceJatoDeTinta {

    public ImpressoraHP(Long id, String modelo, String tipoConexao, LocalDate dataFabricacao, Integer folhasDisponiveis) {
        super(id, modelo, tipoConexao, dataFabricacao, folhasDisponiveis);
    }

    @Override
    public void imprimirJatoDeTinta() {
        System.out.println("Impressora da HP com Jato de Tinta.");
    }
}
