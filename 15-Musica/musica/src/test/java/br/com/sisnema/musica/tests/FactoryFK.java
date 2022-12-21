package br.com.sisnema.musica.tests;

import br.com.sisnema.musica.entities.Album;
import br.com.sisnema.musica.entities.Artista;
import br.com.sisnema.musica.entities.Festival;

import java.time.Instant;

import static br.com.sisnema.musica.tests.Factory.*;

public class FactoryFK {

    public static Artista criarArtista() {
        Artista artista = new Artista(1L, "Molotov", true, criarPais(), criarEstado(), criarCidade(), criarGenero());
        return artista;
    }

    // criarArtistaDto()

    public static Album criarAlbum() {
        Album album = new Album(1L, "S&M", 2000, criarArtista(), criarGenero());
        return album;
    }

    // criarAlbumDto()

    public static Festival criarFestival() {
        Festival festival = new Festival(1L, "Planeta Atlântida", Instant.now());
        return festival;
    }

    // criarFestivalDto()
}
