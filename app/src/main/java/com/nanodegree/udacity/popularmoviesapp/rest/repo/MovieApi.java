package com.nanodegree.udacity.popularmoviesapp.rest.repo;

import com.nanodegree.udacity.popularmoviesapp.BuildConfig;
import com.nanodegree.udacity.popularmoviesapp.rest.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("movie/popular?api_key=" + BuildConfig.API_KEY)
    Call<MoviesResponse> getPopularMovies();

    @GET("movie/top_rated?api_key=" + BuildConfig.API_KEY)
    Call<MoviesResponse> getTopRatedMovies();

}
