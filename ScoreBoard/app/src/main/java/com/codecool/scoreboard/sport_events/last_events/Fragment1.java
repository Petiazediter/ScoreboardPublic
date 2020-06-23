package com.codecool.scoreboard.sport_events.last_events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.SportEvent;
import com.codecool.scoreboard.sport_events.SportEventAdapter;
import com.codecool.scoreboard.sport_events.SportEventsContract;
import com.codecool.scoreboard.sport_events.last_events.SportLastEventsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment1 extends Fragment implements SportEventsContract {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    SportLastEventsPresenter presenter;
    SportEventAdapter adapter;

    List<SportEvent> lastSportEvents;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_last_events, container, false);

        ButterKnife.bind(this,view);

        presenter = new SportLastEventsPresenter(requireActivity());
        presenter.onAttach(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
     //   presenter.requestLastEvents(this);
    }

    @Override
    public void dataSuccessfullyLoaded(List<SportEvent> sportEvents) {

    }
}
