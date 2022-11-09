package entities;

import java.util.Date;

public class Pessoa {

    public Integer id;
    public String nomeCompleto;
    public String rg;
    public String cpf;
    public String dataNascimento;
    public String tipoSanguineo;
    public String email;
    public String foneFixo;
    public String foneCel;

    public Pessoa() {
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                ", email='" + email + '\'' +
                ", foneFixo='" + foneFixo + '\'' +
                ", foneCel='" + foneCel + '\'' +
                '}';
    }
}
/*
 * Uma classe Pessoa com os atributos id, nome completo, rg, cpf,
 * data de nascimento, tipo sanguíneo, e-mail, telefone fixo,
 * telefone celular;*/