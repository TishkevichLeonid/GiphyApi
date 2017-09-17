package com.test.giphyapi.api;

import com.test.giphyapi.Model.MessageList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leonidtiskevic on 15.09.17.
 *
 */

public interface GiphyApi {

    @GET("v1/gifs/search")
    Call<MessageList> getGifBySearch(@Query("q") String querySearch,
                                     @Query("api_key") String apiKey);
}
