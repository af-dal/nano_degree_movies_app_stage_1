package com.nanodegree.udacity.popularmoviesapp.ui.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nanodegree.udacity.popularmoviesapp.DetailsActivity;
import com.nanodegree.udacity.popularmoviesapp.R;
import com.nanodegree.udacity.popularmoviesapp.rest.model.Movie;
import com.nanodegree.udacity.popularmoviesapp.util.ImageUrlHelper;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieView extends RelativeLayout {

    @BindView(R.id.movie_image_view)
    ImageView movieImageView;

    @BindView(R.id.movie_title_view)
    TextView movieTitleTextView;

    public MovieView(Context context) {
        this(context, null);
    }

    public MovieView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.movie_view, this);
        ButterKnife.bind(this);
    }

    public void resetViews() {
        movieImageView.setImageBitmap(null);
        movieTitleTextView.setText(null);
        setOnClickListener(null);
    }

    public void bind(@NonNull final Movie movie) {
        Picasso.get().load(ImageUrlHelper.getPosterImageUrl(movie.getPosterPath())).into(movieImageView);
        movieTitleTextView.setText(movie.getTitle());

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getContext().startActivity(DetailsActivity.createIntent(getContext(), movie));
            }
        });
    }

}
