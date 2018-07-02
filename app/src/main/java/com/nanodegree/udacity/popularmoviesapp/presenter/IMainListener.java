package com.nanodegree.udacity.popularmoviesapp.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.nanodegree.udacity.popularmoviesapp.rest.model.Movie;

import java.util.List;

public interface IMainListener {
    void onMoviesLoaded(@Nullable final List<Movie> movieList);

    void onMoviesError(@NonNull final Throwable throwable);
}
