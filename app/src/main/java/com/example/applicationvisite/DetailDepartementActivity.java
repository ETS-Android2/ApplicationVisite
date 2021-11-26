package com.example.applicationvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BatimentRepository;
import com.example.applicationvisite.logique.Departement;

import java.util.ArrayList;

public class DetailDepartementActivity extends AppCompatActivity {
    ImageButton buttonclose;
    String idQrCode ="";

    //ArrayList<Batiment> listeBatiments = BatimentRepository.getBatimentsListe();
    ArrayList<Departement> listeDepartement = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_departement);

        //bouton
        buttonclose = (ImageButton) findViewById(R.id.button_close2);
        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainactivity);
                finish();
            }
        });


        //reception du résultat du scan
        Bundle bundle_reciever = getIntent().getExtras();
        idQrCode = bundle_reciever.getString("id_decoded");

        String msg_test = "Code scanné : "+ idQrCode;
        Toast toast_test = Toast.makeText(getApplicationContext(),msg_test,Toast.LENGTH_SHORT);
        toast_test.show();

        //Création dynamique de la vue
        //listeBatiments = SplashScreenActivity.getSharedList();
        Departement dep_info = new Departement("Département Informatique","dep_info", "descriiiiiiiiptionnnnnnn", "https://youtube.com");
        Departement dep_gea = new Departement("Département Gestion des Administrations","dep_gea", "la vente et tout la...", "https://youtube.com");
        Departement dep_tc = new Departement("Département info","dep_info", "zumbacafew", "https://youtube.com");
        listeDepartement.add(dep_info);
        listeDepartement.add(dep_gea);
        listeDepartement.add(dep_tc);

        boolean displayed = false;
        for (Departement dep : listeDepartement) {
            if (idQrCode.contains(dep.getDep_id())){
                displayed =true;
                TextView textView = findViewById(R.id.text_dep_name);
                textView.setText(dep.getDep_nom());
                //TODO faire la suite de l'affichage dynamique
            }
        }
        if (!displayed){
            Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainactivity);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainactivity);
        finish();
    }
}