package umn.ac.id.projekuts;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyVieHolder> {

    private Context mContext;
    private ArrayList<Song> mSongs;

    SongAdapter(Context mContext, ArrayList<Song> mSongs){
        this.mSongs = mSongs;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.song_item, parent, false);
        return new MyVieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVieHolder holder, int position) {
        holder.songName.setText(mSongs.get(position).getTitle());
        byte[] image = getAlbumArt(mSongs.get(position).getPath());
        if (image != null){
            Glide.with(mContext).asBitmap().load(image).into(holder.songArt);
        }
        else {
            Glide.with(mContext).load(R.drawable.musicplay).into(holder.songArt);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayActivity.class);
                intent.putExtra("position", position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    public class MyVieHolder extends RecyclerView.ViewHolder{
        TextView songName;
        ImageView songArt;
        public MyVieHolder(@NonNull View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.song_name);
            songArt = itemView.findViewById(R.id.song_img);
        }
    }

    private byte [] getAlbumArt(String uri){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] albumArt = retriever.getEmbeddedPicture();
        retriever.release();
        return albumArt;
    }


}

