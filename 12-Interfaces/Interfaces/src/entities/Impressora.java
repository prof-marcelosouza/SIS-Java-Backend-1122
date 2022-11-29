package entities;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Impressora {

    private Long id;
    private String modelo;
    private String tipoConexao;
    private LocalDate dataFabricacao;
    private Integer folhaDisponivel;

    public Impressora() {
    }

    public Impressora(Long id, String modelo, String tipoConexao, LocalDate dataFabricacao, Integer folhaDisponivel) {
        this.id = id;
        this.modelo = modelo;
        this.tipoConexao = tipoConexao;
        this.dataFabricacao = dataFabricacao;
        this.folhaDisponivel = folhaDisponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Integer getFolhaDisponivel() {
        return folhaDisponivel;
    }

    public void setFolhaDisponivel(Integer folhaDisponivel) {
        this.folhaDisponivel = folhaDisponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Impressora that = (Impressora) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Impressora{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", tipoConexao='" + tipoConexao + '\'' +
                ", dataFabricacao=" + dataFabricacao +
                ", folhaDisponivel=" + folhaDisponivel +
                '}';
    }
}
