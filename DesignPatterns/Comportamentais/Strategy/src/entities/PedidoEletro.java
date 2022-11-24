package entities;

public class PedidoEletro extends Pedido {

    private String descricao;

    public PedidoEletro() {
    }

    public PedidoEletro(Double valor, String descricao) {
        super(valor);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
