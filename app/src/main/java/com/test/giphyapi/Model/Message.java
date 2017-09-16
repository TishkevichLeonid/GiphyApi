package com.test.giphyapi.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by leonidtiskevic on 15.09.17.
 */

public class Message {

    @SerializedName("data")
    private GiphyData data;

    public GiphyData getData() {
        return data;
    }

    public void setData(GiphyData data) {
        this.data = data;
    }

}
