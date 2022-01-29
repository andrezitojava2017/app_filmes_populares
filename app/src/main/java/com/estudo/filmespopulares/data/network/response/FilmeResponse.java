package com.estudo.filmespopulares.data.network.response;

import com.squareup.moshi.Json;

public class FilmeResponse {

    @Json(name = "original_title")
    private String titulo;
    @Json(name = "poster_path")
    private String caminhoPoster;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public void setCaminhoPoster(String caminhoPoster) {
        this.caminhoPoster = caminhoPoster;
    }
}
