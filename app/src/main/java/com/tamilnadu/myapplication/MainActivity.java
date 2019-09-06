package com.tamilnadu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private JSONArray jsonArray;
    private RecyclerView rvMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMusic = findViewById(R.id.recyclerView_music);
        rvMusic.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvMusic.setLayoutManager(layoutManager);
        extractAlbums();
    }

    private void extractAlbums() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String getOptionsUrl = "http://rallycoding.herokuapp.com/api/music_albums";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, getOptionsUrl,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            jsonArray = new JSONArray(response);

                        } catch (Exception o) {
                        }
                        musicJSON();
                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        queue.add(stringRequest);

    }

    private void musicJSON() {
        ArrayList<MusicData> musicList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);
            String title = jsonObject.optString("title");
            String artist = jsonObject.optString("artist");
            String url = jsonObject.optString("url");
            String image = jsonObject.optString("image");
            String thumbnail_image = jsonObject.optString("thumbnail_image");
            musicList.add(new MusicData(title, artist, url, image, thumbnail_image));
        }
        MusicAdapter musicAdapter = new MusicAdapter(musicList);
        rvMusic.setAdapter(musicAdapter);
    }
}

