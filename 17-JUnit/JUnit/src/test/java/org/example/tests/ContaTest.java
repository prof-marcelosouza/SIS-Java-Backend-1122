package org.example.tests;

import org.example.entities.Conta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    @Test
    public void depositarDeveriaAumentarOSaldo() {
        // Preparar o teste
        double valorDeposito = 200.0;
        double valorEsperado = 196.0;

        // Execução do teste
        Conta c1 = new Conta(1L, 0.0);
        c1.depositar(valorDeposito);

        // Verificar o teste
        Assertions.assertEquals(valorEsperado, c1.getSaldo());

    }


}
