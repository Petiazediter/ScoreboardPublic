package com.codecool.scoreboard.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    public static Retrofit getClient() {
        OkHttpClient client = new OkHttpClient
                .Builder()
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    public static RequestApi getRequestApi() { return RetrofitClient.getClient().create(RequestApi.class); }
}
