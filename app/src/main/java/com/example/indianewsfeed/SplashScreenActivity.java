package com.example.indianewsfeed;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(3500);

                }
                catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    Intent openMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(openMain);
                    finish();
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}