package com.uwetrottmann.trakt5.services;

import com.uwetrottmann.trakt5.entities.SearchResult;
import com.uwetrottmann.trakt5.enums.Extended;
import com.uwetrottmann.trakt5.enums.IdType;
import com.uwetrottmann.trakt5.enums.Type;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface Search {

    /**
     * Search all text fields that a media object contains (i.e. title, overview, etc). Results are ordered by the most relevant score.
     *
     * @see <a href="http://docs.trakt.apiary.io/#reference/search/text-query/get-text-query-results">Search - Text Query</a>
     * @see <a href="http://docs.trakt.apiary.io/#introduction/filters">Filters</a>
     * @see <a href="http://docs.trakt.apiary.io/#introduction/extended-info">Extended</a>
     * @see <a href="http://docs.trakt.apiary.io/#introduction/pagination">Pagination</a>
     */
    @GET("search/{type}")
    Observable<List<SearchResult>> textQuery(
            @Path("type") Type type,
            @Query("query") String query,
            @Query("years") String years,
            @Query("genres") String genres,
            @Query("languages") String languages,
            @Query("countries") String countries,
            @Query("runtimes") String runtimes,
            @Query("ratings") String ratings,
            @Query("extended") Extended extended,
            @Query("page") Integer page,
            @Query("limit") Integer limit
    );

    /**
     * @see #textQuery textQuery
     */
    @GET("search/movie")
    Observable<List<SearchResult>> textQueryMovie(
            @Query("query") String query,
            @Query("years") String years,
            @Query("genres") String genres,
            @Query("languages") String languages,
            @Query("countries") String countries,
            @Query("runtimes") String runtimes,
            @Query("ratings") String ratings,
            @Query("certifications") String certifications,
            @Query("extended") Extended extended,
            @Query("page") Integer page,
            @Query("limit") Integer limit
    );

    /**
     * @see #textQuery textQuery
     */
    @GET("search/show")
    Observable<List<SearchResult>> textQueryShow(
            @Query("query") String query,
            @Query("years") String years,
            @Query("genres") String genres,
            @Query("languages") String languages,
            @Query("countries") String countries,
            @Query("runtimes") String runtimes,
            @Query("ratings") String ratings,
            @Query("certifications") String certifications,
            @Query("networks") String networks,
            @Query("status") String status,
            @Query("extended") Extended extended,
            @Query("page") Integer page,
            @Query("limit") Integer limit
    );

    /**
     * Lookup items by their Trakt, IMDB, TMDB, TVDB, or TVRage ID.
     *
     * @see <a href="http://docs.trakt.apiary.io/#reference/search/id-lookup/get-id-lookup-results">Search - ID Lookup</a>
     * @see <a href="http://docs.trakt.apiary.io/#introduction/extended-info">Extended</a>
     * @see <a href="http://docs.trakt.apiary.io/#introduction/pagination">Pagination</a>
     */
    @GET("search/{id_type}/{id}")
    Observable<List<SearchResult>> idLookup(
            @Path(value = "id_type", encoded = true) IdType idType,
            @Path(value = "id", encoded = true) String id,
            @Query("type") Type type,
            @Query("extended") Extended extended,
            @Query("page") Integer page,
            @Query("limit") Integer limit
    );

}
