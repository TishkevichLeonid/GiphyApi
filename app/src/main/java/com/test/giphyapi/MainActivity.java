package com.test.giphyapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.test.giphyapi.Model.Message;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String API_KEY = "09a3c886915b48bda73ad6f747d0f72c";

    private TextView mTextView;
    private ImageView mGifImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.url);
        mGifImage = (ImageView) findViewById(R.id.gif_image_view);

        getGifbyId();

        Glide.with(this)
               // .load("https://media1.giphy.com/media/bv7Ake0xnTaOA/200_s.gif")
                .load("http://i.imgur.com/Vth6CBz.gif")
                .asGif()
                .placeholder(R.drawable.a1)
                .error(R.drawable.a2)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mGifImage);
    }

    private void getGifbyId(){
        App.getGiphyApi().getGiphybyID(API_KEY).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                try {
                    mTextView.setText(response.body().getData().
                            getImages().getOriginalStill().getUrl());
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
