import entities.Banco;

public class Main {

    public static void main(String[] args) throws Exception {

        Banco banco = new Banco();
        banco.gerarBoleto(10, 1000.0);
        banco.gerarBoleto(30, 1000.0);
        banco.gerarBoleto(60, 1000.0);
        banco.gerarBoleto(65, 1000.0);

    }

}