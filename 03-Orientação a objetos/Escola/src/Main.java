import entities.Pessoa;

public class Main {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa();
        p1.id = 1;
        p1.nomeCompleto = "Airton Senna";
        p1.rg = "5241369987";
        p1.cpf = "214.545.898-95";
        p1.dataNascimento = "06/05/1968";
        p1.tipoSanguineo = "AB";
        p1.email = "senna@gmail.com";
        p1.foneFixo = "(51) 3366-6652";
        p1.foneCel = "(51) 99950-6633";
        System.out.println(p1);
    }
}