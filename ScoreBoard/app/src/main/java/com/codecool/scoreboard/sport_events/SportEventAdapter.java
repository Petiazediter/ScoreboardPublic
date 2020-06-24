package com.codecool.scoreboard.sport_events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.SportEvent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SportEventAdapter extends RecyclerView.Adapter<SportEventAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.homeTeam)
        TextView home;
        @BindView(R.id.awayTeam)
        TextView away;
        @BindView(R.id.date)
        TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(SportEvent sportEvent) {
            home.setText(sportEvent.getHomeTeam() + " VS");
            away.setText(sportEvent.getAwayTeam());
            date.setText(sportEvent.getDate());


        }
    }

    Context context;
    List<SportEvent> sportEventList;


    public SportEventAdapter(Context context, List<SportEvent> sportEventList) {
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
    }

    @Override
    public int getItemCount() {
        return sportEventList.size();
    }
}
