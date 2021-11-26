package com.example.applicationvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BatimentRepository;

import java.util.ArrayList;

public class DetailAutreLieuActivity extends AppCompatActivity {

    ImageButton buttonclose;
    String idQrCode ="";

    //ArrayList<Batiment> listeBatiments = BatimentRepository.getBatimentsListe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_autre_lieu);
    }
}