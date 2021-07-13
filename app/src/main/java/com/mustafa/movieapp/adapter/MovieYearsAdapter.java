package com.mustafa.movieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafa.movieapp.R;

public class MovieYearsAdapter extends RecyclerView.Adapter<MovieYearsAdapter.MovieYear> {
     String[] movieYears;
     Context context;

     public MovieYearsAdapter(String[] movieYears , Context context){
         this.movieYears = movieYears;
         this.context = context;
     }

    @NonNull
    @Override
    public MovieYear onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.movie_years_row,parent,false);
        return new MovieYear(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieYear holder, int position) {
        holder.years.setText(movieYears[position]);
    }

    @Override
    public int getItemCount() {
        return movieYears.length;
    }

    public class MovieYear extends RecyclerView.ViewHolder{
          TextView years;
        public MovieYear(@NonNull View itemView) {
            super(itemView);
            years = itemView.findViewById(R.id.years);
        }
    }
}
