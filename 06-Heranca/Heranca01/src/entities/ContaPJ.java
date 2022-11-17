package entities;

public class ContaPJ extends ContaCorrente {

    private String cnpj;

    public ContaPJ(int id, int agencia, int numero, String titular, double saldo, double limite, String cnpj) {
        super(id, agencia, numero, titular, saldo, limite);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ContaPJ{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
