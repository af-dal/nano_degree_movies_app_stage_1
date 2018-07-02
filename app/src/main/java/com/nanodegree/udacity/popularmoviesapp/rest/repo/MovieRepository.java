package com.nanodegree.udacity.popularmoviesapp.rest.repo;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.nanodegree.udacity.popularmoviesapp.BuildConfig;
import com.nanodegree.udacity.popularmoviesapp.rest.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRepository {
    private final MovieApi movieApi;

    public MovieRepository() {
        final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .build();

        movieApi = retrofit.create(MovieApi.class);
    }

    public void loadPopularMovies(@NonNull final RepositoryCallback<MoviesResponse> responseCallback) {
        movieApi.getPopularMovies().enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) responseCallback.onSuccess(response.body());
                else responseCallback.onFailure(new Exception("Error loading popular movies"));
            }

            @Override
            public void onFailure(@NonNull Call<MoviesResponse> call, @NonNull Throwable t) {
                responseCallback.onFailure(t);
            }
        });
    }

    public void loadTopRatedMovies(@NonNull final RepositoryCallback<MoviesResponse> responseCallback) {
        movieApi.getTopRatedMovies().enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                if (response.isSuccessful()) responseCallback.onSuccess(response.body());
                else responseCallback.onFailure(new Exception("Error loading popular movies"));
            }

            @Override
            public void onFailure(@NonNull Call<MoviesResponse> call, @NonNull Throwable t) {
                responseCallback.onFailure(t);
            }
        });
    }
}
