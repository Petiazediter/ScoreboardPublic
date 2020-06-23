package com.codecool.scoreboard.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SportEvent implements Parcelable {

    @SerializedName("eventId")
    @Expose
    int id;

    @SerializedName("strEvent")
    String description;

    @SerializedName("dateEvent")
    @Expose
    String date;

    @SerializedName("strHomeTeam")
    @Expose
    String homeTeam;

    @SerializedName("strAwayTeam")
    @Expose
    String awayTeam;

    int idHomeTeam;

    int idAwayTeam;

    public SportEvent(int id, String description, String date, String homeTeam, String awayTeam, int idHomeTeam, int idAwayTeam) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.idHomeTeam = idHomeTeam;
        this.idAwayTeam = idAwayTeam;
    }

    public SportEvent() {
    }

    protected SportEvent(Parcel in) {
        id = in.readInt();
        description = in.readString();
        date = in.readString();
        homeTeam = in.readString();
        awayTeam = in.readString();
        idHomeTeam = in.readInt();
        idAwayTeam = in.readInt();
    }

    public static final Creator<SportEvent> CREATOR = new Creator<SportEvent>() {
        @Override
        public SportEvent createFromParcel(Parcel in) {
            return new SportEvent(in);
        }

        @Override
        public SportEvent[] newArray(int size) {
            return new SportEvent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(description);
        dest.writeString(date);
        dest.writeString(homeTeam);
        dest.writeString(awayTeam);
        dest.writeInt(idHomeTeam);
        dest.writeInt(idAwayTeam);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getIdHomeTeam() {
        return idHomeTeam;
    }

    public int getIdAwayTeam() {
        return idAwayTeam;
    }
}
