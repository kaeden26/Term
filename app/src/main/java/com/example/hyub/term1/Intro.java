package com.example.hyub.term1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by hyub on 2016-12-17.
 */

public class Intro extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intro.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        },2000);
    }
}
