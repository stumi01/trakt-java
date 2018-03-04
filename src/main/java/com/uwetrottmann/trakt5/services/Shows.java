package com.uwetrottmann.trakt5.services;

import com.uwetrottmann.trakt5.entities.BaseShow;
import com.uwetrottmann.trakt5.entities.Comment;
import com.uwetrottmann.trakt5.entities.Credits;
import com.uwetrottmann.trakt5.entities.Ratings;
import com.uwetrottmann.trakt5.entities.Show;
import com.uwetrottmann.trakt5.entities.Stats;
import com.uwetrottmann.trakt5.entities.Translation;
import com.uwetrottmann.trakt5.entities.TrendingShow;
import com.uwetrottmann.trakt5.enums.Extended;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface Shows {

    /**
     * Returns the most popular shows. Popularity is calculated using the rating percentage and the number of ratings.
     *
     * @param page Number of page of results to be returned. If {@code null} defaults to 1.
     * @param limit Number of results to return per page. If {@code null} defaults to 10.
     */
    @GET("shows/popular")
    Observable<List<Show>> popular(
            @Query("page") Integer page,
            @Query("limit") Integer limit,
            @Query(value = "extended", encoded = true) Extended extended
    );

    /**
     * Returns all shows being watched right now. Shows with the most users are returned first.
     *
     * @param page Number of page of results to be returned. If {@code null} defaults to 1.
     * @param limit Number of results to return per page. If {@code null} defaults to 10.
     */
    @GET("shows/trending")
    Observable<List<TrendingShow>> trending(
            @Query("page") Integer page,
            @Query("limit") Integer limit,
            @Query(value = "extended", encoded = true) Extended extended
    );

    /**
     * Returns a single shows's details.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}")
    Observable<Show> summary(
            @Path("id") String showId,
            @Query(value = "extended", encoded = true) Extended extended
    );

    /**
     * Returns all translations for a show, including language and translated values for title and overview.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/translations")
    Observable<List<Translation>> translations(
            @Path("id") String showId
    );

    /**
     * Returns a single translation for a show. If the translation does not exist, the returned list will be empty.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param language 2-letter language code (ISO 639-1).
     */
    @GET("shows/{id}/translations/{language}")
    Observable<List<Translation>> translation(
            @Path("id") String showId,
            @Path("language") String language
    );

    /**
     * Returns all top level comments for a show. Most recent comments returned first.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param page Number of page of results to be returned. If {@code null} defaults to 1.
     * @param limit Number of results to return per page. If {@code null} defaults to 10.
     */
    @GET("shows/{id}/comments")
    Observable<List<Comment>> comments(
            @Path("id") String showId,
            @Query("page") Integer page,
            @Query("limit") Integer limit,
            @Query(value = "extended", encoded = true) Extended extended
    );

    /**
     * <b>OAuth Required</b>
     *
     * <p>Returns collection progress for show including details on all seasons and episodes. The {@code next_episode}
     * will be the next episode the user should collect, if there are no upcoming episodes it will be set to {@code
     * null}.
     *
     * <p>By default, any hidden seasons will be removed from the response and stats. To include these and adjust the
     * completion stats, set the {@code hidden} flag to {@code true}.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param hidden Include any hidden seasons.
     * @param specials Include specials as season 0.
     */
    @GET("shows/{id}/progress/collection")
    Observable<BaseShow> collectedProgress(
            @Path("id") String showId,
            @Query("hidden") Boolean hidden,
            @Query("specials") Boolean specials,
            @Query(value = "extended", encoded = true) Extended extended
    );

    /**
     * <b>OAuth Required</b>
     *
     * Returns watched progress for show including details on all seasons and episodes. The {@code next_episode} will be
     * the next episode the user should watch, if there are no upcoming episodes it will be set to {@code null}.
     *
     * <p>By default, any hidden seasons will be removed from the response and stats. To include these and adjust the
     * completion stats, set the {@code hidden} flag to {@code true}.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     * @param hidden Include any hidden seasons.
     * @param specials Include specials as season 0.
     */
    @GET("shows/{id}/progress/watched")
    Observable<BaseShow> watchedProgress(
            @Path("id") String showId,
            @Query("hidden") Boolean hidden,
            @Query("specials") Boolean specials,
            @Query(value = "extended", encoded = true) Extended extended
    );

    /**
     * Returns all actors, directors, writers, and producers for a show.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/people")
    Observable<Credits> people(
            @Path("id") String showId
    );

    /**
     * Returns rating (between 0 and 10) and distribution for a show.
     *
     * @param showId trakt ID, trakt slug, or IMDB ID. Example: "game-of-thrones".
     */
    @GET("shows/{id}/ratings")
    Observable<Ratings> ratings(
            @Path("id") String showId
    );

    /**
     * Returns lots of show stats.
     */
    @GET("shows/{id}/stats")
    Observable<Stats> stats(
            @Path("id") String showId
    );

    /**
     * Returns related and similar shows.
     */
    @GET("shows/{id}/related")
    Observable<List<Show>> related(
            @Path("id") String showId,
            @Query("page") Integer page,
            @Query("limit") Integer limit,
            @Query(value = "extended", encoded = true) Extended extended
    );

}
