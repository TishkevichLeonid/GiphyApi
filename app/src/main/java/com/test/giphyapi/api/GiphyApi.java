package com.test.giphyapi.api;

import com.test.giphyapi.Model.GiphyData;
import com.test.giphyapi.Model.Message;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leonidtiskevic on 15.09.17.
 *
 */

public interface GiphyApi {

    @GET("v1/gifs/random")
    Call<GiphyData> getGiphy(@Query("api_key") String apiKey,
                             @Query("tag") String tagQuery,
                             @Query("rating") String rating
                             );

    @GET("v1/gifs/FiGiRei2ICzzG")
    Call<Message> getGiphybyID(@Query("api_key") String apiKey);

}
