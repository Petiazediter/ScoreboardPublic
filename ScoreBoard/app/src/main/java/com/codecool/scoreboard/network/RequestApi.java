package com.codecool.scoreboard.network;

import com.codecool.scoreboard.model.SportEventWrapper;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface RequestApi {

    // league id: 4801 - has next events !!!!!!!!!

    // all sports: https://www.thesportsdb.com/api/v1/json/1/all_sports.php
    // all leagues: https://www.thesportsdb.com/api/v1/json/1/all_leagues.php

    // team details by ID: https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=133604
    // league details by ID: https://www.thesportsdb.com/api/v1/json/1/lookupleague.php?id=4346
    // event details by ID: https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=441613

    /*
    Next 5 Events by Team Id
    https://www.thesportsdb.com/api/v1/json/1/eventsnext.php?id=133602

    Next 15 Events by League Id
    https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4801

    Last 5 Events by Team Id
    https://www.thesportsdb.com/api/v1/json/1/eventslast.php?id=133602

    Last 15 Events by League Id
    https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4801

     */

    // get last 15 events by League ID
    @GET("eventspastleague.php?id=4801")
    Flowable<SportEventWrapper> getLast15EventsWrapper();

    // get next 15 events by league ID
    @GET("eventsnextleague.php?id=4801")
    Flowable<SportEventWrapper> getNext15EventsWrapper();





}
