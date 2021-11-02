package com.example.applicationvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    private final long BOOT_DELAY = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //redirige vers la page principale après 4 secondes
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //code éxécuté après les 4 secondes
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent welcomeActivity = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(welcomeActivity);
                finish();
            }
        };
        //Attente des 4 secondes avant de run
        new Handler().postDelayed(run,BOOT_DELAY);
    }
}