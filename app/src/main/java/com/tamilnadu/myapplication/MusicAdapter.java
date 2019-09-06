package com.tamilnadu.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//<Button
//            android:id="@+id/buyNow_Button"
//                    style="@android:style/Widget.Button.Inset"
//                    android:layout_width="match_parent"
//                    android:layout_height="wrap_content"
//                    android:layout_below="@id/image"
//                    android:shadowColor="#009E0A40"
//                    android:text="Buy now"
//                    android:textColor="#0E0E0E"
//                    android:textColorHint="#1447E8" />


class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {
    private ArrayList<MusicData> musicList;

    public MusicAdapter(ArrayList<MusicData> musicList) {
        this.musicList = musicList;
    }

    private Context mContext;

    @NonNull
    @Override
    public MusicAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_music, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.MyViewHolder myViewHolder, int i) {


        final MusicData musicData = musicList.get(i);
        myViewHolder.title_tv.setText(musicData.getTitle());
        myViewHolder.artist_tv.setText(musicData.getArtist());

        String image = musicData.getImage();
        Picasso.get()
                .load(image)
                .into(myViewHolder.image);

        String thumbnail_image = musicData.getThumbnail_image();
        Picasso.get()
                .load(thumbnail_image)
                .into(myViewHolder.thumbnail_image);

        final String albumURL=musicData.getUrl();
        myViewHolder.buyNow_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent videoClient = new Intent(Intent.ACTION_VIEW);
                videoClient.setData(Uri.parse(albumURL));
                v.getContext().startActivity(videoClient);
            }
        });



    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title_tv;
        private TextView artist_tv;
        private ImageView image;
        private ImageView thumbnail_image;
        Button buyNow_Button;

        private MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title_tv = itemView.findViewById(R.id.title_tv);
            artist_tv = itemView.findViewById(R.id.artist_tv);
            image = itemView.findViewById(R.id.image);
            thumbnail_image = itemView.findViewById(R.id.thumbnail_image);
            buyNow_Button = itemView.findViewById(R.id.buyNow_Button);
        }
    }
}
