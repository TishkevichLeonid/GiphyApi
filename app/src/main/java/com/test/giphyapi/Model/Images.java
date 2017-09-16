package com.test.giphyapi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.giphyapi.Model.images.Original;
import com.test.giphyapi.Model.images.OriginalStill;

/**
 * Created by leonidtiskevic on 15.09.17.
 */

public class Images {


    @SerializedName("original_still")
    @Expose
    private OriginalStill originalStill;

    @SerializedName("original")
    @Expose
    private Original original;

    public OriginalStill getOriginalStill() {
        return originalStill;
    }

    public void setOriginalStill(OriginalStill originalStill) {
        this.originalStill = originalStill;
    }

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }
}
