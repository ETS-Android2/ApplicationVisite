package com.example.applicationvisite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.applicationvisite.logique.Batiment;
import com.example.applicationvisite.logique.BDRepository;
import com.example.applicationvisite.logique.Departement;
import com.example.applicationvisite.logique.Visite;
import com.example.applicationvisite.recyclerview.MyDepartementAdapter;

import java.util.ArrayList;

public class DetailBatimentActivity extends AppCompatActivity {

    ImageButton buttonclose;
    String idQrCode ="";
    String idBat="";

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
                idBat=idQrCode;
                bat.setVisited(true);
                TextView textView = findViewById(R.id.text_bat_name);
                textView.setText(bat.getBat_nom());

                TextView description = findViewById(R.id.text_bat_description);
                description.setText(bat.getBat_description());

                ImageView imageView = findViewById(R.id.imageView2);
                Glide.with(this).load(bat.getBat_id_img()).into(imageView);
            }
        }
        if (!displayed){
            Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainactivity);
            finish();
        }

        //recycler view avec les départements
        ArrayList<Departement> listeDepartement = BDRepository.getDepartementsListe();
        boolean trouve=false;
        for (Departement dept:listeDepartement) {
            if (dept.getDep_mapLocation().contains(idBat)){
                trouve=true;
            }
        }

        FrameLayout fl = (FrameLayout) findViewById(R.id.flbatimentview);
        FrameLayout fl2 = (FrameLayout) findViewById(R.id.flbatimentview2);


        TextView titreDep = (TextView) findViewById(R.id.title_departements);
        LinearLayout container = (LinearLayout) findViewById(R.id.container_departements);
        if (trouve) {
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            MyDepartementAdapter myDepartementAdapter = new MyDepartementAdapter(listeDepartement, DetailBatimentActivity.this, idBat);
            recyclerView.setAdapter(myDepartementAdapter);
        }
        else {
            fl.removeView(titreDep);
            fl2.removeView(container);
        }

        //ETAIENT DANS LE FRAME

        Visite visiteInstance = Visite.getInstance();
        String idBatSuivant = visiteInstance.getBatimentSuivant(idQrCode);

        if (idBatSuivant!=null) {
            String ressourceNom = "";
            String ressourceLienImg = "";
            for (Batiment b : listeBatiments) {
                if (idBatSuivant.equals(b.getBat_id())) {
                    ressourceNom = b.getBat_nom();
                    ressourceLienImg = b.getBat_id_img();
                }
            }

            TextView namebatsuivant = (TextView) findViewById(R.id.batSuivant_name);
            namebatsuivant.setText(ressourceNom);

            ImageView imagesuivant = findViewById(R.id.img_batiment_reco);
            Glide.with(this).load(ressourceLienImg).into(imagesuivant);
        }




        int cpt = 0;
        for (Batiment b: listeBatiments) {
            if (b.isVisited()){
                cpt++;
            }
        }

        TextView bat_visited = (TextView) findViewById(R.id.nb_bat_visited);
        String ressource = "Batiments visités " + cpt + "/" + listeBatiments.size();
        bat_visited.setText(ressource);

        String tmp ="";
        TextView batimentsRestants = (TextView) findViewById(R.id.text_bat_restant);
        for (Batiment b: listeBatiments) {
            if (!b.isVisited()){
                tmp = tmp + b.getBat_nom() + "\n";
            }
        }
        batimentsRestants.setText(tmp);
    }

    @Override
    public void onBackPressed() {
        Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainactivity);
        finish();
    }
}