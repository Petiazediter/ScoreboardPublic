package com.codecool.scoreboard.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamWrapper
{
    @SerializedName("teams")
    List<Team> theTeam;

    public List<Team> getDatas() {
        return theTeam;
    }
}
