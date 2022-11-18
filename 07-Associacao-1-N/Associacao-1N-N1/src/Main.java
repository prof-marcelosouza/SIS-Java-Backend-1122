import entities.Pessoa;
import entities.Pet;

public class Main {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa(1, "Pedro");
        Pessoa p2 = new Pessoa(2, "Paula");
        Pessoa p3 = new Pessoa(3, "Moises");

        Pet pet1 = new Pet(1, "Fila brasileiro", p1);
        Pet pet2 = new Pet(2, "Dogue alemão", p2);
        Pet pet3 = new Pet(3, "Golden retriever", p3);
        Pet pet4 = new Pet(4, "Beagle", p3);
        Pet pet5 = new Pet(5, "Basset hound", new Pessoa(4, "Marta"));

        System.out.println(pet1.toString());
        System.out.println(pet2.toString());
        System.out.println(pet3.toString());
        System.out.println(pet4.toString());
        System.out.println(pet5.toString());

    }

}