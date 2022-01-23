package com.example.applicationvisite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

public class QrActivity extends AppCompatActivity {
    private CodeScanner mCodeScanner;
    private Button buttonback;
    String resScan = null;

    //permet de scanner et de décoder un QR code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        //bouton retour à la fenêtre principale
        buttonback = (Button) findViewById(R.id.backToMainActivity);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);
                finish();
            }
        });

        scanQR();
    }

    private void scanQR(){
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.startPreview();

        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                //resultat du scan
                resScan = result.getText();

                //Encapsulation du résultat pour transmission dans la fenêtre suivante
                Bundle bundle = new Bundle();
                bundle.putString("id_decoded",resScan);

                //chargement du bon template en fonction du préfixe de l'id décodé
                if (resScan.startsWith("bat_")){
                    //création de la nouvelle fenêtre
                    Intent detailviewactivity = new Intent(getApplicationContext(), DetailBatimentActivity.class);

                    //ajout de l'encapsulation
                    detailviewactivity.putExtras(bundle);

                    //lancement activité
                    startActivity(detailviewactivity);
                    finish();
                }
                else if (resScan.startsWith("dep_")){
                    //création de la nouvelle fenêtre
                    Intent detailviewactivity = new Intent(getApplicationContext(), DetailDepartementActivity.class);

                    //ajout de l'encapsulation
                    detailviewactivity.putExtras(bundle);

                    //lancement activité
                    startActivity(detailviewactivity);
                    finish();
                }

                else if (resScan.startsWith("al_")){
                    //création de la nouvelle fenêtre
                    Intent detailviewactivity = new Intent(getApplicationContext(), DetailAutreLieuActivity.class);

                    //ajout de l'encapsulation
                    detailviewactivity.putExtras(bundle);

                    //lancement activité
                    startActivity(detailviewactivity);
                    finish();
                }
                else {
                    Intent mainactivity = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(mainactivity);
                    finish();
                }
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCodeScanner.releaseResources();
    }

}
