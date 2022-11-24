package entities.fretes;

import entities.Frete;

// Na herança se utiliza a palavra-chave EXTENDS
// Na interface se utiliza a palavra-chave IMPLEMENTS
public class FreteComum implements Frete {

    @Override
    public double calcular(double valor) {
        return valor * 0.05; // 5%
    }

}
