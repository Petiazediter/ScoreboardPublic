package com.codecool.scoreboard.team_details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.Team;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamDetailsActivity extends AppCompatActivity implements TeamDetailsContractor{

    public static String TEAM_NAME_KEY = "team_name";

    private TeamDetailsPresenter presenter;

    @BindView(R.id.teamName)
    TextView teamName;

    @BindView(R.id.leauge)
    TextView leauge;

    @BindView(R.id.description)
    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);

        ButterKnife.bind(this);
        int teamID = getIntent().getIntExtra(TEAM_NAME_KEY, 0);
        presenter = new TeamDetailsPresenter(this);
        presenter.onAttach(this);

        presenter.getTeamDetailsById(teamID);
    }


    @Override
    public void returnDatas(Team team)
    {
        teamName.setText(team.getTeamName());
        leauge.setText(team.getLeaugeName());
        description.setText(team.getDescription());
    }
}