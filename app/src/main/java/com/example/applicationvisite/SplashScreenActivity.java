package com.example.applicationvisite;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BDRepository;
import com.example.applicationvisite.logique.Departement;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    private final long BOOT_DELAY = 4000;
    private static ArrayList<Batiment> sharedBatList;
    private static ArrayList<Departement> sharedDepList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //redirige vers la page principale après 4 secondes
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Chargement des données de la BD
            //création des répertoires
            BDRepository repository_batiment = new BDRepository();


            //mise à jour liste
            repository_batiment.updateDataBat();
            repository_batiment.updateDataDep();


        //code éxécuté après les 4 secondes
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Intent welcomeActivity = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(welcomeActivity);

                //Collecte des données de la BD
                sharedBatList = new ArrayList<>();
                for (Batiment bat: repository_batiment.getBatimentsListe()) {
                    Batiment copy = new Batiment(bat.getBat_nom(),bat.getBat_id(),bat.getBat_description(), bat.getBat_id_img(), bat.isVisited());
                    sharedBatList.add(copy);
                }
                Log.d(TAG, "___________Nouvelle liste partagée batiments_________" + sharedBatList);

                sharedDepList = new ArrayList<>();
                for (Departement dep: repository_batiment.getDepartementsListe()) {
                    Departement copy = new Departement(dep.getDep_nom(),dep.getDep_id(),dep.getDep_description(), dep.getDep_lienvideo(),dep.getDep_mapLocation());
                    sharedDepList.add(copy);
                }
                Log.d(TAG, "___________Nouvelle liste partagée départements_________" + sharedDepList);

                finish();
            }

        };
        //Attente des 4 secondes avant de run
        new Handler().postDelayed(run,BOOT_DELAY);
    }

    public static ArrayList<Batiment> getSharedBatList() {
        return sharedBatList;
    }
}