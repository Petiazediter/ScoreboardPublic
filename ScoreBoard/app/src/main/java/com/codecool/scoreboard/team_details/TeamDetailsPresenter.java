package com.codecool.scoreboard.team_details;

import android.content.Context;
import android.util.Log;

import com.codecool.scoreboard.model.Team;
import com.codecool.scoreboard.model.TeamWrapper;
import com.codecool.scoreboard.network.RequestApi;
import com.codecool.scoreboard.network.RetrofitClient;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TeamDetailsPresenter <V extends TeamDetailsContractor>
{
    Context context;
    V view;

    protected TeamDetailsPresenter(Context context)
    {
        this.context = context;
    }

    protected  void onAttach(V view)
    {
        this.view = view;
    }

    protected void getTeamDetailsById(int id)
    {
        TeamDetailsActivity activity = (TeamDetailsActivity)context;
        subscribe(activity, id);
        Log.i("JEY",Integer.toString(id));
    }

    private void subscribe(TeamDetailsActivity activity, int teamId)
    {
        RequestApi requestApi = RetrofitClient.getRequestApi();
        requestApi.getTeamById(teamId);

        getTeamWrapperObservable(requestApi,teamId)
                .subscribe(new Observer<TeamWrapper>(){

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TeamWrapper teamWrapper) {
                        view.returnDatas(teamWrapper.getDatas().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ERROR", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private Observable<TeamWrapper> getTeamWrapperObservable(RequestApi requestApi, int teamId)
    {
        return requestApi.getTeamById(teamId)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
