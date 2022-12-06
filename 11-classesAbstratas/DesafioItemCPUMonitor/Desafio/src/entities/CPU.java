package entities;

public class CPU extends Item {

    private String marca;
    private String fornecedor;
    private String processador;
    private String memoria;

    public CPU(Integer codigo, String descricao, Double valor, Integer quantidade, boolean disponibilidade, String marca, String fornecedor, String processador, String memoria) {
        super(codigo, descricao, valor, quantidade, disponibilidade);
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.processador = processador;
        this.memoria = memoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    @Override
    public Double calcularValorDesconto() { // 2 x 50.0
        Double desc = this.quantidade * this.valor * 0.85;
        return desc;
    }

    @Override
    public String toString() {
        return super.toString() +
                "CPU{" +
                "marca='" + marca + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", processador='" + processador + '\'' +
                ", memoria='" + memoria + '\'' +
                '}';
    }
}
