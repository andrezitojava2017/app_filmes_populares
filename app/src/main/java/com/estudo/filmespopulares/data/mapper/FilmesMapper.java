package com.estudo.filmespopulares.data.mapper;

import com.estudo.filmespopulares.data.model.Filme;
import com.estudo.filmespopulares.data.network.response.FilmeResponse;

import java.util.ArrayList;
import java.util.List;

public class FilmesMapper {

    public static List<Filme> deResponseParaDominio(List<FilmeResponse> listFilmeResponse){
        List<Filme> listaFilme = new ArrayList<>();

        for (FilmeResponse fr : listFilmeResponse) {
            final Filme filme = new Filme(fr.getTitulo(), fr.getCaminhoPoster());
            listaFilme.add(filme);
        }
        return listaFilme;
    }

}
