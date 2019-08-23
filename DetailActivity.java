package com.example.dickysuryo.testdicoding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dickysuryo.testdicoding.Adapter.DetailAdapter;


public class DetailActivity extends AppCompatActivity {

    String title;
    String image;
    String description;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        title = getIntent().getStringExtra("title");
        image = getIntent().getStringExtra("image");
        description = getIntent().getStringExtra("description");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
       DetailAdapter customAdapter = new DetailAdapter(DetailActivity.this,title,image,description);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
}

