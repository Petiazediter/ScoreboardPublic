package com.codecool.scoreboard.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SportEventWrapper {

    @SerializedName("events")
    private List<SportEvent> events;

    public List<SportEvent> getEvents() {
        return events;
    }
}
