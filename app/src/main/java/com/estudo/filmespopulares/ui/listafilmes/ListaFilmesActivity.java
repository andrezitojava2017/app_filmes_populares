package com.estudo.filmespopulares.ui.listafilmes;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.estudo.filmespopulares.R;
import com.estudo.filmespopulares.data.mapper.FilmesMapper;
import com.estudo.filmespopulares.data.model.Filme;
import com.estudo.filmespopulares.data.network.ApiService;
import com.estudo.filmespopulares.data.network.response.FilmeResponse;
import com.estudo.filmespopulares.data.network.response.FilmesResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity
        implements ListaFilmesContrato.ListaFilmesView  {

    private RecyclerView recyclerFilmes;
    private ListaFilmesAdapter filmesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filme);

        configuraToolbar();

        configuraAdapter();

        ListaFilmesContrato.ListaFilmesPresenter presenter = new ListaFilmesPresenter(this);
        presenter.obtemFilmes();

    }

    private void configuraToolbar() {
        Toolbar tollbar = (Toolbar) findViewById(R.id.my_toolbar);
    }

    private void configuraAdapter() {
        filmesAdapter = new ListaFilmesAdapter();
        recyclerFilmes = findViewById(R.id.rvListaFilmes);
        RecyclerView.LayoutManager gridlayoutManager = new GridLayoutManager(this, 2);
        recyclerFilmes.setLayoutManager(gridlayoutManager);
        recyclerFilmes.setAdapter(filmesAdapter);
    }




    @Override
    public void mostraFilmes(List<Filme> listaFilmes) {
        filmesAdapter.setListaFilmes(listaFilmes);
    }

    @Override
    public void mostraErro(){
        Toast.makeText(this, "Erro ao consultar API", Toast.LENGTH_SHORT).show();
    }

}
