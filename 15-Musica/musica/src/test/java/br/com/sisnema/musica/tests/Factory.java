package br.com.sisnema.musica.tests;

import br.com.sisnema.musica.dtos.CidadeDto;
import br.com.sisnema.musica.dtos.EstadoDto;
import br.com.sisnema.musica.dtos.GeneroDto;
import br.com.sisnema.musica.dtos.PaisDto;
import br.com.sisnema.musica.entities.Cidade;
import br.com.sisnema.musica.entities.Estado;
import br.com.sisnema.musica.entities.Genero;
import br.com.sisnema.musica.entities.Pais;

// Uma classe de apoio para os testes
public class Factory {

    public static Cidade criarCidade() {
        Cidade cidade = new Cidade(1L, "Curitiba");
        return cidade;
    }

    public static CidadeDto criarCidadeDto() {
        Cidade cidade = criarCidade();
        return new CidadeDto(cidade);
    }

    public static Estado criarEstado() {
        Estado estado = new Estado(1L, "Mato Grosso do Sul");
        return estado;
    }

    public static EstadoDto criarEstadoDto() {
        Estado estado = criarEstado();
        return new EstadoDto(estado);
    }

    public static Pais criarPais() {
        Pais pais = new Pais(1L, "Uruguai");
        return pais;
    }

    public static PaisDto criarPaisDto() {
        Pais pais = criarPais();
        return new PaisDto(pais);
    }

    public static Genero criarGenero() {
        Genero genero = new Genero(1L, "Axé");
        return genero;
    }

    public static GeneroDto criarGeneroDto() {
        Genero genero = criarGenero();
        return new GeneroDto(genero);
    }

}
