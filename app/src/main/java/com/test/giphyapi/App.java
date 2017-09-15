package com.test.giphyapi;

import android.app.Application;

import com.test.giphyapi.api.GiphyApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leonidtiskevic on 15.09.17.
 */

public class App extends Application {

    private static GiphyApi sGiphyApi;
    private Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.giphy.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sGiphyApi = mRetrofit.create(GiphyApi.class);
    }

    public static GiphyApi getGiphyApi(){
        return sGiphyApi;
    }
}
