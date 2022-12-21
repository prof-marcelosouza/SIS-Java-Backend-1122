package br.com.sisnema.musica.tests;

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

    // criarCidadeDto()

    public static Estado criarEstado() {
        Estado estado = new Estado(1L, "Mato Grosso do Sul");
        return estado;
    }

    // criarEstadoDto()

    public static Pais criarPais() {
        Pais pais = new Pais(1L, "Argentina");
        return pais;
    }

    // criarPaisDto()

    public static Genero criarGenero() {
        Genero genero = new Genero(1L, "Axé");
        return genero;
    }

    // criarGeneroDto()

}
