package entities;

public class Carrinho {

    private Integer id;
    private String item;
    private Integer quantidade;
    private Double valor;
    private Boolean promo;

    public Carrinho() {
    }

    public Carrinho(Integer id, String item, Integer quantidade, Double valor, Boolean promo) {
        this.id = id;
        this.item = item;
        this.quantidade = quantidade;
        this.valor = valor;
        this.promo = promo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    // Métodos customizados
    public Double calcularTotalItem() {
        double totalItem = getQuantidade() * getValor();
        return totalItem;
    }

    public Double alterarValorItem(Double novoValor) {
        setValor(novoValor);
        return getValor();
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", promo=" + promo +
                '}';
    }
}
