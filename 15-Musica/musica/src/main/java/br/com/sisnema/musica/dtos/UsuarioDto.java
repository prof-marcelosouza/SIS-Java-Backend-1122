package br.com.sisnema.musica.dtos;

import br.com.sisnema.musica.entities.Usuario;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;

    Set<FuncaoDto> funcoes = new HashSet<>();

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String nome, String sobrenome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDto(Usuario entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.sobrenome = entidade.getSobrenome();
        this.email = entidade.getEmail();
        this.senha = entidade.getSenha();
        entidade.getFuncoes().forEach(x -> this.funcoes.add(new FuncaoDto(x)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<FuncaoDto> getFuncoes() {
        return funcoes;
    }
}
