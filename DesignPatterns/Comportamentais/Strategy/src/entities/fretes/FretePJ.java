package entities.fretes;

import entities.Frete;

// Na herança se utiliza a palavra-chave EXTENDS
// Na interface se utiliza a palavra-chave IMPLEMENTS
public class FretePJ implements Frete {
    @Override
    public double calcular(double valor) {
        return valor * 0.02; // 2%
    }

}
