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

public class BatimentRepository {

    //Connecter à la base de données
    private DatabaseReference databaseRef = FirebaseDatabase.getInstance("https://applicationvisite-default-rtdb.europe-west1.firebasedatabase.app/").getReference("batiments");


    //Stocker les informations dans une liste
    private ArrayList<Batiment> batimentsListe = new ArrayList<>();



    public void updateData(){

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
                System.out.println("--------impossible de lire des données------------");
            }
        });

    }

    // getter
    public ArrayList<Batiment> getBatimentsListe() {
        return batimentsListe;
    }

}