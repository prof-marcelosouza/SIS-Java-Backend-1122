package entities;

public class PessoaJuridica extends Professor {

    private Double premio = 0.1; // 10%

    public PessoaJuridica(Long id, String nome, String email) {
        super(id, nome, email);
    }

    @Override
    public Double calcularSalario(Double base, Double percDesc) {
        Double salario = (base + (base * premio));
        return salario;
    }


}
