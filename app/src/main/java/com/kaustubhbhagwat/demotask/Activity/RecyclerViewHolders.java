package com.kaustubhbhagwat.demotask.Activity;

/**
 * Created by kaustubhbhagwat on 6/20/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaustubhbhagwat.demotask.Model.SONG;
import com.kaustubhbhagwat.demotask.R;

import java.util.List;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView songTitle;
    public TextView songYear;
    public TextView songAuthor;
    public ImageView imgView;
    private Context context;
    private List<SONG.ResultsBean> itemList;

    int pos;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        context = itemView.getContext();


        imgView = (ImageView)itemView.findViewById(R.id.img_view);
        songTitle = (TextView)itemView.findViewById(R.id.title);
        songYear = (TextView)itemView.findViewById(R.id.year);
        songAuthor = (TextView)itemView.findViewById(R.id.song_author);


    }
    @Override
    public void onClick(View view) {

    }


}