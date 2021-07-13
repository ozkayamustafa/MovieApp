package com.mustafa.movieapp.Api;

import com.mustafa.movieapp.model.Root;
import com.mustafa.movieapp.years2021model.Years;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMovieApi {
    // https://omdbapi.com/?apikey=747aa89c&s=marvel

    @GET("?apikey=747aa89c&s=marvel")
    Observable<Root> getData();

    @GET("?i=tt1856101&apikey=747aa89c")
    Observable<com.mustafa.movieapp.bladeModel.Root> getBladePoster();


    @GET("?apikey=747aa89c&s=2021")
    Observable<Years> YEARS_OBSERVABLE();


}
