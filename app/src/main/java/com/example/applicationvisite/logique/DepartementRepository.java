package com.example.applicationvisite.logique;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DepartementRepository {

        //Connecter à la base de données
        private DatabaseReference databaseRef = FirebaseDatabase.getInstance("https://applicationvisite-default-rtdb.europe-west1.firebasedatabase.app/").getReference("departements");


        //Stocker les informations dans une liste
        private ArrayList<Departement> departementListe = new ArrayList<>();


        public void updateData(){

            //absorber les données depuis la dataref -> liste de departement

            databaseRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //retirer les anciennes données
                    departementListe.clear();

                    //récolter la liste
                    for (DataSnapshot ds: dataSnapshot.getChildren()){

                        //construire un object departement
                        Departement departement = ds.getValue(Departement.class);

                        Log.d(TAG, "Value true is: " + departement);

                        departementListe.add(departement);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    // Failed to read value
                    Log.d(TAG, "IMPOSSIBLE LIRE DONNEES ");
                }
            });

        }

        // getter
    public ArrayList<Departement> getDepartementListe() {
        return departementListe;
    }

}
