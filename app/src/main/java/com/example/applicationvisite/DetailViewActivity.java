package com.example.applicationvisite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.ContextParams;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationvisite.fragments.BatimentFragment;
import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BatimentRepository;

import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailViewActivity extends AppCompatActivity {

    //ImageButton buttonclose;
    String idQrCode ="";
    //ArrayList<Batiment> listeBatiments = BatimentRepository.getBatimentsListe();
    //LinearLayout my_layout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail_view);
        //my_layout = (LinearLayout) findViewById(R.id.batiment_layout);

        //reception du résultat du scan
        Bundle bundle_reciever = getIntent().getExtras();
        idQrCode = bundle_reciever.getString("id_decoded");

        //Création dynamique
        /*
        //Création dynamique de la vue
        for (Batiment bat : listeBatiments) {
            if (idQrCode.contains(bat.getId())){

                //Titre Page

                TextView text_bat_name = new TextView(this);
                text_bat_name.setText(bat.getNom());
                //text_bat_name.setGravity(0);
                text_bat_name.setPadding(20,20,20, 20);
                //text_bat_name.setTextColor(262327);
                //le mettre en wrap content
                my_layout.addView(text_bat_name);


                //Ressource : Image présentation

                ImageView img_bat = new ImageView(this);
                ViewGroup.LayoutParams params = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,250);
                img_bat.setLayoutParams(params);
                String ressource = bat.getLienPhoto();
                img_bat.setBackgroundResource(lienweb);
                //img_bat.setGravity(0);
                //img_bat.setPadding(20,20,20, 20);
                //img_bat.setTextColor(262327);
                //le mettre en wrap content
                my_layout.addView(img_bat);



                //Titre : Description

                //TextView title_description = new TextView(this);
                //title_description.setText(R.string.title_description);
                //title_description.setTextSize(18);
                //title_description.setGravity(0);
                //title_description.setPadding(20,20,20, 20);
                //title_description.setTextColor(262327);
                //le mettre en wrap content
                //my_layout.addView(title_description);


                //Ressource : Description

                TextView text_bat_description = new TextView(this);
                text_bat_description.setText(bat.getDescription());
                text_bat_description.setTextSize(15);
                //text_bat_description.setGravity(0);
                text_bat_description.setPadding(20,20,20, 20);
                //text_bat_description.setTextColor(262327);
                //le mettre en wrap content
                my_layout.addView(text_bat_description);


                //Titre : lien utiles

                TextView title_lien_utiles = new TextView(this);
                title_lien_utiles.setText(R.string.title_lien_utiles);
                title_lien_utiles.setTextSize(18);
                //title_lien_utiles.setGravity(0);
                title_lien_utiles.setPadding(20,20,20, 20);
                //title_lien_utiles.setTextColor(262327);
                //le mettre en wrap content
                my_layout.addView(title_lien_utiles);


                //Ressource : liens utiles

                TextView item_bat_lienvideo = new TextView(this);
                item_bat_lienvideo.setText(bat.getDescription());
                item_bat_lienvideo.setTextSize(15);
                item_bat_lienvideo.setClickable(true);
                //item_bat_lienvideo.setAutoLinkMask(Linkify.ALL);
                //item_bat_lienvideo.setGravity(0);
                item_bat_lienvideo.setPadding(15,15,15, 15);
                //item_bat_lienvideo.setTextColor(134197);
                //le mettre en wrap content
                my_layout.addView(item_bat_lienvideo);

            }
        }

        */


        String msg_test = "Code scanné : "+ idQrCode;
        Toast toast_test = Toast.makeText(getApplicationContext(),msg_test,Toast.LENGTH_LONG);
        toast_test.show();
/*
        buttonclose = (ImageButton) findViewById(R.id.button_close);
        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainactivity);
            }
        });

 */

    }
}