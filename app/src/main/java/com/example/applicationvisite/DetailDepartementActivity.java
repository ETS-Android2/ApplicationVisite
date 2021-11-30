package com.example.applicationvisite;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicationvisite.logique.BDRepository;
import com.example.applicationvisite.logique.Departement;
import com.example.applicationvisite.logique.YoutubeConfig;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

public class DetailDepartementActivity extends YouTubeBaseActivity{
    ImageButton buttonclose;
    String idQrCode ="";
    YouTubePlayerView mYoutubePlayerView;
    Button playButton;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    Departement curent_dep = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_departement);

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
                curent_dep = dep;
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

        //Partie intégration youtube
        playButton = (Button) findViewById(R.id.play_button_youtube);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onclick: dep info -> "+curent_dep.getDep_lienvideo());
                mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(), mOnInitializedListener);
            }
        });
        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //Succes de chargement
                youTubePlayer.loadVideo(curent_dep.getDep_lienvideo());
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                //Echec de chargement
                Log.d(TAG, "onInitializationSuccess: failed to read -> " + curent_dep.getDep_lienvideo());
            }
        };

        //bouton fermer
        buttonclose = (ImageButton) findViewById(R.id.button_close2);
        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainactivity);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainactivity);
        finish();
    }
}