package com.example.dickysuryo.testdicoding.Adapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.dickysuryo.testdicoding.DetailActivity;
import com.example.dickysuryo.testdicoding.R;
import java.util.ArrayList;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    ArrayList strTitle;
    ArrayList strImage;
    ArrayList strDescription;
    Context context;
    int TYPE_CONTENT_HEADER = 1;

    public ListAdapter(Context context, ArrayList title, ArrayList image, ArrayList description) {
        this.context = context;
        this.strTitle = title;
        this.strImage = image;
        this.strDescription = description;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v ;

        if (viewType == TYPE_CONTENT_HEADER){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.headline_cell, parent, false);
            // set the view's size, margins, paddings and layout parameters
           ; // pass the view to View Holder

        }
        else{
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cell, parent, false);
            // set the view's size, margins, paddings and layout parameters
           // pass the view to View Holder

        }
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 1;
        else return 2;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        if (position == 0) {
            setupHeadline(holder,position);
        }
        else {

            holder.name.setText(strTitle.get(position).toString());
//        holder.image.setImageResource((Integer) personImages.get(position));
            Glide
                    .with(context)
                    .load(strImage.get(position).toString())
                    .into(holder.image);
            // implement setOnClickListener event on item view.
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // display a toast with person name on item click
                    Toast.makeText(context, strTitle.get(position).toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("title", strTitle.get(position).toString());
                    intent.putExtra("image", strImage.get(position).toString());
                    intent.putExtra("description",strDescription.get(position).toString());
                    context.startActivity(intent);
                }
            });
        }
        }

        public void setupHeadline(@NonNull MyViewHolder holder, final int position){
            RequestOptions options = new RequestOptions();
            options.centerCrop();
        holder.title.setText(strTitle.get(position).toString());

        holder.description.setText(strDescription.get(position).toString());
            Glide
                    .with(context)

                    .load(strImage.get(position).toString())
                    .into(holder.imageHeader);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, strTitle.get(position).toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("title", strTitle.get(position).toString());
                    intent.putExtra("image", strImage.get(position).toString());
                    intent.putExtra("description",strDescription.get(position).toString());
                    context.startActivity(intent);
                }
            });

    }



    @Override
    public int getItemCount() {
        return strImage.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name,title,description;
        ImageView image,imageHeader;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            imageHeader = (ImageView) itemView.findViewById(R.id.imgHeadline);
            title = (TextView) itemView.findViewById(R.id.txtTitle);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
            description = (TextView) itemView.findViewById(R.id.txtDescription);

        }
    }
}