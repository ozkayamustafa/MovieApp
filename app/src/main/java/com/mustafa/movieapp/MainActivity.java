package com.mustafa.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mustafa.movieapp.Api.ApiClient;
import com.mustafa.movieapp.Api.IMovieApi;
import com.mustafa.movieapp.adapter.MovieYearsAdapter;
import com.mustafa.movieapp.adapter.TopMovieAdapter;
import com.mustafa.movieapp.adapter.YearsAdapter;
import com.mustafa.movieapp.model.Root;
import com.mustafa.movieapp.model.Search;
import com.mustafa.movieapp.years2021model.Years;
import com.mustafa.movieapp.yearsFragment.Fragment2021;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    CompositeDisposable compositeDisposable;
   RecyclerView topMovie,movieYears,recyclerView;
   TopMovieAdapter adapter;
   YearsAdapter yearsAdapter;
      ImageView bladePoster;
      String[] years = {"2021","2020","2019","2018","2017","2016","2015","2014","2013","2012"};

      MovieYearsAdapter movieyearAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bladePoster = findViewById(R.id.blader249);
        topMovie = findViewById(R.id.top10Recycler);
        movieYears = findViewById(R.id.movieYears);
         recyclerView = findViewById(R.id.recyclerView);


        apiConnection();
        addmovieYears();


    }

    public void apiConnection(){
        IMovieApi movieApi = ApiClient.getInstance().create(IMovieApi.class);
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(movieApi.getData()
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::topMovie)
        );
        compositeDisposable.add(movieApi.getBladePoster()
                      .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::bladePoster)
        );

        compositeDisposable.add(movieApi.YEARS_OBSERVABLE()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handlerYear)
        );


    }

    public void topMovie(Root roots){
          List<Search> searches = roots.getSearch();
           adapter = new TopMovieAdapter(searches,MainActivity.this);
           topMovie.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
           topMovie.setNestedScrollingEnabled(true);
           topMovie.setAdapter(adapter);
           adapter.notifyDataSetChanged();

    }

    public void bladePoster(com.mustafa.movieapp.bladeModel.Root root){
           String url = root.getPoster();
            Picasso.get().load(url).into(bladePoster);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }


    public void addmovieYears(){
           RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
           movieYears.setLayoutManager(layoutManager);
           movieyearAdapter = new MovieYearsAdapter(years,this);
           movieYears.setAdapter(movieyearAdapter);

    }



    public void handlerYear(Years years){
        List<com.mustafa.movieapp.years2021model.Search> searches = years.getSearch();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        yearsAdapter = new YearsAdapter(searches,this);
        recyclerView.setAdapter(yearsAdapter);
        yearsAdapter.notifyDataSetChanged();
    }


}