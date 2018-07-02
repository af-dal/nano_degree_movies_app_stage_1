package com.nanodegree.udacity.popularmoviesapp.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.nanodegree.udacity.popularmoviesapp.rest.model.MoviesResponse;
import com.nanodegree.udacity.popularmoviesapp.rest.repo.MovieRepository;
import com.nanodegree.udacity.popularmoviesapp.rest.repo.RepositoryCallback;

import java.io.Serializable;

public class MainPresenter {

    @NonNull
    private final MovieRepository movieRepository;
    @NonNull
    private final IMainListener mainPresenterListener;

    public MainPresenter(@NonNull final IMainListener mainPresenterListener) {
        this.mainPresenterListener = mainPresenterListener;
        this.movieRepository = new MovieRepository();
    }

    public void loadMovies(@NonNull final MovieLoadType movieLoadType) {
        if (MovieLoadType.POPULAR == movieLoadType) {
            movieRepository.loadPopularMovies(new RepositoryCallback<MoviesResponse>() {
                @Override
                public void onSuccess(@Nullable final MoviesResponse data) {
                    if (data != null) {
                        mainPresenterListener.onMoviesLoaded(data.getMovieList());
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {
                    mainPresenterListener.onMoviesError(throwable);
                }
            });
        } else {
            movieRepository.loadTopRatedMovies(new RepositoryCallback<MoviesResponse>() {
                @Override
                public void onSuccess(@Nullable final MoviesResponse data) {
                    if (data != null) {
                        mainPresenterListener.onMoviesLoaded(data.getMovieList());
                    }
                }

                @Override
                public void onFailure(Throwable throwable) {
                    mainPresenterListener.onMoviesError(throwable);
                }
            });
        }
    }

    public enum MovieLoadType {
        TOP_RATED,
        POPULAR
    }
}
