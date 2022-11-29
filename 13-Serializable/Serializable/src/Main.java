import entities.Cachorro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Serializable
//        List<Cachorro> cachorros = new ArrayList<>();
//
//        Cachorro c1 = new Cachorro("Pluto", "Fila", 5, "Av. Bento gonçalves, 254");
//        Cachorro c2 = new Cachorro("Tob", "Beagle", 3, "Rua das Hortências, 569");
//        Cachorro c3 = new Cachorro("Puk", "Beagle", 2, "Rua Farroupilha, 411");
//
//        cachorros.add(c1);
//        cachorros.add(c2);
//        cachorros.add(c3);

        // Salvar esta coleção de Cachorros em um arquivo: saida.txt
//        FileOutputStream fo = null;
//
//        try {
//            fo = new FileOutputStream("saida.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fo);
//            oos.writeObject(cachorros);
//            System.out.println("Serializando a lista de cachorros...");
//        }
//        catch (FileNotFoundException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//        catch (Exception e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }

        // Recuperar a coleção de Cachorros
        List<Cachorro> recuperaCachorros = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("saida.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            // Aqui precisamos utilizar um Casting
            recuperaCachorros = (ArrayList) ois.readObject();

        }
        catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for (Cachorro cach : recuperaCachorros) {
            System.out.println(
                    cach.getNome() + " | " +
                    cach.getRaca() + " | " +
                    cach.getIdade() + " | " +
                    cach.getEndereco()
            );
        }

    }

}