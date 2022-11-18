package entities;

public class Producao extends Funcionario {

    private int tempoExperiencia;

    public Producao() {
    }

    public Producao(int id, String nome, String sobrenome, int cpf, Endereco endereco, int tempoExperiencia) {
        super(id, nome, sobrenome, cpf, endereco);
        this.tempoExperiencia = tempoExperiencia;
    }

    public int getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(int tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public void trabalhar() {
        System.out.println("Funcionário da Produção trabalhando...");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Producao{" +
                "tempoExperiencia=" + tempoExperiencia +
                '}';
    }
}
