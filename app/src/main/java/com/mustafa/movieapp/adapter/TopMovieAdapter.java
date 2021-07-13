package com.mustafa.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.movieapp.R;
import com.mustafa.movieapp.model.Search;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TopMovieAdapter extends RecyclerView.Adapter<TopMovieAdapter.MovieHolder> {
       List<Search> searches;
       Context context;

    public TopMovieAdapter(List<Search> searches, Context context) {
        this.searches = searches;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.top_movie_row,parent,false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Picasso.get().load(searches.get(position).getPoster()).into(holder.topMoviePoster);
        holder.topMovieName.setText(searches.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return searches.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder{
         ImageView topMoviePoster;
         TextView topMovieName;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            topMovieName = itemView.findViewById(R.id.topMovieName);
            topMoviePoster = itemView.findViewById(R.id.topImagePoster);
        }
    }

}
