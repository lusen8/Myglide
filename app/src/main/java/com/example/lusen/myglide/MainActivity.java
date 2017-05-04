package com.example.lusen.myglide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.myglide.MyGlide;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imaged);

        MyGlide.with(this).load("http://tupian.enterdesk.com/2012/1123/gha/1/enterdeskcom%20%284%29.jpg").into(imageView);
    }
}
