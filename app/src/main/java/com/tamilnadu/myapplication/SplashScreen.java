package com.tamilnadu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends Activity {

     private int SPLASH_TIME_OUT = 3000;
     private ImageView imageview_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageview_splash=findViewById(R.id.imageview_splash);
        imageview_splash.setImageResource(R.drawable.chittoo);


        new Handler().postDelayed(new Runnable() {
            //Causes the Runnable r to be added to the message queue, to be run after the specified amount of time elapse
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}









