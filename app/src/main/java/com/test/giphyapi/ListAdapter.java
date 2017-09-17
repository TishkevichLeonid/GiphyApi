package com.test.giphyapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.test.giphyapi.Model.GiphyData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonidtiskevic on 17.09.17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<GiphyData> mGiphyDataList;
    private Context mContext;

    public ListAdapter(List<GiphyData> list, Context context){
        mGiphyDataList = new ArrayList<>();
        this.mGiphyDataList = list;
        this.mContext = context;
    }

    public void setGiphyDataList(List<GiphyData> giphyDataList) {
        mGiphyDataList = giphyDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gif_image, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GiphyData gif = mGiphyDataList.get(position);
        Glide.with(mContext)
                .load(gif.getImages().getOriginal().getUrl())
                .asGif()
                .placeholder(R.drawable.a1)
                .error(R.drawable.a2)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mGiphyDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.gif_image);
        }
    }
}
