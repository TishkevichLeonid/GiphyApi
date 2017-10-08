package com.test.giphyapi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

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
    private static final String KEY_QUERY = "query_key";

    private String querySearch = "funny cat";
    private EditText mSearchText;
    private Button mSearchButton;
    private List<GiphyData> mGiphyDataList;
    private GifAdapter mGifAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchText = (EditText) findViewById(R.id.edit_text_search);
        mSearchButton = (Button) findViewById(R.id.button_search_query);
        GridView gridView = (GridView) findViewById(R.id.gridView1);
        mGiphyDataList = new ArrayList<>();

        getGifBySearch();

        mGifAdapter = new GifAdapter(this, mGiphyDataList);
        gridView.setAdapter(mGifAdapter);
        mGifAdapter.notifyDataSetChanged();

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSearchText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "empty string", Toast.LENGTH_SHORT).show();
                } else {
                    mGiphyDataList.clear();
                    querySearch = mSearchText.getText().toString();
                    getGifBySearch();
                    mGifAdapter.setGiphyDataList(mGiphyDataList);
                    mGifAdapter.notifyDataSetChanged();
                    InputMethodManager inputMethodManager = (InputMethodManager) MainActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(MainActivity.this.getCurrentFocus().getWindowToken(), 0);
                }
            }
        });

        if (savedInstanceState != null){
            querySearch = savedInstanceState.getString(KEY_QUERY);
        }
    }

    private void getGifBySearch(){
        App.getGiphyApi().getGifBySearch(querySearch, API_KEY).enqueue(new Callback<MessageList>() {
            @Override
            public void onResponse(Call<MessageList> call, Response<MessageList> response) {
                try {
                    Log.e(TAG, response.toString());
                    for (GiphyData all: response.body().getDataList()){
                        mGiphyDataList.add(all);
                    }
                    if (mGifAdapter == null){
                        mGifAdapter = new GifAdapter(MainActivity.this, mGiphyDataList);
                    } else {
                        mGifAdapter.setGiphyDataList(mGiphyDataList);
                        mGifAdapter.notifyDataSetChanged();
                    }
                    Log.e(TAG, "1st " + String.valueOf(mGiphyDataList.size()));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MessageList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "is not connected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_QUERY, querySearch);
    }
}
