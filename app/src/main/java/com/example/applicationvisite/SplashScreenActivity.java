package com.example.applicationvisite;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BatimentRepository;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    private final long BOOT_DELAY = 3000;
    private ArrayList<Batiment> sharedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //redirige vers la page principale après 4 secondes
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Chargement des données de la BD
            //création des répertoires
            BatimentRepository repository_batiment = new BatimentRepository();


            //mise à jour liste
            repository_batiment.updateData();


        //code éxécuté après les 4 secondes
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent welcomeActivity = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(welcomeActivity);

                //Collecte des données de la BD
                sharedList = new ArrayList<>();
                for (Batiment bat: repository_batiment.getBatimentsListe()) {
                    Batiment copy = new Batiment(bat.getBat_nom(),bat.getBat_id(),bat.getBat_description(), bat.getBat_id_img());
                    sharedList.add(copy);
                }
                Log.d(TAG, "___________Nouvelle liste partagée_________" + sharedList);

                finish();
            }

        };
        //Attente des 4 secondes avant de run
        new Handler().postDelayed(run,BOOT_DELAY);
    }
}