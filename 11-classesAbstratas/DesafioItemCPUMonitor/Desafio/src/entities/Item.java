package entities;

public abstract class Item {

    protected Integer codigo;
    protected String descricao;
    protected Double valor;
    protected Integer quantidade;
    protected boolean disponibilidade;

    public Item() {
    }

    public Item(Integer codigo, String descricao, Double valor, Integer quantidade, boolean disponibilidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.disponibilidade = disponibilidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // Métodos customizados
    public abstract Double calcularValorDesconto();

    public boolean verificaDisponibilidade(Integer codigo) {
        boolean disp = false;
            if (codigo == this.codigo) {
                disp = this.disponibilidade;
            }
        return disp;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
