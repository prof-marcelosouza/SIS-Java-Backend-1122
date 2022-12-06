package entities;

public class Monitor extends Item {

    private String tipoTela;
    private String tamanho;
    private String peso;

    public Monitor(Integer codigo, String descricao, Double valor, Integer quantidade, boolean disponibilidade, String tipoTela, String tamanho, String peso) {
        super(codigo, descricao, valor, quantidade, disponibilidade);
        this.tipoTela = tipoTela;
        this.tamanho = tamanho;
        this.peso = peso;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    @Override
    public Double calcularValorDesconto() { // 2 x 50.0
        Double desc = this.quantidade * this.valor * 0.9;
        return desc;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Monitor{" +
                "tipoTela='" + tipoTela + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", peso='" + peso + '\'' +
                '}';
    }
}
