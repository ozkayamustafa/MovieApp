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
import com.mustafa.movieapp.years2021model.Search;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YearsAdapter extends RecyclerView.Adapter<YearsAdapter.YearsHolder> {
    List<Search> searches;
    Context context;

    public YearsAdapter(List<Search> searches, Context context) {
        this.searches = searches;
        this.context = context;
    }

    @NonNull
    @Override
    public YearsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.years_movie_row,parent,false);
        return new YearsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YearsHolder holder, int position) {

        holder.movieTitle.setText(searches.get(position).getTitle());
        Picasso.get().load(searches.get(position).getPoster()).into(holder.imagePoster);
    }

    @Override
    public int getItemCount() {
        return searches.size();
    }

    public class YearsHolder extends RecyclerView.ViewHolder{
         ImageView imagePoster;
         TextView movieTitle;
        public YearsHolder(@NonNull View itemView) {
            super(itemView);
            imagePoster = itemView.findViewById(R.id.yearImagePoster);
            movieTitle = itemView.findViewById(R.id.yearMovieName);
        }
    }
}
