package com.nanodegree.udacity.popularmoviesapp.util;

import com.nanodegree.udacity.popularmoviesapp.BuildConfig;

public class ImageUrlHelper {

    private ImageUrlHelper() {
    }

    public static String getPosterImageUrl(final String posterPath) {
        return BuildConfig.IMAGE_URL.concat(posterPath);
    }
}
