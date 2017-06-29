package com.kaustubhbhagwat.demotask.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.widget.TextView;

import com.kaustubhbhagwat.demotask.Model.SONG;
import com.kaustubhbhagwat.demotask.R;

public class DetailsActivity extends AppCompatActivity {
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    private SONG.ResultsBean song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setTitle("Song Details");

        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv3=(TextView)findViewById(R.id.textView3);
        tv4=(TextView)findViewById(R.id.textView4);
        tv5=(TextView)findViewById(R.id.textView5);
        tv6=(TextView)findViewById(R.id.textView6);
        tv7=(TextView)findViewById(R.id.textView7);

        Intent i = getIntent();
        String artistName = i.getStringExtra("artistName").toString();
        String artistViewUrl = i.getStringExtra("artistViewUrl").toString();
        String country = i.getStringExtra("country").toString();
        String collectionName = i.getStringExtra("collectionName").toString();
        String collectionExplicitness = i.getStringExtra("collectionExplicitness").toString();
        Double trackPrice = i.getDoubleExtra("trackPrice",0.00);
        String wrapperType = i.getStringExtra("wrapperType").toString();

        tv1.setText("Artist: "+ artistName);
        tv2.setText("Song Link: "+ artistViewUrl);
        Linkify.addLinks(tv2, Linkify.ALL);

        tv3.setText("Country: "+country);
        tv4.setText("Album Name: "+collectionName);
        tv5.setText("CollectionExplicitness: "+collectionExplicitness);
        tv6.setText("Track Price: "+trackPrice.toString()+"$");
        tv7.setText("Type: "+wrapperType);



    }
}
