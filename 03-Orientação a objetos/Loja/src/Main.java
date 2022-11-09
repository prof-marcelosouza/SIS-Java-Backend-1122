import entities.Produto;

import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        Produto p1 = new Produto();
        p1.id = 1;
        p1.nome = "Motorola G8";
        p1.desc = "Celular de última geração";
        p1.valor = 980.00;
        p1.estoque = 25;
        p1.dataCadastro = Instant.now();

        System.out.println(p1);

        Produto p2 = new Produto();
        p2.id = 2;
        p2.nome = "Motorola G9";
        p2.desc = "Celular de última geração";
        p2.valor = 1190.00;
        p2.estoque = 40;
        p2.dataCadastro = Instant.now();
        System.out.println(p2);
    }
}