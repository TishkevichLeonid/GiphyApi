package com.test.giphyapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.giphyapi.Model.GiphyData;
import com.test.giphyapi.Model.MessageList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "onResponse";
    private static final String API_KEY = "09a3c886915b48bda73ad6f747d0f72c";
    private static final String QUERY_SEARCH = "funny cat";

    private TextView mTextView;
    private ImageView mGifImage;
    private EditText mSearchText;
    private Button mSearchButton;
    private List<GiphyData> mGiphyDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.url);
        mGifImage = (ImageView) findViewById(R.id.gif_image_view);
        mSearchText = (EditText) findViewById(R.id.edit_text_search);
        mSearchButton = (Button) findViewById(R.id.button_search_query);
        mGiphyDataList = new ArrayList<>();

       getGifBySearch();
    }

    private void getGifBySearch(){
        App.getGiphyApi().getGifBySearch(QUERY_SEARCH, API_KEY).enqueue(new Callback<MessageList>() {
            @Override
            public void onResponse(Call<MessageList> call, Response<MessageList> response) {
                try {
                    Log.e(TAG, response.toString());
                    for (GiphyData all: response.body().getDataList()){
                        mGiphyDataList.add(all);
                    }
                    Log.e(TAG, String.valueOf(mGiphyDataList.size()));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MessageList> call, Throwable t) {

            }
        });
    }
}
