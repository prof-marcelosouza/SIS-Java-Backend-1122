import entities.ImpressoraEpson;
import entities.ImpressoraHP;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ImpressoraHP iHP = new ImpressoraHP(1L, "4003W Mono", "USB, WI-FI", LocalDate.of(2000, 11, 10), 500);
        System.out.println(iHP);
        iHP.imprimirJatoDeTinta();

        System.out.println("------------------------------------------------------------");

        ImpressoraEpson iEpson = new ImpressoraEpson(2L, "L4260", "USB", LocalDate.of(1995, 5, 23), 250);
        System.out.println(iEpson);
        iEpson.imprimirJatoDeTinta();
        iEpson.imprimirMatricial();
        iEpson.imprimirLaser();

    }

}