package com.example.applicationvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationvisite.logique.AutreLieu;
import com.example.applicationvisite.logique.BDRepository;

import java.util.ArrayList;

public class DetailAutreLieuActivity extends AppCompatActivity {

    ImageButton buttonclose;
    String idQrCode ="";

    //Pas terminée

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_autre_lieu);

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
        ArrayList<AutreLieu> listeAutreLieu = BDRepository.getAutresLieuxListe();

        boolean displayed = false;
        for (AutreLieu al : listeAutreLieu) {
            if (idQrCode.contains(al.getAl_id())) {
                displayed = true;
                TextView textView = findViewById(R.id.text_al_name);
                textView.setText(al.getAl_nom());
                //TODO faire la suite de l'affichage dynamique
                break;
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