package com.codecool.scoreboard.sport_events.next_events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.SportEvent;
import com.codecool.scoreboard.sport_events.SportEventAdapter;
import com.codecool.scoreboard.sport_events.SportEventsContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NextEventsActivity extends Fragment implements SportEventsContract {

    @BindView(R.id.recyclerView)
    RecyclerView sportEventsView;

    SportNextEventsPresenter presenter;
    SportEventAdapter adapter;

    List<SportEvent> lastSportEvents = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_last_events,container,false);
        ButterKnife.bind(this,view);

        presenter = new SportNextEventsPresenter(requireActivity());
        presenter.onAttach(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.requestNextEvents(this);
    }

    private void setAdapter() {
        adapter = new SportEventAdapter(requireContext(), lastSportEvents);
        sportEventsView.setLayoutManager(new LinearLayoutManager(requireContext()));
        sportEventsView.setAdapter(adapter);
    }

    @Override
    public void dataSuccessfullyLoaded(List<SportEvent> sportEvents) {
        setAdapter();
    }
}