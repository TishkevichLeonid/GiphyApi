package com.test.giphyapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.test.giphyapi.Model.Message;

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

        mTextView = (TextView) findViewById(R.id.url);

        getGifbyId();
    }

    private void getGifbyId(){
        App.getGiphyApi().getGiphybyID(API_KEY).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                try {
                    mTextView.append(response.body().getData().getId());
                } catch (Exception e){
                    e.printStackTrace();
                }
                Log.e("onResponse", response.toString());
                Toast.makeText(MainActivity.this, "is connected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                Log.e("fail", t.toString());
                Toast.makeText(MainActivity.this, "is not connected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
