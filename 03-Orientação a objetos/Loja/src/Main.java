import entities.Produto;

import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        Produto p1 = new Produto(1, "Motorola G8", "Celular de última geração");

        System.out.println(p1);

        Produto p2 = new Produto(2, "Motorola G9", "Celular de última geração", 1190.00, 40, Instant.now());

        System.out.println(p2);

        Produto p3 = new Produto();
        p3.setId(3);
        p3.setNome("Moto G");
        p3.setDesc("Depreciado");
        p3.setValor(552.0);
        p3.setEstoque(10);
        p3.setDataCadastro(Instant.now());

        System.out.println("Impressão do P3:");
        System.out.println("Id: " + p3.getId());
        System.out.println("Nome: " + p3.getNome());
        System.out.println("Desc: " + p3.getDesc());
        System.out.println("Valor: " + p3.getValor());
        System.out.println("Estoque: " + p3.getEstoque());
        System.out.println("Data de cadastro: " + p3.getDataCadastro());

    }
}