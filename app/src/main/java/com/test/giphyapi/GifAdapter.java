package com.test.giphyapi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.test.giphyapi.Model.GiphyData;

import java.util.List;

/**
 * Created by leonidtiskevic on 19.09.17.
 */

public class GifAdapter extends BaseAdapter {

    private Context mContext;
    private List<GiphyData> mGiphyDataList;

    public GifAdapter (Context context, List<GiphyData> giphyDataList){
        this.mContext = context;
        this.mGiphyDataList = giphyDataList;
    }

    public void setGiphyDataList(List<GiphyData> giphyDataList) {
        mGiphyDataList = giphyDataList;
    }

    @Override
    public int getCount() {
        return mGiphyDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mGiphyDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if (view == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(370, 370));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }

        Glide.with(mContext)
                .load(mGiphyDataList.get(i).getImages().getOriginal().getUrl())
                .asGif()
                .placeholder(R.drawable.a1)
                .error(R.drawable.a2)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);

        return imageView;
    }

}
