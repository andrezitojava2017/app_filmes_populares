package com.estudo.filmespopulares.ui.listafilmes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estudo.filmespopulares.R;
import com.estudo.filmespopulares.data.model.Filme;
import com.estudo.filmespopulares.data.network.response.FilmeResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<Filme> listaFilmes;

    public ListaFilmesAdapter(){
        listaFilmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);
        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bind(listaFilmes.get(position));
        holder.textTituloFilme.setText(listaFilmes.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class ListaFilmesViewHolder extends RecyclerView.ViewHolder{

        private TextView textTituloFilme;
        private ImageView imagePoster;

        public ListaFilmesViewHolder(@NonNull View itemView) {
            super(itemView);
            textTituloFilme = itemView.findViewById(R.id.textTituloFilme);
            imagePoster = itemView.findViewById(R.id.imagePosterFilme);

        }

        public void bind(Filme filme){
            textTituloFilme.setText(filme.getNome());
            Picasso.get()
                    .load("https://image.tmdb.org/t/p/w342/" + filme.getCaminhoPoster())
                    .into(imagePoster);
        }
    }

    public void setListaFilmes(List<Filme>filmes){
        this.listaFilmes = filmes;
        notifyDataSetChanged();
    }

}
