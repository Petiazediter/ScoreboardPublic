package com.codecool.scoreboard.sport_events.next_events;

import android.content.Context;
import android.widget.Toast;

import com.codecool.scoreboard.model.SportEvent;
import com.codecool.scoreboard.model.SportEventWrapper;
import com.codecool.scoreboard.network.RequestApi;
import com.codecool.scoreboard.network.RetrofitClient;
import com.codecool.scoreboard.sport_events.SportEventsContract;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SportNextEventsPresenter<V extends SportEventsContract> {

    public static int FAV_LEAGUE_ID = 4801;

    private static final String TAG = "SportEventsPresenter";

    V view;
    RequestApi requestApi;

    public SportNextEventsPresenter(Context context) {
        requestApi = RetrofitClient.getRequestApi();
    }

    void onAttach(V view) { this.view = view; }
    void onDetach(V view) { this.view = null; }


    private Observable<SportEventWrapper> getSportNextEventWrapperObservable() {
        return requestApi.getNext15EventsWrapper()
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    void requestNextEvents(NextEventsFragment nextEventsFragment) {
        // getting observable
        subscribe(nextEventsFragment);
    }

    private void subscribe(NextEventsFragment nextEventsFragment) {
        getSportNextEventWrapperObservable()

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

                            nextEventsFragment.nextSportsEvents
                                    .add(new SportEvent(id, description,date,homeTeam,awayTeam,
                                            idHomeTeam,idAwayTeam));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(nextEventsFragment.getContext(),e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {
                        try {
                            view.dataSuccessfullyLoaded(nextEventsFragment.nextSportsEvents);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }


}
