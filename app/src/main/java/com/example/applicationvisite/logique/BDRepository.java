package com.example.applicationvisite.logique;


import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import kotlin.Unit;

public class BDRepository {

    //Connecter à la base de données
    private DatabaseReference databaseRef = FirebaseDatabase.getInstance("https://applicationvisite-default-rtdb.europe-west1.firebasedatabase.app/").getReference("batiments");
    private DatabaseReference databaseRef2 = FirebaseDatabase.getInstance("https://applicationvisite-default-rtdb.europe-west1.firebasedatabase.app/").getReference("departements");
    //private DatabaseReference databaseRef3 = FirebaseDatabase.getInstance("https://applicationvisite-default-rtdb.europe-west1.firebasedatabase.app/").getReference("autreslieux");

    //récupérer les reférences
    //Stocker les informations dans une liste
    private static ArrayList<Batiment> batimentsListe = new ArrayList<>();
    private static ArrayList<Departement> departementsListe = new ArrayList<>();
    //private static ArrayList<AutreLieu> autresLieuxListe = new ArrayList<>();



    public void updateDataBat(){

        //absorber les données depuis la dataref -> liste de batiments
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //retirer les anciennes données
                batimentsListe.clear();

                //récolter la liste
                for (DataSnapshot ds: dataSnapshot.getChildren()){

                    //construire un object batiment
                    Batiment batiment = ds.getValue(Batiment.class);

                    Log.d(TAG, "Value true is: " + batiment);

                    batimentsListe.add(batiment);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                //créer une page d'erreur
                System.out.println("--------impossible de lire des données------------");
            }
        });

    }

    public void updateDataDep(){
        //absorber les données depuis la dataref -> liste de batiments
        databaseRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //retirer les anciennes données
                departementsListe.clear();

                //récolter la liste
                for (DataSnapshot ds: dataSnapshot.getChildren()){

                    //construire un object batiment
                    Departement departement = ds.getValue(Departement.class);

                    Log.d(TAG, "Value true is: " + departement);

                    departementsListe.add(departement);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Failed to read value
                //créer une page d'erreur
                System.out.println("--------impossible de lire des données------------");
            }
        });

    }

    // getter
    public static ArrayList<Batiment> getBatimentsListe() {
        return batimentsListe;
    }

    public static ArrayList<Departement> getDepartementsListe() {
        return departementsListe;
    }
}
