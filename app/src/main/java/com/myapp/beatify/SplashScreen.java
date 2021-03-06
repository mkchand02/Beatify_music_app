package com.myapp.beatify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    //Activity for the splash screen"

    private final int DELAY = 500;//delay time
    boolean firstStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //to implement the welcome screen as soon as user installs the app
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        firstStart = prefs.getBoolean("firstStart", true);

        openSplashScreen();
    }//onCreate ends

    private void openSplashScreen() {
        new Handler().postDelayed(new Runnable() {
            // Using handler with postDelayed called runnable run method
            @Override
            public void run() {
                if (firstStart) {
                    SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("firstStart", false);
                    editor.apply();

                    // Intent i =
                    startActivity(new Intent(SplashScreen.this, WelcomeScreen.class));
                    // close this activity
                    finish();
                }//if ends
                else {
                    //Intent i = ;
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                    finish();
                }//else ends
            }//run ends
        }, DELAY); // wait for 500 milli-seconds

    }//openSplashScreen ends
}//class ends