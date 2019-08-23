package com.example.dickysuryo.testdicoding;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AboutActivity extends AppCompatActivity {

    String imgUrl = "https://scontent-sin2-1.xx.fbcdn.net/v/t1.0-1/p320x320/59759796_2238474986189418_6352242212578787328_n.jpg?_nc_cat=109&_nc_oc=AQkXxAera2rZPDTmEBGOoBVBsoFneSr_toIpiqmicqtEoyaUzW8wlK1xjDol8eOW1Xw&_nc_ht=scontent-sin2-1.xx&oh=28bd0564e5ee2e597af9250fa818c008&oe=5DDE3FB9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ImageView imgProfile = (ImageView) findViewById(R.id.imgProfile);

        RequestOptions options = new RequestOptions();
        options.circleCrop();
        Glide
                .with(this)
                .applyDefaultRequestOptions(options)

                .load(imgUrl)
                .into(imgProfile);

    }
}
