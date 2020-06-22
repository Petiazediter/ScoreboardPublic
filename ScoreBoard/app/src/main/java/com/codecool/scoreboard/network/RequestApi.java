package com.codecool.scoreboard.network;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestApi {

    // league id: 4801 - has next events !!!!!!!!!

    // all sports: https://www.thesportsdb.com/api/v1/json/1/all_sports.php
    // all leagues: https://www.thesportsdb.com/api/v1/json/1/all_leagues.php

    // team details by ID: https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=133604
    // league details by ID: https://www.thesportsdb.com/api/v1/json/1/lookupleague.php?id=4346

    /*
    Next 5 Events by Team Id
    https://www.thesportsdb.com/api/v1/json/1/eventsnext.php?id=133602

    Next 15 Events by League Id
    https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328

    Last 5 Events by Team Id
    https://www.thesportsdb.com/api/v1/json/1/eventslast.php?id=133602

    Last 15 Events by League Id
    https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328

     */

    // get last 15 events by League ID
    @GET("eventspastleague.php?id={id}")
    Flowable<Event> getLast15Evens(@Path("id") int leagueId);

    // get next 15 events by league ID
    @GET("eventsnextleague.php?id={id}")
    Flowable<Event> getNext15Events(@Path("id") int leagueId);


}
