import entities.Veiculo;

import javax.sound.midi.SysexMessage;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {

        Veiculo v1 = new Veiculo(1, "Renault", "Sandero 1.0 Flex", LocalDate.of(2010, Month.AUGUST, 25), "KOG-5524", "Porto Alegre", "RS", "97919FAMSDE060016", "01265771521");

        System.out.println(v1);

        Veiculo v2 = new Veiculo();
        v2.setId(2);
        v2.setMarca("Renault");
        v2.setModelo("Logan 1.6");
        v2.setAnoFabricacao(LocalDate.of(2020, Month.SEPTEMBER, 14));
        v2.setPlaca("WED-5523");
        v2.setCidade("Santa Maria");
        v2.setEstado("RS");
        v2.setChassi("97919FAMSDE060016");
        v2.setRenavam("01269871521");

        System.out.println("Dados do segundo veículo: ");
        System.out.println("ID: " + v2.getId());
        System.out.println("Marca: " + v2.getMarca());
        System.out.println("Modelo: " + v2.getModelo());
        System.out.println("Ano de fabricação: " + v2.getAnoFabricacao());
        System.out.println("Placa: " + v2.getPlaca());
        System.out.println("Cidade: " + v2.getCidade());
        System.out.println("Estado: " + v2.getEstado());
        System.out.println("Chassi: " + v2.getChassi());
        System.out.println("Renavam: " + v2.getRenavam());

        Veiculo v3 = null;
        System.out.println(v3.getId());

    }
}