package com.test.giphyapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leonidtiskevic on 16.09.17.
 */

public class MessageList {

    @SerializedName("data")
    @Expose
    private List<GiphyData> data;

    public List<GiphyData> getDataList() {
        return data;
    }

    public void setDataList(List<GiphyData> dataList) {
        this.data = data;
    }
}
