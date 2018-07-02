package com.nanodegree.udacity.popularmoviesapp.rest.repo;

import android.support.annotation.Nullable;

public interface RepositoryCallback<T> {

    void onSuccess(@Nullable final T data);

    void onFailure(final Throwable throwable);
}
