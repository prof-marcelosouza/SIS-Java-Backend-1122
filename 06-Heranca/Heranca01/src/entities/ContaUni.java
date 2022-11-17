package entities;

public class ContaUni extends ContaCorrente {

    private String matricula;

    public ContaUni(int id, int agencia, int numero, String titular, double saldo, double limite, String matricula) {
        super(id, agencia, numero, titular, saldo, limite);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ContaUni{" +
                "matricula='" + matricula + '\'' +
                '}';
    }
}
