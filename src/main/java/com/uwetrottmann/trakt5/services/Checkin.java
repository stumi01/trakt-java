package com.uwetrottmann.trakt5.services;

import com.uwetrottmann.trakt5.entities.EpisodeCheckin;
import com.uwetrottmann.trakt5.entities.EpisodeCheckinResponse;
import com.uwetrottmann.trakt5.entities.MovieCheckin;
import com.uwetrottmann.trakt5.entities.MovieCheckinResponse;

import io.reactivex.Completable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;

public interface Checkin {

    /**
     * <b>OAuth Required</b>
     * <p>
     * <p> Check into an episode. This should be tied to a user action to manually indicate they are watching something.
     * The item will display as watching on the site, then automatically switch to watched status once the duration has
     * elapsed.
     */
    @POST("checkin")
    Observable<EpisodeCheckinResponse> checkin(
            @Body EpisodeCheckin episodeCheckin
    );

    /**
     * <b>OAuth Required</b>
     * <p>
     * <p> Check into a movie. This should be tied to a user action to manually indicate they are watching something.
     * The item will display as watching on the site, then automatically switch to watched status once the duration has
     * elapsed.
     */
    @POST("checkin")
    Observable<MovieCheckinResponse> checkin(
            @Body MovieCheckin movieCheckin
    );

    /**
     * <b>OAuth Required</b>
     * <p>
     * <p> Removes any active checkins, no need to provide a specific item.
     */
    @DELETE("checkin")
    Completable deleteActiveCheckin();

}
