package com.codecool.scoreboard.sport_events.details;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.SportEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SportEventDetailsActivity extends AppCompatActivity {

    @BindView(R.id.description)
    TextView descriptionView;
    @BindView(R.id.date)
    TextView dateView;
    @BindView(R.id.homeTeam)
    TextView homeTeamView;
    @BindView(R.id.awayTeam)
    TextView awayTeamView;
    @BindView(R.id.id)
    TextView idView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_event);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        SportEvent sportEvent = intent.getParcelableExtra("event");

        descriptionView.setText(sportEvent.getDescription());
        dateView.setText(sportEvent.getDate());
        homeTeamView.setText(sportEvent.getHomeTeam());
        awayTeamView.setText(sportEvent.getAwayTeam());

    }


}