package com.android.uploadpicsinfirebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ArrayList<String> urlList;
    private Context context;

    public ImageAdapter(ArrayList<String> urlList, Context context) {
        this.urlList = urlList;
        this.context = context;
    }

    public void setUpdatedData(ArrayList<String> urlList) {
        this.urlList = urlList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        Glide.with(context)
                .load(urlList.get(position))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return urlList.size();
    }

    static class ImageViewHolder extends  RecyclerView.ViewHolder{

        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewPreview);
        }
    }
}
