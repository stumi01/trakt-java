package com.uwetrottmann.trakt5.services;

import com.uwetrottmann.trakt5.entities.Movie;
import com.uwetrottmann.trakt5.entities.Show;
import com.uwetrottmann.trakt5.enums.Extended;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Recommendations {

    /**
     * <b>OAuth Required</b>
     * <p>
     * <p> Personalized movie recommendations for a user. Results returned with the top recommendation first.
     */
    @GET("recommendations/movies")
    Observable<List<Movie>> movies(
            @Query(value = "extended", encoded = true) Extended extended
    );

    /**
     * <b>OAuth Required</b>
     * <p>
     * <p> Dismiss a movie from getting recommended anymore.
     *
     * @param movieId trakt ID, trakt slug, or IMDB ID. Example: "tron-legacy-2010".
     */
    @DELETE("recommendations/movies/{id}")
    Completable dismissMovie(
            @Path("id") String movieId
    );

    /**
     * <b>OAuth Required</b>
     * <p>
     * <p> Personalized show recommendations for a user. Results returned with the top recommendation first.
     */
    @GET("recommendations/shows")
    Observable<List<Show>> shows(
            @Query(value = "extended", encoded = true) Extended extended
    );

    /**
     * <b>OAuth Required</b>
     * <p>
     * <p> Dismiss a show from getting recommended anymore.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: 922.
     */
    @DELETE("recommendations/shows/{id}")
    Completable dismissShow(
            @Path("id") String showId
    );

}
