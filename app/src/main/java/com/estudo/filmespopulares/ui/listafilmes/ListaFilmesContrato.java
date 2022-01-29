package com.estudo.filmespopulares.ui.listafilmes;

import com.estudo.filmespopulares.data.model.Filme;

import java.util.List;

public interface ListaFilmesContrato {

    interface ListaFilmesView{
        void mostraFilmes(List<Filme> listaFilmes);
        void mostraErro();
    }

    interface ListaFilmesPresenter{
        void obtemFilmes();
        void setView(ListaFilmesView view);
    }

}
