package com.test.giphyapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by leonidtiskevic on 15.09.17.
 */

public class Images {


    @SerializedName("original_still")
    @Expose
    private OriginalStill originalStill;


    public OriginalStill getOriginalStill() {
        return originalStill;
    }

    public void setOriginalStill(OriginalStill originalStill) {
        this.originalStill = originalStill;
    }

}
