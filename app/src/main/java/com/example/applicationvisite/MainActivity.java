package com.example.applicationvisite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton buttonForScanQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonForScanQR = (FloatingActionButton) findViewById(R.id.qrButton);

        buttonForScanQR.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent qrActivity = new Intent(getApplicationContext(),QrActivity.class);
                startActivity(qrActivity);
                finish();
            }
        });

    }

}