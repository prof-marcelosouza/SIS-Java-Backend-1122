import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        String[] names = new String[6];
//
//        names[0] = "Fernando";
//        names[1] = "Mario";
//        names[2] = "Carlos";
//        names[3] = "Simone";
//        names[4] = "Tatiana";
//        names[5] = "Pedro";
//
//        System.out.println(names[0]);
//        System.out.println(names[1]);
//        System.out.println(names[2]);
//        System.out.println(names[3]);
//        System.out.println(names[4]);
//        System.out.println(names[5]);
//        System.out.println(names[8]);

//        for (int i = 0; i < names.length; i++) {
//            System.out.println("Índice[" + i + "]: " + names[i]);
//        }

        // Exemplo com a interface List
        List ourList = new ArrayList<>();
        ourList.add("Felipe");
        ourList.add("Roberta");
        ourList.add("Jorge");
        ourList.add("Juliana");
        ourList.add("Ricardo");
        ourList.add("Jorge");
        ourList.add("Marta");
        ourList.add("Roberta");

        System.out.println("List size: " + ourList.size());

        System.out.println("Accessing the list with FOR:");
        for (int i = 0; i < ourList.size(); i++) {
            System.out.println(ourList.get(i));
        }

    }

}