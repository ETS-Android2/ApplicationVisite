package com.example.applicationvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationvisite.logique.BDRepository;
import com.example.applicationvisite.logique.Departement;

import java.util.ArrayList;

public class DetailDepartementActivity extends AppCompatActivity {
    ImageButton buttonclose;
    String idQrCode ="";

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
        ArrayList<Departement> listeDepartement = BDRepository.getDepartementsListe();

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