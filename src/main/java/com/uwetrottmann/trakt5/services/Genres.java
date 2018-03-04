package com.uwetrottmann.trakt5.services;

import com.uwetrottmann.trakt5.entities.Genre;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Genres {

    /**
     * Get a list of all genres for shows, including names and slugs.
     */
    @GET("genres/movies")
    Observable<List<Genre>> movies();

    /**
     * Get a list of all genres for movies, including names and slugs.
     */
    @GET("genres/shows")
    Observable<List<Genre>> shows();

}
