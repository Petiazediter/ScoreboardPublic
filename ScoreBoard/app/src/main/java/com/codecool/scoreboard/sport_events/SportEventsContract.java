package com.codecool.scoreboard.sport_events;

import com.codecool.scoreboard.model.SportEvent;

import java.util.List;

public interface SportEventsContract {

    void dataSuccessfullyLoaded(List<SportEvent> sportEvents);
}
