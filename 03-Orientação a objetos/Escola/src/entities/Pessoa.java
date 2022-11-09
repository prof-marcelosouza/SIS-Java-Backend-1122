package entities;

public class Pessoa {

    private Integer id;
    private String nomeCompleto;
    private String rg;
    private String cpf;
    private String dataNascimento;
    private String tipoSanguineo;
    private String email;
    private String foneFixo;
    private String foneCel;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nomeCompleto, String rg, String cpf, String dataNascimento, String tipoSanguineo, String email, String foneFixo, String foneCel) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.tipoSanguineo = tipoSanguineo;
        this.email = email;
        this.foneFixo = foneFixo;
        this.foneCel = foneCel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneFixo() {
        return foneFixo;
    }

    public void setFoneFixo(String foneFixo) {
        this.foneFixo = foneFixo;
    }

    public String getFoneCel() {
        return foneCel;
    }

    public void setFoneCel(String foneCel) {
        this.foneCel = foneCel;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                ", email='" + email + '\'' +
                ", foneFixo='" + foneFixo + '\'' +
                ", foneCel='" + foneCel + '\'' +
                '}';
    }
}