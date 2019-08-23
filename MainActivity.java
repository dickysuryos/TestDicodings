package com.example.dickysuryo.testdicoding;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dickysuryo.testdicoding.Adapter.ListAdapter;
import com.example.dickysuryo.testdicoding.Constant.Constant;

import java.util.ArrayList;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity {
    // ArrayList for person names
    Constant constant = new Constant();
    String urlImage = "https://ci4.googleusercontent.com/proxy/iRFETB7iYOIt8XK950Aw880AaWoDFaWhVS2MnqCvyB_-zX3XvGOy1H8HFgfmcjPucCXNhM4XjjBTaH18FjnKJ0S-CyRnmZ6b1wxapizIfB-X_RTEyxbnB6nvLKWe=s0-d-e1-ft#https://i.pinimg.com/400x300/c9/b4/ca/c9b4ca1aec6eb8e117bd543d457f2c34.jpg";
    ArrayList listTitle = constant.arrayTitle;
    ArrayList listImage = constant.arrayImage;
    ArrayList listDescription = constant.arrayDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        ListAdapter customAdapter = new ListAdapter(MainActivity.this, listTitle,listImage,listDescription);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            Intent intent = new Intent(this,AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}