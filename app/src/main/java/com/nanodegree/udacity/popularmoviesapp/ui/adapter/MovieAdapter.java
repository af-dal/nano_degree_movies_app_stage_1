package com.nanodegree.udacity.popularmoviesapp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.nanodegree.udacity.popularmoviesapp.rest.model.Movie;
import com.nanodegree.udacity.popularmoviesapp.ui.views.MovieView;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<Movie> movieList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(new MovieView(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(movieList.get(position));
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) {
        holder.reset();
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setMovieList(final List<Movie> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final MovieView movieView;

        ViewHolder(final MovieView itemView) {
            super(itemView);
            this.movieView = itemView;
        }

        void bind(final Movie movie) {
            movieView.bind(movie);
        }

        void reset() {
            movieView.resetViews();
        }
    }
}
