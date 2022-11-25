package entities;

public class Celetista extends Professor {

    private Double ppl = 0.08; // 8%

    public Celetista(Long id, String nome, String email) {
        super(id, nome, email);
    }

    @Override
    public Double calcularSalario(Double base, Double percDesc) {
        Double salario = (base + (base * ppl)) - (base * percDesc / 100);
        return salario;
    }


}
