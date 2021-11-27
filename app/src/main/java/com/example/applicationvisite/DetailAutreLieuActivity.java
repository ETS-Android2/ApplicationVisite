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

    //ArrayList<AutreLieu> listeBatiments = BDRepository.getAutreLieuListe();
    ArrayList<AutreLieu> listeAutreLieu = new ArrayList<>();

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
        //listeBatiments = SplashScreenActivity.getSharedList();
        AutreLieu al_caferaria_sud = new AutreLieu("Cafétaria du Batiment A","al_caferaria_sud", "la cafet vend des pains au chocolat hyper bon...", "https://youtube.com", "11h / 14h30","bat_a" );
        AutreLieu al_caferaria_nord = new AutreLieu("Cafétaria Nord","al_caferaria_nord", "la cafet vend des pains au chocolat hyper bon...", "izly.fr", "11h / 13h30","cafet_nord");
        AutreLieu al_bu = new AutreLieu("Bibliotèque Universitaire","al_bu", "zumbacafew on peut lire et tout !!!", "https://youtube.com", "8h / 19h","bat_a");
        listeAutreLieu.add(al_bu);
        listeAutreLieu.add(al_caferaria_nord);
        listeAutreLieu.add(al_caferaria_sud);

        boolean displayed = false;
        for (AutreLieu al : listeAutreLieu) {
            if (idQrCode.contains(al.getAl_id())) {
                displayed = true;
                //bat.isVisited()=true;
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