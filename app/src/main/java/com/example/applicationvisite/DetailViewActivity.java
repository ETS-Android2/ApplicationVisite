package com.example.applicationvisite;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.ContextParams;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BatimentRepository;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailViewActivity extends AppCompatActivity {

    ImageButton buttonclose;
    String idQrCode ="";

    //TODO utiliser la liste de la BD
    //ArrayList<Batiment> listeBatiments = BatimentRepository.getBatimentsListe();
    ArrayList<Batiment> listeBatiments = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
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
        listeBatiments = SplashScreenActivity.getSharedList();

        Log.d(TAG, "___________Nouvelle liste partagée______,evoievnenonebn___" + listeBatiments);

        boolean displayed = false;
        for (Batiment bat : listeBatiments) {
            if (idQrCode.contains(bat.getBat_id())){
                displayed =true;
                TextView textView = findViewById(R.id.text_bat_name);
                textView.setText(bat.getBat_nom());
                //TODO faire la suite de l'affichage dynamique
            }
        }
        if (!displayed){
            Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainactivity);
            finish();
        }
    }
}