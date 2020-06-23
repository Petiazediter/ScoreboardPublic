package com.codecool.scoreboard.sport_events;

import android.content.Context;
import android.widget.Toast;

import com.codecool.scoreboard.model.SportEvent;
import com.codecool.scoreboard.model.SportEventWrapper;
import com.codecool.scoreboard.network.RequestApi;
import com.codecool.scoreboard.network.RetrofitClient;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SportEventsPresenter<V extends SportEventsContract> {

    public static int FAV_LEAGUE_ID = 4801;

    private static final String TAG = "SportEventsPresenter";

    V view;
    RequestApi requestApi;

    public SportEventsPresenter(Context context) {
        requestApi = RetrofitClient.getRequestApi();
    }

    void onAttach(V view) { this.view = view; }
    void onDetach(V view) { this.view = null; }


    void requestLastEvents(LastEventsActivity lastEventsActivity) {
        // getting observable
        requestApi.getLast15EventsWrapper()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                // subscribe to that observable
                .subscribe(new Observer<SportEventWrapper>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SportEventWrapper sportEventWrapper) {

                        List<SportEvent> sportEventList = sportEventWrapper.getEventList();

                        for (int i = 0; i < sportEventList.size() ; i++) {

                            int id = sportEventList.get(i).getId();
                            String description = sportEventList.get(i).getDescription();
                            String date = sportEventList.get(i).getDate();
                            String homeTeam = sportEventList.get(i).getHomeTeam();
                            String awayTeam = sportEventList.get(i).getAwayTeam();
                            int idHomeTeam = sportEventList.get(i).getIdHomeTeam();
                            int idAwayTeam = sportEventList.get(i).getIdAwayTeam();

                            lastEventsActivity.lastSportEvents
                                    .add(new SportEvent(id, description,date,homeTeam,awayTeam,
                                            idHomeTeam,idAwayTeam));

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(lastEventsActivity,e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {
                        view.dataSuccessfullyLoaded(lastEventsActivity.lastSportEvents);

                    }
                });
    }


}
