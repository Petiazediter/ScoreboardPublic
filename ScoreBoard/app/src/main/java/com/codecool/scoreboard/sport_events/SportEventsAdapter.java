package com.codecool.scoreboard.sport_events;

import android.content.Context;
import android.content.Intent;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.SportEvent;
import com.codecool.scoreboard.team_details.TeamDetailsActivity;
import com.codecool.scoreboard.sport_events.details.SportEventDetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SportEventsAdapter extends RecyclerView.Adapter<SportEventsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.datarow)
        ConstraintLayout datarow;

        @BindView(R.id.homeTeam)
        TextView homeView;
        @BindView(R.id.awayTeam)
        TextView awayView;
        @BindView(R.id.date)
        TextView dateView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(SportEvent sportEvent) {

            homeView.setText(sportEvent.getHomeTeam() + " VS");
            awayView.setText(sportEvent.getAwayTeam());
            dateView.setText(sportEvent.getDate());

            homeView.setOnClickListener(v -> {
                openTeamActivity(sportEvent.getIdHomeTeam());
            });

            awayView.setOnClickListener(v -> {
                openTeamActivity(sportEvent.getIdAwayTeam());
            });
        }

        private void openTeamActivity(int teamID)
        {
            Intent intent = new Intent(context, TeamDetailsActivity.class);
            intent.putExtra(TeamDetailsActivity.TEAM_NAME_KEY, teamID);
            context.startActivity(intent);
            Log.i("ID", Integer.toString(teamID));
        }


    }

    Context context;
    List<SportEvent> sportEventList;


    public SportEventsAdapter(Context context, List<SportEvent> sportEventList) {
        this.context = context;
        this.sportEventList = sportEventList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SportEvent sportEvent = sportEventList.get(position);
        holder.bind(sportEvent);

        holder.datarow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SportEventDetailsActivity.class);
                intent.putExtra("event", sportEvent);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return sportEventList.size();
    }
}
