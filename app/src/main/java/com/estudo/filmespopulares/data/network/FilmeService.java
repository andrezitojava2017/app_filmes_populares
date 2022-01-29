package com.estudo.filmespopulares.data.network;

import com.estudo.filmespopulares.data.network.response.FilmesResult;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeService {

    @GET("movie/popular")
    Call<FilmesResult>obterFilmesPopulares(@Query("api_key") String chaveApi);
}
