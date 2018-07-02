package com.nanodegree.udacity.popularmoviesapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanodegree.udacity.popularmoviesapp.rest.model.Movie;
import com.nanodegree.udacity.popularmoviesapp.util.ImageUrlHelper;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {
    private static final String BUNDLE_MOVIE = "bundle.movie";

    @BindView(R.id.details_movie_poster_image)
    ImageView posterImage;
    @BindView(R.id.details_movie_description_text)
    TextView descriptionText;
    @BindView(R.id.details_movie_release_date_text)
    TextView releaseDateText;
    @BindView(R.id.details_movie_rating_text)
    TextView ratingText;
    @BindView(R.id.details_movie_title_text)
    TextView titleText;

    public static Intent createIntent(final Context context, final Movie movie) {
        final Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(BUNDLE_MOVIE, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final Movie movie = getIntent().getParcelableExtra(BUNDLE_MOVIE);
        if (movie != null) {
            updateViews(movie);
        }
    }

    private void updateViews(@NonNull final Movie movie) {
        Picasso.get().load(ImageUrlHelper.getPosterImageUrl(movie.getPosterPath())).into(posterImage);
        titleText.setText(movie.getTitle());
        descriptionText.setText(movie.getOverview());
        ratingText.setText(getString(R.string.details_vote_average, String.valueOf(movie.getVoteAverage())));
        releaseDateText.setText(movie.getReleaseDate());
    }

}
