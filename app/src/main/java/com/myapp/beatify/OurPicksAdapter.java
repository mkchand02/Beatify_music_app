package com.myapp.beatify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class OurPicksAdapter extends RecyclerView.Adapter<OurPicksAdapter.MyViewHolder> {
    private List<CreateSong> mOurPicksList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public OurPicksAdapter(List<CreateSong> mSongList) {
        this.mOurPicksList = mSongList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.create_our_picks, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, mListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.imageView.setImageResource(mSongList.get(position).getImgURL());
        Glide.with(holder.imageView.getContext()).load(mOurPicksList.get(position).getImgURL()).into(holder.imageView);
        holder.textView.setText(mOurPicksList.get(position).getTxt());
    }

    @Override
    public int getItemCount() {
        return mOurPicksList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.our_img);
            this.textView = itemView.findViewById(R.id.our_txt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();

                        if (position == RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

