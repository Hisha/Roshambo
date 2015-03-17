package com.hishatech.android.roshambo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    //http://www.exploreroute.com/android-splash-screen-android-studio/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int myTimer = 5000;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish(); // close this activity

            }

        }, myTimer);

    }

}