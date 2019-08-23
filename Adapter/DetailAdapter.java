package com.example.dickysuryo.testdicoding.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dickysuryo.testdicoding.R;
import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.MyViewHolder> {
    String strTitle;
    String strImage;
    String strDescription;
    Context context;

    public DetailAdapter(Context context, String title, String image,String description) {
        this.context = context;
        this.strTitle = title;
        this.strImage = image;
        this.strDescription = description;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.detail_cell, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        DetailAdapter.MyViewHolder vh = new DetailAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
    holder.name.setText(strTitle);
        RequestOptions options = new RequestOptions();
        options.centerCrop();

        Glide
                .with(context)
                .applyDefaultRequestOptions(options)
                .load(strImage)
                .into(holder.image);
        holder.description.setText(strDescription);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name,description;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.txtTitle);
            image = (ImageView) itemView.findViewById(R.id.imgHeader);
            description = (TextView) itemView.findViewById(R.id.txtDescription);
        }
    }
}
