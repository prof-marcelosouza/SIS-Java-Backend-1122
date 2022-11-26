package entities;

import interfaces.IJatoDeTinta;
import interfaces.ILaser;
import interfaces.IMatricial;

import java.time.LocalDate;

public class ImpressoraEpson extends Impressora implements IMatricial, ILaser, IJatoDeTinta {

    public ImpressoraEpson(Long id, String modelo, String tipoConexao, LocalDate dataFabricacao, Integer folhasDisponiveis) {
        super(id, modelo, tipoConexao, dataFabricacao, folhasDisponiveis);
    }

    @Override
    public void imprimirMatricial() {
        System.out.println("Impressora Epson com fita Matricial.");
    }

    @Override
    public void imprimirLaser() {
        System.out.println("Impressora Epson com impressão a Laser.");
    }

    @Override
    public void imprimirJatoDeTinta() {
        System.out.println("Impressora Epson com impressão de Jato de Tinta.");
    }
}
