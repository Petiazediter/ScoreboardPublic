package com.codecool.scoreboard.model;

import com.google.gson.annotations.SerializedName;

public class Team
{
    @SerializedName("strTeam")
    private String teamName;

    @SerializedName("idTeam")
    private int id;

    @SerializedName("strLeague")
    private String leaugeName;

    @SerializedName("strDescriptionEN")
    private String description;

    public String getTeamName() {
        return teamName;
    }

    public int getId() {
        return id;
    }

    public String getLeaugeName() {
        return leaugeName;
    }

    public String getDescription() {
        return description;
    }
}
