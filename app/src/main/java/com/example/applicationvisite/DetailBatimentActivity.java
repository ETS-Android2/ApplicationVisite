package com.example.applicationvisite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BDRepository;

import java.util.ArrayList;

public class DetailBatimentActivity extends AppCompatActivity {

    ImageButton buttonclose;
    String idQrCode ="";

    //TODO utiliser la liste de la BD
    ArrayList<Batiment> listeBatiments = BDRepository.getBatimentsListe();

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
        listeBatiments = SplashScreenActivity.getSharedBatList();

        boolean displayed = false;
        for (Batiment bat : listeBatiments) {
            if (idQrCode.contains(bat.getBat_id())){
                displayed =true;
                bat.setVisited(true);
                TextView textView = findViewById(R.id.text_bat_name);
                textView.setText(bat.getBat_nom());

                TextView textView2 = findViewById(R.id.text_bat_description);
                textView2.setText(bat.getBat_description());

                ImageView imageView = findViewById(R.id.imageView2);
                Glide.with(this).load(bat.getBat_id_img()).into(imageView);
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