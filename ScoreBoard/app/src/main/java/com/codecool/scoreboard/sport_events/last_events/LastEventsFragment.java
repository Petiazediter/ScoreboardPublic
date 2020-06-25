package com.codecool.scoreboard.sport_events.last_events;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.model.SportEvent;
import com.codecool.scoreboard.sport_events.SportEventsAdapter;
import com.codecool.scoreboard.sport_events.SportEventsContract;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.lang.Thread.sleep;

public class LastEventsFragment extends Fragment implements SportEventsContract {

    Context context;

    @BindView(R.id.loading)
    ProgressBar progressBar;

    @BindView(R.id.recyclerView)
    RecyclerView sportEventsView;

    SportLastEventsPresenter presenter;
    SportEventsAdapter adapter;

    List<SportEvent> lastSportEvents = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_last_events, container,false);
        ButterKnife.bind(this,view);
        progressBarOn();

        presenter = new SportLastEventsPresenter(requireActivity());
        presenter.onAttach(this);

        presenter.requestLastEvents(this);

        return view;
    }


    private void progressBarOn() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void progressBarOff() throws InterruptedException {
        sleep(1000);
        progressBar.setVisibility(View.GONE);
    }

    private void setAdapter() {
        adapter = new SportEventsAdapter(requireActivity(), lastSportEvents);
        sportEventsView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        sportEventsView.setAdapter(adapter);
    }

    @Override
    public void dataSuccessfullyLoaded(List<SportEvent> sportEvents) throws InterruptedException {
        progressBarOff();
        setAdapter();
    }

}