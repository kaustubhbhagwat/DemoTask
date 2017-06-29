package com.kaustubhbhagwat.demotask.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.kaustubhbhagwat.demotask.Model.SONG;
import com.kaustubhbhagwat.demotask.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.rv_list);
      //  recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        requestJsonObject();


    }
    private void requestJsonObject(){
        final List<SONG.ResultsBean> songList = new ArrayList<>();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://itunes.apple.com/search?term=michael+jackson";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {
                    int resultCount = response.optInt("resultCount");
                    if (resultCount > 0) {
                        Gson gson = new Gson();
                        JSONArray jsonArray = response.optJSONArray("results");
                        if (jsonArray != null) {
                            SONG.ResultsBean[] songs = gson.fromJson(jsonArray.toString(), SONG.ResultsBean[].class);
                            if (songs != null && songs.length > 0) {
                                for (SONG.ResultsBean song : songs) {

                                    songList.add(song);
                                    System.out.println(songs);


                                }
                            }
                            adapter = new RecyclerViewAdapter(MainActivity.this, songList);
                            recyclerView.setAdapter(adapter);

                            recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    String artistName = songList.get(position).getArtistName();
                                    String artistViewUrl = songList.get(position).getArtistViewUrl();
                                    String country = songList.get(position).getCountry();
                                    String collectionName = songList.get(position).getCollectionName();
                                    String collectionExplicitness = songList.get(position).getCollectionExplicitness();
                                    Double trackPrice = songList.get(position).getTrackPrice();
                                    String wrapperType = songList.get(position).getWrapperType();
                                    Intent i = new Intent(MainActivity.this,DetailsActivity.class);
                                    i.putExtra("artistName",artistName);
                                    i.putExtra("artistViewUrl",artistViewUrl);
                                    i.putExtra("country",country);
                                    i.putExtra("collectionName",collectionName);
                                    i.putExtra("collectionExplicitness",collectionExplicitness);
                                    i.putExtra("trackPrice",trackPrice);
                                    i.putExtra("wrapperType",wrapperType);
                                    startActivity(i);


                                }
                            }));


                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("LOG", error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
            }
        }