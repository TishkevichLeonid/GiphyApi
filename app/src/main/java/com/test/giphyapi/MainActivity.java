package com.test.giphyapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.test.giphyapi.Model.GiphyData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY = "09a3c886915b48bda73ad6f747d0f72c";

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.gif_url);

        App.getGiphyApi().getGiphy(API_KEY, "", "G").enqueue(new Callback<GiphyData>() {
            @Override
            public void onResponse(Call<GiphyData> call, Response<GiphyData> response) {
                Log.e("onResponse", response.toString());
                mTextView.setText(response.body().getImageUrl());
            }

            @Override
            public void onFailure(Call<GiphyData> call, Throwable t) {
                Log.e("fail", t.toString());
            }
        });
    }
}
