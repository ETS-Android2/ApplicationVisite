package com.example.applicationvisite;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.applicationvisite.logique.AutreLieu;
import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BDRepository;
import com.example.applicationvisite.logique.Departement;
import com.example.applicationvisite.logique.Visite;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    private final long BOOT_DELAY = 4000;
    private static ArrayList<Batiment> sharedBatList = new ArrayList<>();

    //redirige vers la page principale après 4 secondes de chargement
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Chargement des données de la BD
            //création des répertoires
            BDRepository bdRepository = new BDRepository();

            //mise à jour des listes de données
            bdRepository.updateDataBat();
            bdRepository.updateDataDep();
            bdRepository.updateDataAL();

        //Initialisation de la visite
        Visite v = Visite.getInstance();

        //code éxécuté après les 4 secondes
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "TEST -> liste batiment fraichement dl" + BDRepository.getBatimentsListe());
                //Collecte des données de la BD pour les batiments et copie de celle-ci dans une liste locale indépendante de la BD                sharedBatList = new ArrayList<>();
                for (Batiment bat: BDRepository.getBatimentsListe()) {
                    Batiment copy = new Batiment(bat.getBat_nom(),bat.getBat_id(),bat.getBat_description(), bat.getBat_id_img(), bat.isVisited(), bat.getBat_liste_dep());
                    sharedBatList.add(copy);
                }
                Log.d(TAG, "___________Nouvelle liste partagée batiments_________" + sharedBatList);

                Intent welcomeActivity = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(welcomeActivity);
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