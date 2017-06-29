package com.kaustubhbhagwat.demotask.Activity;

/**
 * Created by kaustubhbhagwat on 6/20/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kaustubhbhagwat.demotask.Model.SONG;
import com.kaustubhbhagwat.demotask.R;
import com.squareup.picasso.Picasso;

import java.util.List;
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {
    private List<SONG.ResultsBean> itemList;
    private Context context;
    public RecyclerViewAdapter(Context context, List<SONG.ResultsBean> itemList) {
        this.itemList = (List<SONG.ResultsBean>) itemList;
        this.context = context;
    }



    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_row, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {



        holder.songTitle.setText("Track Name:" + itemList.get(position).getTrackName());
        holder.songYear.setText("Artist:" + itemList.get(position).getArtistName().toString());
        holder.songAuthor.setText("Song Link:" + itemList.get(position).getTrackViewUrl().toString());
        Linkify.addLinks(holder.songAuthor, Linkify.ALL);
        Picasso.with(context).load(itemList.get(position).getArtworkUrl30()).into(holder.imgView);
    }
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}