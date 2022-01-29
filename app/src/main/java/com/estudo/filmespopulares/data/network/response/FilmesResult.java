package com.estudo.filmespopulares.data.network.response;

import com.squareup.moshi.Json;

import java.util.List;

public class FilmesResult {


    @Json(name = "results")
    private List<FilmeResponse> resultadoFilmes;

    public FilmesResult(List<FilmeResponse> listaFilmes) {
        this.resultadoFilmes = listaFilmes;
    }


    public List<FilmeResponse> getListaFilmes() {
        return resultadoFilmes;
    }
}
