package com.codecool.scoreboard.sport_events;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.SportEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LastEventsActivity extends AppCompatActivity implements SportEventsContract {

    @BindView(R.id.recyclerView)
    RecyclerView sportEventsView;

    SportEventsPresenter presenter;
    SportEventAdapter adapter;

    List<SportEvent> lastSportEvents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_events);
        ButterKnife.bind(this);

        presenter = new SportEventsPresenter(this);
        presenter.onAttach(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.requestLastEvents(this);
    }

    private void setAdapter() {
        adapter = new SportEventAdapter(this, lastSportEvents);
        sportEventsView.setLayoutManager(new LinearLayoutManager(this));
        sportEventsView.setAdapter(adapter);
    }

    @Override
    public void dataSuccessfullyLoaded(List<SportEvent> sportEvents) {
        setAdapter();
    }


}