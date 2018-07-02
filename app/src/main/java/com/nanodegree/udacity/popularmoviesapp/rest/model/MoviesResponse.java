package com.nanodegree.udacity.popularmoviesapp.rest.model;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {
    @SerializedName("results")
    private List<Movie> movieList;

    @Nullable
    public List<Movie> getMovieList() {
        return movieList;
    }
}
