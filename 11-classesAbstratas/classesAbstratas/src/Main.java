import entities.Celetista;
import entities.PessoaJuridica;
import entities.Professor;

public class Main {

    public static void main(String[] args) {

        Professor celetista = new Celetista(1L, "Paula", "paula@gmail.com");
        Double salCeletista = celetista.calcularSalario(4000.0, 11.0);
        System.out.println("Salário do professor celetista R$ " + salCeletista);

        Professor pessoaJuridica = new PessoaJuridica(2L, "David", "david@gmail.com");
        Double salPJ = pessoaJuridica.calcularSalario(4000.0, 0.0);
        System.out.println("Salário do professor PJ R$ " + salPJ);

    }

}