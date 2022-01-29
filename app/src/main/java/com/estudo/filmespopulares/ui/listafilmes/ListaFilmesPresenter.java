package com.estudo.filmespopulares.ui.listafilmes;

import com.estudo.filmespopulares.data.mapper.FilmesMapper;
import com.estudo.filmespopulares.data.model.Filme;
import com.estudo.filmespopulares.data.network.ApiService;
import com.estudo.filmespopulares.data.network.response.FilmesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesPresenter implements ListaFilmesContrato.ListaFilmesPresenter{

    private ListaFilmesContrato.ListaFilmesView  view;

    public ListaFilmesPresenter(ListaFilmesContrato.ListaFilmesView view){
        this.view = view;
    }


    @Override
    public void obtemFilmes() {
        ApiService.getInstanceService()
                .obterFilmesPopulares("89fe901b340d6c7a0169d5e930bacb38")
                .enqueue(new Callback<FilmesResult>() {
                    @Override
                    public void onResponse(Call<FilmesResult> call, Response<FilmesResult> response) {

                        if (response.isSuccessful()) {
                            final List<Filme> filmes = FilmesMapper.deResponseParaDominio(response.body().getListaFilmes());
                            view.mostraFilmes(filmes);
                        } else{
                            view.mostraErro();
                        }

                    }

                    @Override
                    public void onFailure(Call<FilmesResult> call, Throwable t) {
                        view.mostraErro();
                    }
                });
    }

    @Override
    public void setView(ListaFilmesContrato.ListaFilmesView view) {
        this.view = view;
    }
}
